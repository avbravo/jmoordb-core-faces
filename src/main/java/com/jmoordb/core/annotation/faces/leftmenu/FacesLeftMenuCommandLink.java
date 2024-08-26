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
public @interface FacesLeftMenuCommandLink {

      FacesIcon facesIcon() default FacesIcon.HOME;
      String action();
      String styleClass() default "flex flex-row lg:flex-column align-items-center cursor-pointer p-3 lg:justify-content-center text-cyan-600 border-left-2 border-cyan-600 hover:border-300 transition-duration-150 transition-colors";
      String title() default "";
      String id();
      public String[] rolesAllowed();
      
      
   
   
   
                 
    
}
