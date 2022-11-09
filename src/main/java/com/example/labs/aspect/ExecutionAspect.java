package com.example.labs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionAspect {

    Logger logger = LoggerFactory.getLogger(ExecutionAspect.class);

    @Around("@annotation(com.example.labs.aspect.ExecutionTime)")
    public Object executionTime(
        ProceedingJoinPoint proceedingJoinPoint
    ) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("Method name" + proceedingJoinPoint.getSignature() + " time taken to execute " + (endTime - startTime));
        return obj;
    }
}
