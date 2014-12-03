package hello;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.CarService;

/**
 * Session Bean implementation class TimerTestBean
 */
@Singleton
@Startup
public class TimerTestBean implements TimerTest {
	
	@EJB
	Hello hello;
	
	@EJB
	CarService carService;
	
    /**
     * Default constructor. 
     */
    public TimerTestBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void init(){
    	System.out.println("I'm alive!");
    	System.out.println(hello.sayHi("Timer Singleton"));
    	System.out.println("Car count = "+carService.getCarCount());
    }

	/**
     * @see TimerTest#timedEvent()
     */
	@Schedule(minute="*/2", hour="*")
	public void timedEvent() {
	}

}
