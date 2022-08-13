package kz.halykacademy.bookstore.security;

import org.mapstruct.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Component
public class PasswordEncoderMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordEncoderMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @EncodedMapping
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
