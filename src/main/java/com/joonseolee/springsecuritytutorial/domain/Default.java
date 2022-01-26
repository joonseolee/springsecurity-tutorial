package com.joonseolee.springsecuritytutorial.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 어떤 생성자를 기본으로써 사용할지 mapstruct 한테 알려줌.
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.CLASS)
public @interface Default {
}
