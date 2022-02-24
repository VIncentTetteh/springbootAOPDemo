package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeCheckoutLogger(JoinPoint point) throws InterruptedException {
        String args = point.getArgs()[0].toString();
        Thread.sleep(1000);
        System.out.println("Before checkout with arguments " + args);
    }

    @After("execution(* *.*.checkout(..))")
    public void afterCheckoutLogger() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Logging details after checking out");
    }
    @Pointcut("execution(* demo.ShoppingCart.quantity())")
    public void afterReturningPointCut(){

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(int retVal){
        System.out.println("Returning value with " + retVal);
    }

}
