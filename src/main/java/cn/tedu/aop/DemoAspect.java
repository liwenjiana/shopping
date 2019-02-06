package cn.tedu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {
	@Before("bean(userController)")
      public void demo() {
    	   System.out.println("HelloWord");
      }
	@Around("bean(userController)")
	public Object test1(ProceedingJoinPoint pjp) throws Throwable {
		 System.out.println("Around¿ªÊ¼");
		  Object user= pjp.proceed();
		  System.out.println("Around½áÊø"+user);
		  return user;
	}
}
