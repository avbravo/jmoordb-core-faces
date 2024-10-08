package com.jmoordb.core.annotation.faces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesDialog {

    String value() default "";

    String commentary() default "";

    boolean generateQuery() default false;
}
