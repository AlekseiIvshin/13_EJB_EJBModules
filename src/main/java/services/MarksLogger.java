package services;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MarksLogger {

	@AroundInvoke
	public Object logAction(InvocationContext context) throws Exception{
		System.out.println(context.getTarget().getClass().getCanonicalName()+"."+context.getMethod());
		return context.proceed();
	}
}
