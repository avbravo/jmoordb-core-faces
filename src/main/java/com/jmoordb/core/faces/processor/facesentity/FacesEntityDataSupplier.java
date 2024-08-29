/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.faces.processor.facesentity;

import com.jmoordb.core.annotation.faces.FacesEntity;
import com.jmoordb.core.util.MessagesUtil;
import java.util.function.Supplier;
import javax.lang.model.element.Element;

/**I
 *
 * @author avbravo
 */
public class FacesEntityDataSupplier {
// <editor-fold defaultstate="collapsed" desc="FacesEntityData get(Supplier<? extends FacesEntityData> s, Element element)">

    public FacesEntityData get(Supplier<? extends FacesEntityData> s, Element element) {
        FacesEntityData facesEntityData = s.get();
        try {

            FacesEntity facesEntity = element.getAnnotation(FacesEntity.class);
    
          
            facesEntityData = new FacesEntityData.Builder()
                    .commentary(facesEntity.commentary())
                    .controller(facesEntity.controller())
                    .deleteRolesAllowed(facesEntity.deleteRolesAllowed())
                    .generateController(facesEntity.generateController())
                    .layout(facesEntity.layout())
                    .regeneration(facesEntity.regeneration())
                    .rolesAllowed(facesEntity.rolesAllowed())
                    .saveRolesAllowed(facesEntity.saveRolesAllowed())
                    .title(facesEntity.title())
                    .typeForm(facesEntity.typeForm())
                    .updateRolesAllowed(facesEntity.updateRolesAllowed())
                    .build();
            
            

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return facesEntityData;
    }
    // </editor-fold>

}
