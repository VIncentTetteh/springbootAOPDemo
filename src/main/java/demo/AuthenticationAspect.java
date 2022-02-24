package demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthenticationAspect {
    @Pointcut("within(demo..*)")
    public void authenticationPointCut(){
        System.out.println("authenticating users ");
    }

    @Pointcut("within(demo..*)")
    public void authorizationPointCut(){
        System.out.println("Giving user authority");
    }

    @Before("authenticationPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("Authentication request");
    }
}
