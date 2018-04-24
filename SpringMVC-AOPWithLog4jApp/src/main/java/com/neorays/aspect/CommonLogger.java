package com.neorays.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CommonLogger {

	 private long start,end;
	  
	  
	  /*  @Pointcut(value="execution(* com.nt.service.ArithmeticOperationService.*(..))")
	     public void myPointcut(){}   THIS IS SIRJI METHOD*/
	    @Pointcut(value="execution(* com.neorays.service.EmpServiceImpl.*(..))")
	     public void myPointcut(){}
	  
		//@Around(value="execution(* com.nt.service.ArithmeticOperationService.*(..))")
	    @Around(value="myPointcut()")
		public  Object   monitor(ProceedingJoinPoint pjp)throws Throwable{
	    	System.out.println("START AROUND ADVICE");
			Object retVal=null;
			start=System.currentTimeMillis();
			retVal=pjp.proceed();
			end=System.currentTimeMillis();
			System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" ms");
			System.out.println(" END AROUND ADVICE");
			return retVal;
		}
		
		//@Before(value="execution(* com.nt.service.ArithmeticOperationService.*(..))")
	    @Before(value="myPointcut()")
		public void before(JoinPoint jp){
			System.out.println("  BEFORE ADVICE");
			System.out.println(" BEFORE ADVICE Before Entering into "+jp.getSignature()+" with args"+Arrays.toString(jp.getArgs()));
		}//before method
		
		
		//@AfterReturning(value="execution(* com.nt.service.ArithmeticOperationService.*(..))",returning="result")
	    @AfterReturning(value="myPointcut()",returning="result")
		public void after(JoinPoint jp,Object result){
			System.out.println(" AFTER  ADVICE");
			System.out.println(" AFTER  ADVICE Exiting from  "+jp.getSignature()+" with args"+Arrays.toString(jp.getArgs()));
		}//after  method
		
		//@AfterThrowing(value="execution(* com.nt.service.ArithmeticOperationService.*(..))",throwing="ae")
	    @AfterThrowing(value="myPointcut()",throwing="ae")
		public  void  exceptionLogger(JoinPoint jp,ArithmeticException  ae ){
			System.out.println(" THROWS ADVICE ADVICE");
			System.out.println(" THROWS ADVICE ADVICE Exception is raised in"+jp.getSignature()+"with args"+Arrays.toString(jp.getArgs())+"and  the exception is"+ae);
			throw new IllegalArgumentException(ae.getMessage());
		}//exception logger
}
