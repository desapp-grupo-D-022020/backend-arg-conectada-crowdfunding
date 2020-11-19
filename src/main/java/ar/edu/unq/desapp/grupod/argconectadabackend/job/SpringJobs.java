package ar.edu.unq.desapp.grupod.argconectadabackend.job;

import javax.mail.MessagingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ar.edu.unq.desapp.grupod.argconectadabackend.service.EmailSender;
import ar.edu.unq.desapp.grupod.argconectadabackend.service.ProjectService;

@Component
public class SpringJobs {

	@Autowired
	EmailSender emailSender;
	
	@Autowired
	ProjectService projectService;

	private static final Logger logger = LogManager.getLogger(SpringJobs.class);
	
	private String destinataries[] = { "cristianaranguren@syrfox.com" };

	//@Scheduled(cron = "0 0 0 * * *")
    @Scheduled(cron = "59 * * * * *")
    public void sendDailyEmail() throws MessagingException {
    	this.emailSender.dailyEmail(this.destinataries, projectService.getTopTenDonations(),
    			projectService.getTopTenProjectsWithMoreTimeWithoutDonations());
    	logger.info("SpringJob: Daily email sent");
    }
}