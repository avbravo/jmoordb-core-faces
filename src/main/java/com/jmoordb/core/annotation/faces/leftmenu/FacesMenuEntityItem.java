package com.jmoordb.core.annotation.faces.leftmenu;

import com.jmoordb.core.annotation.faces.enumerations.FacesIcon;
import com.jmoordb.core.annotation.faces.enumerations.RegenerationCode;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesMenuEntityItem {
 String value() default "";

    String title();

    FacesIcon facesIcon() default FacesIcon.HOME;

    String id() default "";

    String action();

    String subMenuFather();

    public String[] rolesAllowed() default {"ALL"};
    
    RegenerationCode regeneration() default RegenerationCode.YES;
}
