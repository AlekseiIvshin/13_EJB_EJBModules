package hello;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.jboss.logging.Logger;

import services.CarService;

/**
 * Session Bean implementation class TimerTestBean
 */
@Singleton
@Startup
public class TimerTestBean implements TimerTest {

	private static final Logger logger = Logger.getLogger(TimerTestBean.class);
	
	@EJB
	Hello hello;

	@EJB
	CarService carService;

	@PostConstruct
	void init() {
		logger.debug("I'm alive");
		logger.debug(hello.sayHi("Timer Singleton"));
		logger.debugv("Car count = {0}", carService.getCarCount());
	}
	
	@Schedule(minute = "*/1", hour = "*")
	public void timedEvent() {
		logger.debug("Ping");
	}

}
