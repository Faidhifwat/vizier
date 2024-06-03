package com.sultan.vizier.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class LogExecutionTimeAspect {

    private final Logger logger = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant before = Instant.now();

        logger.info(String.format("Executing %s", joinPoint.toShortString()));
        Object proceed = joinPoint.proceed();

        Instant after = Instant.now();

        logger.info(String.format("%s executed in %s ms", joinPoint.toShortString(), Duration.between(before, after).toMillis()));

        return proceed;
    }
}
