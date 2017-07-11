package com.yifengtec.springboot.hello.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.yifengtec.springboot.hello.annotation.PermissionCheck;

@Aspect
@Component
public class PermissionCheckAdvice {
	
	@Pointcut("@annotation(permissionCheck)")  
    public  void annotationPointCut(PermissionCheck permissionCheck) {  
  
    }  
  
    @Before("annotationPointCut(permissionCheck)")  
    public void before(JoinPoint joinPoint,PermissionCheck permissionCheck){  
        String permission = permissionCheck.value();  
        System.out.print("接受方法："+permission);
        throw new RuntimeException("你没有权限哦");
    }  
}
