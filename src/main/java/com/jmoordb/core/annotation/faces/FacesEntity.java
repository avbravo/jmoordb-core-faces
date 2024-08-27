package com.jmoordb.core.annotation.faces;

import com.jmoordb.core.annotation.faces.enumerations.GenerateController;
import com.jmoordb.core.annotation.faces.enumerations.RegenerationCode;
import com.jmoordb.core.annotation.faces.enumerations.TypeForm;
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
    
    String title() default "";

    public String[] rolesAllowed() default {"ALL"};

    public String[] saveRolesAllowed() default {"ALL"};

    public String[] updateRolesAllowed() default {"ALL"};

    public String[] deleteRolesAllowed() default {"ALL"};

    String commentary() default "";

    TypeForm typeForm();
   
    RegenerationCode regeneration() default RegenerationCode.YES;
    
    GenerateController generateController() default GenerateController.YES;
    
    
}
