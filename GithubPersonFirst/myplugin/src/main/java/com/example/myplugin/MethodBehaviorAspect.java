package com.example.myplugin;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by HMC on 2018/8/4
 */
@Aspect
public class MethodBehaviorAspect {
    private static final String TAG = "aspect_aby";
    @Pointcut("execution(@com.example.myplugin.IFirstAnnotation * *(..))")
    public void firstMethodAnnotationBehavior() {
        System.out.println("firstMethodAnnotationBehavior");
    }

    @Pointcut("execution(* com.example.myplugin.MainActivity.aspectClick(android.view.View))")
    public void secondMethodAnnotationBehavior() {
        System.out.println("secondMethodAnnotationBehavior");
    }

    @Around("secondMethodAnnotationBehavior()")
    public Object wavePointcutAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("wavePointcutAround");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 类名
        String className = methodSignature.getDeclaringType().getSimpleName();
        // 方法名
        String methodName = methodSignature.getName();
        // 功能名
        IFirstAnnotation behaviorTrace = methodSignature.getMethod()
                .getAnnotation(IFirstAnnotation.class);
        String value = behaviorTrace.value();
//        String value = "点击";
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println(String.format("%s类中%s方法执行%s功能,耗时：%dms", className, methodName, value, duration));
//        Toast.makeText(MyApplication.getContext(), String.format(Locale.CHINESE, "%s类中%s方法执行%s功能,耗时：%dms", className, methodName, value, duration), Toast.LENGTH_SHORT).show();
        return result;
    }


}
