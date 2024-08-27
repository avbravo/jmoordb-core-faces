package com.jmoordb.core.annotation.faces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesEntitySubmenu {

    String controller() default "";

    String layout() default "";

    public String[] rolesAllowed() default {"ALL"};

    public String[] saveRolesAllowed() default {"ALL"};

    public String[] updateRolesAllowed() default {"ALL"};

    public String[] deleteRolesAllowed() default {"ALL"};

    String commentary() default "";

    String menuIcon();

    String menuAction();

    String menuLabel();

    String menuBarPather();
    
    
}
