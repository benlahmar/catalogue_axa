package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
//@Service
public class JournalisationAspect {

	  //static Logger logger = Logger.getLogger(JournalisationAspect.class);

	@Before("execution(* *.addCategorie(..))")
	public void info(JoinPoint jp)
	{
		
		System.out.println("avant appel a la methode "+jp.getSignature().getName());
	}
	
	@After("execution(* com.example.demo.busness.ICatalogue.addCategorie(..))")
	public void info2()
	{
		System.out.println("fin appel a la methode");
	}
}
