package com.xywei.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.xywei.domain.User;

public class UserServiceAdvice {

	public void userBefore() {
		System.out.println("前置通知");
	}

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

	public void userAfter() {
		System.out.println("最终通知，目标类有异常也会执行");
	}

	public void userAfterThrowing(Throwable throwable) {

		System.out.println("异常抛出通知，有返回异常信息");
		System.out.println("异常类：" + throwable.getClass().getName());
		System.out.println("异常原因:" + throwable.getMessage());
	}

}
