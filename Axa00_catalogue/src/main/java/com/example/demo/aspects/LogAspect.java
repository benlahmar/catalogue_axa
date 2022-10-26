package com.example.demo.aspects;

import java.awt.Point;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class LogAspect {

	Logger  log=LogManager.getLogger(LogAspect.class);
	@Before("execution(* com.example.demo.repos.ICategorie.save(..) )")
	public void login()
	{
		System.out.println("appel a la method");
	}
	
	@After("execution(* *.save(..) )")
	public void login2(JoinPoint jp)
	{
		Signature s = jp.getSignature();
		
		System.out.println("fin de l'appel a la method "+s.getName());
		for (Object o : jp.getArgs()) {
			System.out.println("arg   " +o.toString());
		}
	}
	
	@AfterThrowing(pointcut = "execution(* *.*(..) )",
			throwing ="excp" )
	public void exceptionhandler(JoinPoint jp, Throwable excp)
	{
		//traitement 
		
	}
	
	@AfterReturning(pointcut = "execution(* *.allcats(..) )",
			returning = "res")
	public void login3( JoinPoint jp, Object res)
	{
		System.out.println("*****");
		System.out.println("res" + res.toString());
	}
	
}
