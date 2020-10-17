package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	/**
	 * Servicio de Java para el envio de e-mails.
	 */
    @Autowired
    private JavaMailSender emailSender;
	
	/**
	 * Envia un email 
	 */
    public void closeProjectEmail(String to, String nickName) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);

        msg.setSubject("Proyecto Financiado!!");
        msg.setText("\nHola" + nickName + ", gracias a su donacion y a la de muchas personas más,  se iniciarán las obras en dicha localidad");

        emailSender.send(msg);
    }
}
