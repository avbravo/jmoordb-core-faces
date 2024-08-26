package com.jmoordb.core.annotation;

import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {

    String value() default "";
    GenerationType strategy() default  GenerationType.NONE;
    String commentary() default "";
}
