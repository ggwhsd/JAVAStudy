package com.gugwexample.demo1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Component //让spring容器管理这个bean
@Aspect    //告诉spring这是个aop
public class MyAdvice {
	//定义切入点：在哪个类的哪个函数执行时触发
	@Pointcut("execution(void com.gugwexample.demo1.BookService.save())")
	private void pt() {}
	
	@Pointcut("execution(double com.gugwexample.demo1.BookService.price())")
	private void pt2() {}
	
	@Pointcut("execution(double com.gugwexample.demo1.BookService.*(double))")
	private void pt3() {}
	
	@Around("pt3()")
	public Object around4(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("aop : myadvice.around3 before");
		double ret = 0;
		try {
		Object[] args =	proceedingJoinPoint.getArgs();
		 ret =(double)proceedingJoinPoint.proceed(args);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("aop : myadvice.around3 after");
		return ret+1000;
	}
	
	//指定在切入点的时机：定义在切入点pt 执行函数的前调用如下函数。
	@Before("pt()")
	public void before()
	{
		System.out.println("aop : myadvice.before");
	}
	
	@After("pt()")
	public void after()
	{
		System.out.println("aop : myadvice.after");
	}
	
	@Around("pt()")
	public void around(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("aop : myadvice.around before");
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("aop : myadvice.around after");
	}
	
	@AfterReturning("pt()")
	public void afterRunning()
	{
		System.out.println("aop : myadvice.afterRunning");
	}
	
	@Around("pt2()")
	public Object around2(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("aop : myadvice.around2 before");
		double ret = 0;
		try {
		 ret =(double)proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("aop : myadvice.around2 after");
		return 1+ret;
	}
	@Around("pt2()")
	public Object around3(ProceedingJoinPoint proceedingJoinPoint)
	{
		System.out.println("aop : myadvice.around3 before");
		
		double ret = 0;
		long start = System.nanoTime();
		
			try {
			 ret =(double)proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		
		long end = System.nanoTime();
		System.out.println("aop : myadvice.around3 after " + (end-start)/10e5);
		return 1+ret;
	}
	
}
