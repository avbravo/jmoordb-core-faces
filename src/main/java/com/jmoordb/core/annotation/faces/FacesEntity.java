package com.jmoordb.core.annotation.faces;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FacesEntity {

    String controller() default "";

    String layout() default "";

    public String[] rolesAllowed() default "none";

    public String[] saveRolesAllowed() default "none";

    public String[] updateRolesAllowed() default "none";

    public String[] deleteRolesAllowed() default "none";

    String commentary() default "";
}
