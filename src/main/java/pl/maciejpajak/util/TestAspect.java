package pl.maciejpajak.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class TestAspect {
    
//    @Pointcut("within(@org.springframework.stereotype.Repository *)")
    @Before("within(pl.maciejpajak..*)")
    public void test(JoinPoint joinPoint) {
        System.out.println("XXXXXXXXXXXXXXXXXX szakalaka");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
           System.out.println("Arg: " + signatureArg);
        }
    }
    
    @Pointcut("this(org.springframework.data.repository.Repository)") 
    public void repositoryClassMethods() {}
    
    @Around("this(org.springframework.data.jpa.repository.JpaRepository)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        @Before("this(org.springframework.data.jpa.repository.JpaRepository)")
//    public void logAround(JoinPoint joinPoint) throws Throwable {

        System.out.println("logAround() is running!");
        System.out.println("hijacked method : " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        Object res = joinPoint.proceed(); //continue on the intercepted method
        System.out.println("Around after is running!");

        System.out.println("******");
        return res;
       }

}
