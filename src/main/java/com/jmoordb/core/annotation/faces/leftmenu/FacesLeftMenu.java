package com.jmoordb.core.annotation.faces.leftmenu;

import com.jmoordb.core.annotation.faces.enumerations.FacesIcon;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesLeftMenu {

    
   boolean overlay() default true;
   String trigger();
   
   String value() default "";
   String id();
   String iconPos() default "right";
   String title();
   String largeCssIcon() default "mr-2 lg:mr-0 mb-0 lg:mb-2 text-base lg:text-2xl";
   String styleClass() default "ui-button-flat";
   FacesIcon facesIcon() default FacesIcon.HOME;

   String my() default "left top";
   String at() default "left bottom";
   public String[] rolesAllowed() ;
   
                 
    
}
