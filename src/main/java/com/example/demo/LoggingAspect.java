package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	
	/*
	 * @Before("execution(* com.example.demo.service.*.*(..))") // Pointcut
	 * expression public void logBefore(JoinPoint joinPoint) {
	 * System.out.println("Before executing method: " +
	 * joinPoint.getSignature().getName()); }
	 * 
	 * @After("execution(* com.example.demo.service.*.*(..))") // Pointcut
	 * expression public void logAter(JoinPoint joinPoint) {
	 * System.out.println("After executing method: " +
	 * joinPoint.getSignature().getName()); }
	 * 
	 * // AfterReturning advice (runs only if method returns successfully)
	 * 
	 * @AfterReturning(pointcut = "execution(* com.example.demo.service.*.*(..))",
	 * returning = "result") public void logAfterReturning(JoinPoint joinPoint,
	 * Object result) { System.out.println("Method " +
	 * joinPoint.getSignature().getName() + " returned: " + result); }
	 * 
	 * // AfterThrowing advice (runs only if method throws an exception)
	 * 
	 * @AfterThrowing(pointcut = "execution(* com.example.demo.service.*.*(..))",
	 * throwing = "ex") public void logAfterThrowing(JoinPoint joinPoint, Throwable
	 * ex) { System.out.println("Method " + joinPoint.getSignature().getName() +
	 * " threw exception: " + ex); }
	 */

    // Around advice (wraps method execution, allows pre/post logic and control)
    @Around("execution(String com.example.demo.service.TestService.putTestService(String))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around BEFORE: " + joinPoint.getSignature().getName());
        
        long start = System.currentTimeMillis();
        
        
        Object result;
        try {
        	
            result = joinPoint.proceed(); // execute the method
            System.out.println("Around AFTER: " + joinPoint.getSignature().getName());
        } catch (Throwable ex) {
            System.out.println("Around EXCEPTION in: " + joinPoint.getSignature().getName() + " -> " + ex);
            throw ex; // rethrow to propagate
        }
        
        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Method " + joinPoint.getSignature().getName() +
                " executed in " + duration + " ms");

        
        return result;
    }

}
