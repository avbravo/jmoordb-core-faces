/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordb.core.processor.entity.supplier.referenced;

import com.jmoordb.core.processor.fields.EntityField;
import com.jmoordb.core.processor.entity.model.EntityData;
import com.jmoordb.core.processor.model.IdData;
import com.jmoordb.core.util.JmoordbCoreFileUtil;
import com.jmoordb.core.util.JmoordbCoreUtil;
import com.jmoordb.core.util.MessagesUtil;
import javax.lang.model.element.Element;

/**
 *
 * @author avbravo
 */
public interface EntitySupplierReferencedBuilder {
     // <editor-fold defaultstate="collapsed" desc="String referencedProcess(EntityData entityData, EntityField entityField)">

    /**
     * Procesa los documentos Referenciados
     *
     * @param entityData
     * @param entityField
     * @return
     */
    public static String referencedProcess(EntityData entityData, EntityField entityField, Element element) {
        String result = "";
        String entityNameUpper = JmoordbCoreUtil.letterToUpper(entityData.getEntityName());
        String entityNameLower = JmoordbCoreUtil.letterToLower(entityData.getEntityName());
        String fieldUpper = JmoordbCoreUtil.letterToUpper(entityField.getNameOfMethod());
        String fieldLower = JmoordbCoreUtil.letterToLower(entityField.getNameOfMethod());

        IdData idData = new IdData();
        JmoordbCoreFileUtil.readIdAnnotationOfEntityFile(element, fieldUpper + ".java", idData);

        String as = entityField.getReferenced().from();

        String foreignField = idData.getFieldName();
        String from = entityField.getReferenced().from();
        String localField = entityField.getReferenced().localField();
        String sourceSupplier = "\t\tdocument_.put(\"" + fieldLower + "\"," + fieldLower + "Supplier.toDocument(" + entityNameLower + ".get" + fieldUpper + "())" + ");\n";
        try {

            if (entityField.getReturnTypeValue().contains("List")) {

                result += "\t// Referenced List<" + fieldLower + ">\n";


                result += sourceSupplier;
                return result;
            }
            if (entityField.getReturnTypeValue().contains("Set")) {
                result += "\t// Referenced Set<" + fieldLower + ">\n";


                result += sourceSupplier;
                return result;
            }
            if (entityField.getReturnTypeValue().contains("Stream")) {
                result += "\t// Referenced Stream<" + fieldLower + ">\n";


                result += sourceSupplier;
                return result;
            }

            result += "\t// Referenced of " + fieldLower + "\n";


            result += sourceSupplier;

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="String toUpdate(EntityData entityData, EntityField entityField, Element element, String caracterComa)">

    /**
     * Procesa los documentos Referenciados
     *
     * @param entityData
     * @param entityField
     * @return
     */
    public static String toUpdate(EntityData entityData, EntityField entityField, Element element, String caracterComa) {
        String result = "";
        String entityNameUpper = JmoordbCoreUtil.letterToUpper(entityData.getEntityName());
        String entityNameLower = JmoordbCoreUtil.letterToLower(entityData.getEntityName());
        String fieldUpper = JmoordbCoreUtil.letterToUpper(entityField.getNameOfMethod());
        String fieldLower = JmoordbCoreUtil.letterToLower(entityField.getNameOfMethod());

        IdData idData = new IdData();
        JmoordbCoreFileUtil.readIdAnnotationOfEntityFile(element, fieldUpper + ".java", idData);

        String as = entityField.getReferenced().from();

        String foreignField = idData.getFieldName();
        String from = entityField.getReferenced().from();
        String localField = entityField.getReferenced().localField();
       /**
        * Para listas 
        */  
//        String sourceSupplier = "\t\tUpdates.set(\"" + fieldLower + ".$[]\"," + fieldLower + "Supplier.toDocument(" + entityNameLower + ".get" + fieldUpper + "())" + ")"+ caracterComa+"\n";
        String sourceSupplier = "\t\tUpdates.set(\"" + fieldLower + "\"," + fieldLower + "Supplier.toDocument(" + entityNameLower + ".get" + fieldUpper + "())" + ")"+ caracterComa+"\n";
        try {

            if (entityField.getReturnTypeValue().contains("List")) {

                result += "\t// Referenced List<" + fieldLower + ">\n";


                result += sourceSupplier;
                return result;
            }
            if (entityField.getReturnTypeValue().contains("Set")) {
                result += "\t// Referenced Set<" + fieldLower + ">\n";


                result += sourceSupplier;
                return result;
            }
            if (entityField.getReturnTypeValue().contains("Stream")) {
                result += "\t// Referenced Stream<" + fieldLower + ">\n";


                result += sourceSupplier;
                return result;
            }
            
            /**
             * Referencias simples
             */
            sourceSupplier = "\t\tUpdates.set(\"" + fieldLower + "\"," + fieldLower + "Supplier.toDocument(" + entityNameLower + ".get" + fieldUpper + "())" + ")"+ caracterComa+"\n";
            result += "\t// Referenced of " + fieldLower + "\n";


            result += sourceSupplier;

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
        }
        return result;
    }
    // </editor-fold>
    
    
    
    
}
