package com.xywei.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.xywei.domain.User;

/**
 * 盲点，1，如何在同一个增强类上设置不同的切点,2，如何给在同一个增强上设置同一个切点的不同通知？
 * 也就是一个切点可以使用多个增强，一个增强可以被既可以被标记为前置、后置、最终通知 ,比如userBefore()既要被作为前置，也要作为最终
 * @author wodoo
 *结论，无法做到多对多配置，没有xml强大
 */
@Aspect
public class UserServiceAdviceAnnotation {

	//@Before(value = "execution(* com.xywei.service.impl.UserServiceImplAnnotation.saveUser(..))")
	// 不能给同一个切点设置不同类型的增强？
	//@After(value = "execution(* com.xywei.service.impl.UserServiceImplAnnotation.saveUser(..))")
	@Before(value="UserServiceAdviceAnnotation.pointcut1()")
//	@Before(value="UserServiceAdviceAnnotation.pointcut2()")
	public void userBefore() {
		System.out.println("前置通知");
	}

	@AfterReturning(value = "execution(* com.xywei.service.impl.UserServiceImplAnnotation.findUser(..))", returning = "result")
	public void userAfterRetruning(User result) {
		System.out.println("后置通知，有异常就不执行，有返回值resutl=" + result);
	}

	public void userAround(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("环绕通知执行方法前");
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕通知执行方法后，方法执行了，只是目标对象方法报错不执行");
	}

//	@After(value = "execution(* com.xywei.service.impl.UserServiceImplAnnotation.saveUser(..))")
	public void userAfter() {
		System.out.println("最终通知，目标类有异常也会执行");
	}

	@AfterThrowing(value="execution(* com.xywei.service.impl.UserServiceImplAnnotation.deleteUser(..))",throwing="throwable")
	public void userAfterThrowing(Throwable throwable) {

		System.out.println("异常抛出通知，有返回异常信息");
		System.out.println("异常类：" + throwable.getClass().getName());
		System.out.println("异常原因:" + throwable.getMessage());
	}
	
	@Pointcut(value="execution(* com.xywei.service.impl.UserServiceImplAnnotation.saveUser(..))")
	private void pointcut1() {
		
	}
	

}
