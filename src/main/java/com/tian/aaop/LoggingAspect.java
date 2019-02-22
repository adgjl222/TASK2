package com.tian.aaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Date;

//日志切面
public class LoggingAspect {

    //JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.
    public void beforeMethod(JoinPoint point){

        //point.getSignature().getName() 拦截的方法名称
        System.out.println("正在执行方法:"+point.getSignature().getName()+System.currentTimeMillis());

    }

    public void afterMethod(JoinPoint point){
        System.out.println(point.getSignature().getName()+"方法执行结束");

    }

    public void afterReturningMethod(JoinPoint point,Object retVal){
        System.out.println("方法： "+ point.getSignature().getName()+ "执行结果为："+ retVal+ System.currentTimeMillis());
    }

    public void afterThrowingMethod(JoinPoint point,Exception ex) {
        System.out.println("执行方法： " + point.getSignature().getName() + "出现异常：" + ex.getMessage());
    }





    //ProceedingJoinPoint 环绕通知 环绕通知=前置+目标方法执行+后置通知
    public Object aroundMethod(ProceedingJoinPoint point) {
        Long start = System.currentTimeMillis();
        System.out.println("开始时间：" + start);
        System.out.println("环绕通知： " + point.getSignature().getName());
        Object result = null;
        //这里相当于前置通知
        try {

            //执行方法 proceed方法就是用于启动目标方法执行的
            result = point.proceed();

            //这里相当于结果通知
        } catch (Throwable e) {
            //这里相当于异常通知
            e.printStackTrace();

        }
        //这里相当于后置通知
        Long end = System.currentTimeMillis();
        System.out.println("结束时间：" + end);
        System.out.println("环绕通知： " + point.getSignature().getName());
        System.out.println("执行时间为："+ (end - start)+"ms");
        return result;
    }
}
