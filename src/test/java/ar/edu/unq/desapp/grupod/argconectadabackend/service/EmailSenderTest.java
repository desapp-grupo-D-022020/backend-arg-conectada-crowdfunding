package ar.edu.unq.desapp.grupod.argconectadabackend.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailSenderTest {
	
	@InjectMocks
	private EmailSender mailSender;
	
	@Mock
	private JavaMailSender javaMailSender;
	
	@Captor
    ArgumentCaptor<SimpleMailMessage> msgCaptor;
 
	
	@Test
	void testSendEmailCallsSendMethod() {
		MockitoAnnotations.initMocks(this);
		
		String to = "receiver@unq.edu.ar";
		String nickName = "senderNick";
		mailSender.closeProjectEmail(to, nickName);
		
		verify(javaMailSender).send(any(SimpleMailMessage.class));
		
	}
	
	@Test
	void testSendEmailWithCorrectAttributes() {
		MockitoAnnotations.initMocks(this);
		
		String to = "receiver@unq.edu.ar";
		String nickName = "senderNick";
		mailSender.closeProjectEmail(to, nickName);
		
		
		verify(javaMailSender).send(msgCaptor.capture());
		
		SimpleMailMessage message = msgCaptor.getValue();
		String[] sender = message.getTo();
		String text = message.getText();
		String subject = message.getSubject();
		
		assertEquals("receiver@unq.edu.ar", sender[0]);
		assertEquals("Proyecto Financiado!!", subject);
		assertTrue(text.contains("senderNick"));
		
	}
	
	
}
