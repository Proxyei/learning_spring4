package com.xywei.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import com.xywei.domain.User;

public class UserServiceAdvice {

	public void userBefore() {
		System.out.println("前置通知");
	}

	public void userAfterRetruning(User result) {
		System.out.println("后置通知，有返回值resutl=" + result);
	}

	public void userAround(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("环绕通知只想方法前");
		try {
			proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("环绕通知只想方法后");
	}

	public void userAfter() {
		System.out.println("最终通知");
	}

	public void userAfterThrowing(Throwable throwable) {

		System.out.println("异常通知，有返回异常信息");
		System.out.println("异常类："+throwable.getClass().getName());
		System.out.println("异常原因:"+throwable.getMessage());
	}

}
