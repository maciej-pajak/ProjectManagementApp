package pl.maciejpajak.util;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import pl.maciejpajak.entity.Activity;
import pl.maciejpajak.entity.BaseEntity;
import pl.maciejpajak.entity.User;
import pl.maciejpajak.repository.ActivityRepository;

@Aspect
@Component
public class LoggingAspect {
    
    @Autowired
    private ActivityRepository repo;

    @AfterReturning(pointcut = "execution(* pl.maciejpajak.service..create*(..)) "
            + "|| execution(* pl.maciejpajak.service..update*(..)) "
            + "|| execution(* pl.maciejpajak.service..close*(..))",
            returning = "retVal")
    public void tests(JoinPoint jp, BaseEntity retVal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser currentUser = (CurrentUser) auth.getPrincipal();
        User u = new User();
        u.setId(currentUser.getId());
        
        String methodName = jp.getSignature().getName();
        String[] splitted = methodName.split("(?<=[a-z])(?=[A-Z(])"); 
        
        Activity a = new Activity(LocalDateTime.now(), u, retVal.getId(), retVal.getClass(), splitted[0].toUpperCase());
        repo.save(a);
    }
}
