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
 * Aop代理分动态/静态代理两种
 * 静态Aop为AspectJ,忽略掉(编译阶段增强)
 * SpringAop属于动态代理AOP（内存中“临时”生成 AOP 动态代理类，因此也被称为运行时增强）
 * Spring Aop = AspectJ的注解 + cglib/jdk
 * 接口   ==>jdk
 * 类    ==> cglib
 * <p>
 * <p>
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
        System.out.println("前置通知" + name);
    }

    @Around("anyMethod() ")
    public void around(ProceedingJoinPoint pjp) {
        try {
            Object[] args = pjp.getArgs();
            Signature sig = pjp.getSignature();
            System.out.println("Aroud---------------");
            Object re = pjp.proceed(args);
            /** 这里从类名可以看出spring用的到底是cglib/jdk 代理 */
            System.out.println(pjp.getThis().getClass().getName());
            logger.debug("around=> para:{} , re:{},signature:{}", args, re, sig);
            logger.debug("type:{}", sig.getDeclaringType().getName());
            logger.debug("typeName:{}", sig.getDeclaringTypeName());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
