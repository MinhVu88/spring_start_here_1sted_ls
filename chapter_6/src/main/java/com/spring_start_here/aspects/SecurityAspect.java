package com.spring_start_here.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1) // specifies an execution order position for the aspect.
public class SecurityAspect {
	private static final Logger logger = Logger.getLogger(SecurityAspect.class.getName());

	@Around(value = "@annotation(com.spring_start_here.annotations.ToLog2)")
	public Object secure(ProceedingJoinPoint methodExecution) throws Throwable {
		String methodName = methodExecution.getSignature().getName();

		logger.info("before intercepting " + methodName);

		try {
			Object returnedValue = methodExecution.proceed();
						
			logger.info(
				"after intercepting " + methodName + " | " +
				"value returned: " + returnedValue
			);

			return returnedValue;	
		} catch(Throwable e) {
			logger.severe(e.getMessage());
			throw e;
		}
	}
}
