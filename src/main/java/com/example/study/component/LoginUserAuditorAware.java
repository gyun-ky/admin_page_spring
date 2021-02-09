package com.example.study.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {  //로그인한 사용자를 감시하는 역할
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer"); //로그인 시스템이 없어서? -> 각 entitiy에 annotation 달아준다

        //@createdBy @LastModifiedBy 가 들어간 아이들은 AdminServer라는 아이를 반영 받게 되어 있다
    }
}

