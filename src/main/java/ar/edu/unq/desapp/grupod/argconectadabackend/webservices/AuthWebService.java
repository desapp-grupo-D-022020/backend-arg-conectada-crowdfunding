package ar.edu.unq.desapp.grupod.argconectadabackend.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unq.desapp.grupod.argconectadabackend.dto.JwtDto;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.Message;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.NewUser;
import ar.edu.unq.desapp.grupod.argconectadabackend.dto.UserLogin;
import ar.edu.unq.desapp.grupod.argconectadabackend.enums.RolName;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Rol;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.User;
import ar.edu.unq.desapp.grupod.argconectadabackend.security.JWT.JwtProvider;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.RolService;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthWebService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/newUser")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("empty fields or invalid email"), HttpStatus.BAD_REQUEST);
        if(userService.existByName(newUser.getUserName()))
            return new ResponseEntity(new Message("that name already exists"), HttpStatus.BAD_REQUEST);
        if(userService.existByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("that email already exists"), HttpStatus.BAD_REQUEST);
        User user =
                new User(newUser.getName(), passwordEncoder.encode(newUser.getPassword()),
                		 newUser.getEmail(), newUser.getUserName());
        Set<String> rolesStr = newUser.getRoles();
        Set<Rol> roles = new HashSet<>();
        for (String rol : rolesStr) {
            switch (rol) {
                case "admin":
                    Rol rolAdmin = rolService.getByRolName(RolName.ROLE_ADMIN).get();
                    roles.add(rolAdmin);
                    break;
                default:
                    Rol rolUser = rolService.getByRolName(RolName.ROLE_USER).get();
                    roles.add(rolUser);
            }
        }
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new Message("user saved"), HttpStatus.CREATED);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult){
        
    	if(bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("empty fields or invalid email"), HttpStatus.BAD_REQUEST);
        }
        
        Authentication authentication;
        UsernamePasswordAuthenticationToken userPassAuthToken;
        userPassAuthToken = new UsernamePasswordAuthenticationToken(
        						userLogin.getUserName(), userLogin.getPassword(), null
        					);
        
        authentication = authenticationManager.authenticate(userPassAuthToken);
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
    }
}