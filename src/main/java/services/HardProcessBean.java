package services;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
@Startup
@AccessTimeout(value = 15, unit = TimeUnit.SECONDS)
@DependsOn("ConfigBean")
public class HardProcessBean implements HardProcess {
	private final static Logger logger = LoggerFactory
			.getLogger(HardProcessBean.class);

	@PostConstruct
	void init() {
		logger.info("Construct HardProceesBean");
	}

	@Asynchronous
	@Override
	public Future<String> process(String value) {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("Step " + i + " for " + value);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			return new AsyncResult<String>("error");
		}
		return new AsyncResult<String>(value);
	}

}
