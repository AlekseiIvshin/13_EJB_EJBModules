package services;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarksLogger {

	private final static Logger logger = LoggerFactory
			.getLogger(MarksLogger.class);

	@AroundInvoke
	public Object logAction(InvocationContext context) throws Exception {
		logger.info("INVOKE {}", context.getMethod());
		return context.proceed();
	}
}
