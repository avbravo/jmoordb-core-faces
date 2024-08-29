/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.core.faces.processor.facesentity;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.faces.enumerations.GenerateController;
import com.jmoordb.core.annotation.faces.enumerations.RegenerationCode;
import com.jmoordb.core.annotation.faces.enumerations.TypeForm;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author avbravo Se utiliza para gestionar los datos leidos del repositorio
 */
public class FacesEntityData {

    String controller;

    String layout;

    String title;

    String[] rolesAllowed;

    String[] saveRolesAllowed;

    String[] updateRolesAllowed;

    String[] deleteRolesAllowed;

    String commentary;

    TypeForm typeForm;

    RegenerationCode regeneration;

    GenerateController generateController;

    public FacesEntityData() {
    }

    public FacesEntityData(String controller, String layout, String title, String[] rolesAllowed, String[] saveRolesAllowed, String[] updateRolesAllowed, String[] deleteRolesAllowed, String commentary, TypeForm typeForm, RegenerationCode regeneration, GenerateController generateController) {
        this.controller = controller;
        this.layout = layout;
        this.title = title;
        this.rolesAllowed = rolesAllowed;
        this.saveRolesAllowed = saveRolesAllowed;
        this.updateRolesAllowed = updateRolesAllowed;
        this.deleteRolesAllowed = deleteRolesAllowed;
        this.commentary = commentary;
        this.typeForm = typeForm;
        this.regeneration = regeneration;
        this.generateController = generateController;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getRolesAllowed() {
        return rolesAllowed;
    }

    public void setRolesAllowed(String[] rolesAllowed) {
        this.rolesAllowed = rolesAllowed;
    }

    public String[] getSaveRolesAllowed() {
        return saveRolesAllowed;
    }

    public void setSaveRolesAllowed(String[] saveRolesAllowed) {
        this.saveRolesAllowed = saveRolesAllowed;
    }

    public String[] getUpdateRolesAllowed() {
        return updateRolesAllowed;
    }

    public void setUpdateRolesAllowed(String[] updateRolesAllowed) {
        this.updateRolesAllowed = updateRolesAllowed;
    }

    public String[] getDeleteRolesAllowed() {
        return deleteRolesAllowed;
    }

    public void setDeleteRolesAllowed(String[] deleteRolesAllowed) {
        this.deleteRolesAllowed = deleteRolesAllowed;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public TypeForm getTypeForm() {
        return typeForm;
    }

    public void setTypeForm(TypeForm typeForm) {
        this.typeForm = typeForm;
    }

    public RegenerationCode getRegeneration() {
        return regeneration;
    }

    public void setRegeneration(RegenerationCode regeneration) {
        this.regeneration = regeneration;
    }

    public GenerateController getGenerateController() {
        return generateController;
    }

    public void setGenerateController(GenerateController generateController) {
        this.generateController = generateController;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.controller);
        hash = 53 * hash + Objects.hashCode(this.layout);
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Arrays.deepHashCode(this.rolesAllowed);
        hash = 53 * hash + Arrays.deepHashCode(this.saveRolesAllowed);
        hash = 53 * hash + Arrays.deepHashCode(this.updateRolesAllowed);
        hash = 53 * hash + Arrays.deepHashCode(this.deleteRolesAllowed);
        hash = 53 * hash + Objects.hashCode(this.commentary);
        hash = 53 * hash + Objects.hashCode(this.typeForm);
        hash = 53 * hash + Objects.hashCode(this.regeneration);
        hash = 53 * hash + Objects.hashCode(this.generateController);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FacesEntityData other = (FacesEntityData) obj;
        if (!Objects.equals(this.controller, other.controller)) {
            return false;
        }
        if (!Objects.equals(this.layout, other.layout)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.commentary, other.commentary)) {
            return false;
        }
        if (!Arrays.deepEquals(this.rolesAllowed, other.rolesAllowed)) {
            return false;
        }
        if (!Arrays.deepEquals(this.saveRolesAllowed, other.saveRolesAllowed)) {
            return false;
        }
        if (!Arrays.deepEquals(this.updateRolesAllowed, other.updateRolesAllowed)) {
            return false;
        }
        if (!Arrays.deepEquals(this.deleteRolesAllowed, other.deleteRolesAllowed)) {
            return false;
        }
        if (this.typeForm != other.typeForm) {
            return false;
        }
        if (this.regeneration != other.regeneration) {
            return false;
        }
        return this.generateController == other.generateController;
    }

    @Override
    public String toString() {
        return "FacesEntityData{" + "controller=" + controller + ", layout=" + layout + ", title=" + title + ", rolesAllowed=" + rolesAllowed + ", saveRolesAllowed=" + saveRolesAllowed + ", updateRolesAllowed=" + updateRolesAllowed + ", deleteRolesAllowed=" + deleteRolesAllowed + ", commentary=" + commentary + ", typeForm=" + typeForm + ", regeneration=" + regeneration + ", generateController=" + generateController + '}';
    }

    
    
    
      public static class Builder {

      String controller;

    String layout;

    String title;

    String[] rolesAllowed;

    String[] saveRolesAllowed;

    String[] updateRolesAllowed;

    String[] deleteRolesAllowed;

    String commentary;

    TypeForm typeForm;

    RegenerationCode regeneration;

    GenerateController generateController;

        public Builder controller(String controller) {
            this.controller = controller;
            return this;
        }
        public Builder layout(String layout) {
            this.layout = layout;
            return this;
        }
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        public Builder rolesAllowed( String[] rolesAllowed) {
            this.rolesAllowed = rolesAllowed;
            return this;
        }
        public Builder saveRolesAllowed( String[] rolesAllowed) {
            this.saveRolesAllowed = saveRolesAllowed;
            return this;
        }
        public Builder updateRolesAllowed( String[] updateRolesAllowed) {
            this.updateRolesAllowed = updateRolesAllowed;
            return this;
        }
        public Builder deleteRolesAllowed( String[] deleteRolesAllowed) {
            this.deleteRolesAllowed = deleteRolesAllowed;
            return this;
        }
        public Builder commentary( String commentary) {
            this.commentary= commentary;
            return this;
        }
        public Builder typeForm( TypeForm typeForm) {
            this.typeForm= typeForm;
            return this;
        }
        public Builder regeneration( RegenerationCode regeneration) {
            this.regeneration= regeneration;
            return this;
        }
        public Builder generateController( GenerateController generateController) {
            this.generateController= generateController;
            return this;
        }

 



        public FacesEntityData build() {
            return new FacesEntityData(controller, layout, title, rolesAllowed, saveRolesAllowed, updateRolesAllowed, deleteRolesAllowed, commentary, typeForm, regeneration, generateController);

        }
    }
    
}
