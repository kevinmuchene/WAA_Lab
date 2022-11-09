package com.example.labs.aspect;

import com.example.labs.domain.Logger;
import com.example.labs.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;

import java.util.Date;

public class LoggerAspect {

    private LoggerRepo loggerRepo;

    public void logging(JoinPoint joinPoint){
        var log = Logger.builder()
                .dateAndTime(new Date())
                .principle("Kevin")
                .operation(joinPoint.getSignature().getName())
                .build();

        loggerRepo.save(log);
    }
}
