package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import ar.edu.unq.desapp.grupod.argconectadabackend.model.Donation;
import ar.edu.unq.desapp.grupod.argconectadabackend.model.Project;

@Service
public class EmailSender {

	/**
	 * Servicio de Java para el envio de e-mails.
	 */
    @Autowired
    private JavaMailSender emailSender;
    
    @Autowired
	private SpringTemplateEngine templateEngine;
	
    
    @Async
    public void closeProjectEmail(String to, String nickName) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);

        msg.setSubject("Proyecto Financiado!!");
        msg.setText("\nHola " + nickName + " , gracias a su donacion y a la de muchas personas más,  se iniciarón las obras en dicha localidad");

        emailSender.send(msg);
    }
    
    @Async
	public void dailyEmail(String[] destinataries, List<Donation> donations
			, List<Project> projects) throws MessagingException {
    	
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		Context ctx = new Context();
		ctx.setVariable("donations", donations);
		ctx.setVariable("projects", projects);

		final String content = this.templateEngine.process("template_daily_email.html", ctx);
	
		helper.setTo(destinataries);
		helper.setSubject("Tops diarios de Argentina Conectada");
		helper.setText(content, true);
		
		this.emailSender.send(message);
	}
    
}
