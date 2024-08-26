package com.jmoordb.core.annotation.faces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesInputTextArea {

    String commentary() default "";

    String label() default "";
    
    int rows() default 2;
    
    int cols() default 120;
    
    String component() default "";
    
    String id() default "";
}
