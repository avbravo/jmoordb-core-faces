package com.jmoordb.core.annotation.faces.leftmenu;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesMenuSeparator {

 public String[] rolesAllowed() default {"ALL"};
   
   
                 
    
}
