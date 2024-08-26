package com.jmoordb.core.annotation.faces.leftmenu;

import com.jmoordb.core.annotation.faces.enumerations.FacesIcon;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesLeftMenuItem {

    
   String  value();
   String  title();
   String[] rolesAllowed();
     FacesIcon facesIcon() default FacesIcon.HOME;
   String id();
   String action();
   String menuFather();
                 
    
}
