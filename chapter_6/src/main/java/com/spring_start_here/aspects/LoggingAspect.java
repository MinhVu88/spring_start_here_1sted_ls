package com.spring_start_here.aspects;

import java.util.Arrays;
import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import com.spring_start_here.models.Comment;

// The @Aspect annotation isn’t a stereotype annotation.
// Spring doesn't automatically create a bean for this class just because it's annotated as @Aspect.
@Aspect
@Order(2) // 2 means LoggingAspect is executed after SecurityAspect. 
public class LoggingAspect {
	private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

	// Use @Around (an advice annotation) to tell Spring when & which method calls to intercept.
	// The value of the annotation is the AspectJ pointcut language.
	@Around("execution(* com.spring_start_here.services.*.publishComment1(..))")
	public void log0(ProceedingJoinPoint interceptedMethod) throws Throwable {
		try {
			logger.info("before the intercepted method executes");
			interceptedMethod.proceed(); // The intercepted method is called.
			logger.info("after the intercepted method executes");
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}

	@Around("execution(* com.spring_start_here.services.*.publishComment2(..))")
	public Object log1(ProceedingJoinPoint interceptedMethod) throws Throwable {
		String methodName = interceptedMethod.getSignature().getName();
		Object[] methodArgs = interceptedMethod.getArgs();
		
		logger.info(
			"before the intercepted method (" + methodName + ") executes | " + 
			"params/args: " + Arrays.asList(methodArgs)
		);

		try {
			Object returnedValue = interceptedMethod.proceed();
						
			logger.info(
				"after the intercepted method (" + methodName + ") executes | " +
				"value returned: " + returnedValue
			);

			return returnedValue;	
		} catch(Throwable e) {
			logger.severe(e.getMessage());
			throw e;
		}
	}

	@Around("execution(* com.spring_start_here.services.*.publishComment2(..))")
	public Object log2(ProceedingJoinPoint interceptedMethod) throws Throwable {
		String methodName = interceptedMethod.getSignature().getName();
		Object[] methodArgs0 = interceptedMethod.getArgs();
		
		logger.info(
			"before intercepting " + methodName + " | " + 
			"params/args: " + Arrays.asList(methodArgs0)
		);

		Object[] methodArgs1 = {new Comment("CommentService1", "publishComment2")};

		try {
			Object returnedValue = interceptedMethod.proceed(methodArgs1);
						
			logger.info(
				"after intercepting " + methodName + " | " +
				"value returned: " + returnedValue
			);

			return "FAILED";	
		} catch(Throwable e) {
			logger.severe(e.getMessage());
			throw e;
		}
	}

	@Around("@annotation(com.spring_start_here.annotations.ToLog0)")
	public Object log3(ProceedingJoinPoint interceptedMethod) throws Throwable {
		String methodName = interceptedMethod.getSignature().getName();
		Object[] methodArgs = interceptedMethod.getArgs();
		
		logger.info(
			"before intercepting " + methodName + " | " + 
			"params/args: " + Arrays.asList(methodArgs)
		);

		try {
			Object returnedValue = interceptedMethod.proceed();
						
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

	@AfterReturning(
		value = "@annotation(com.spring_start_here.annotations.ToLog1)",
		returning = "returnedValue"
	)
	public void log4(Object returnedValue) {
		logger.info("the intercepted method executed and returned " + returnedValue);
	}

	@Around(value = "@annotation(com.spring_start_here.annotations.ToLog2)")
	public Object log5(ProceedingJoinPoint methodExecution) throws Throwable {
		String methodName = methodExecution.getSignature().getName();

		logger.info("before intercepting " + methodName);

		try {
			// proceed() here either calls the next aspect method or 
			// the intercepted method in the aspect execution chain.
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
