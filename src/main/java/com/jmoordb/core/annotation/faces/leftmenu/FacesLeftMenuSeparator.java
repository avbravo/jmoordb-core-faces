package com.jmoordb.core.annotation.faces.leftmenu;

import com.jmoordb.core.annotation.faces.enumerations.FacesIcon;
import com.jmoordb.core.annotation.faces.enumerations.TypeFacesEntity;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesLeftMenuSeparator {

 public String[] rolesAllowed() default "none";  
   
   
                 
    
}
