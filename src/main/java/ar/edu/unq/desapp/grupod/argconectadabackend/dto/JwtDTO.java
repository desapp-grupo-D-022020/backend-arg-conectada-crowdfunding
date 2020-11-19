package ar.edu.unq.desapp.grupod.argconectadabackend.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtDTO  {
    private String token;
    private String bearer = "Bearer";
    private String userName;
    private UserDTO user;
    private Collection<? extends GrantedAuthority> authorities;
   
    public JwtDTO(String token, String userName, UserDTO user, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.userName = userName;
        this.user = user;
        this.authorities = authorities;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}