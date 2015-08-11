package psyco.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by lipeng on 15/8/11.
 */
@Aspect
@Component
public class Aspects {
    private static Logger logger = LoggerFactory.getLogger(Aspects.class);

    /***
     * 定义一个切入点
     */
    @Pointcut("execution(* TestClass.*(..))")
    private void anyMethod() {
    }


    @Before("anyMethod() && args(name)")
    public void doAccessCheck(String name) {
        System.out.println(name);
        System.out.println("前置通知");
    }

    @Around("anyMethod() ")
    public void around(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            Signature sig = pjp.getSignature();
            Object re = pjp.proceed(args);
            logger.debug("around=> para:{} , re:{},signature:{}", args, re, sig);
            logger.debug("type:{}", sig.getDeclaringType().getName());
            logger.debug("typeName:{}", sig.getDeclaringTypeName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
