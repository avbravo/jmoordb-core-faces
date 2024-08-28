package com.jmoordb.core.faces.processor;

import com.jmoordb.core.processor.*;
import com.jmoordb.core.annotation.Entity;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.*;

import com.jmoordb.core.processor.entity.supplier.EntitySupplierBuilder;
import com.jmoordb.core.processor.entity.analizer.EntityAnalizer;
import com.jmoordb.core.processor.entity.model.EntityData;
import com.jmoordb.core.processor.entity.model.EntityDataSupplier;
import com.jmoordb.core.processor.fields.EntityField;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordb.core.util.ProcessorUtil;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;

@SupportedAnnotationTypes(
        {"com.jmoordb.core.annotation.faces.FacesEntity"})
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class FacesEntityProcessor extends AbstractProcessor {

    private Messager messager;
    private EntityDataSupplier entityDataSupplier = new EntityDataSupplier();
    //Cambia para cada processor
    private String fileNameForLocate="pages";
    FileObject f;
    Path p;

    // <editor-fold defaultstate="collapsed" desc=" boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)">
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        try {
            MessagesUtil.box("Iniciando proceso de analisis de @FacesEntity");

            if (annotations.size() == 0) {
                return false;
            }
            /**
             * Lee los elementos que tengan la anotacion @Entity
             */
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Entity.class);

            List<String> uniqueIdCheckList = new ArrayList<>();

            System.out.println("\t [Paso 0]");
            
//            f = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", "index.xthml");
System.out.println("\tStandardLocation.SOURCE_PATH "+StandardLocation.SOURCE_PATH);
System.out.println("\tStandardLocation.SOURCE_OUTPUT "+StandardLocation.SOURCE_OUTPUT);
            System.out.println("\t aui....");

//  f = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", "documentation.xthml");
  f = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", fileNameForLocate);

            System.out.println("\t paso aqui "+ Paths.get(f.toUri()));
            
System.out.println("\t [Paso 1]");
            p = Paths.get(f.toUri())
                    .getParent() // {PROJECT_ROOT}/target/generated-sources/annotations
                    .getParent() // {PROJECT_ROOT}/target/generated-sources
                    .getParent() // {PROJECT_ROOT}/target
                    .getParent(); // {PROJECT_ROOT}
System.out.println("\t [Paso 2]");
            String path = p.toFile().toPath().toString() + "/src/main/webapp/pagesgenerated";
            System.out.println("\t verificando si existe "+Path.of(path));
            if (Files.isDirectory(Path.of(path))) {
                System.out.println("\t\t si existe");
            } else {
                System.out.println("\t no existe voy a crear "+path);
                new File(path).mkdirs();

            }
            for (Element element : elements) {
                Entity entity = element.getAnnotation(Entity.class);

                if (element.getKind() != ElementKind.CLASS) {

                    error("The annotation @Entity can only be applied on class: ",
                            element);

                } else {
                    boolean error = false;
                    /**
                     * Obtener datos del entity para EntityData
                     */

                    EntityData entityData = entityDataSupplier.get(EntityData::new, element);
                    String nameOfEntity = "";

                    if (uniqueIdCheckList.contains(entityData.getCollection())) {
                        error("Entity has should be uniquely defined", element);
                        error = true;
                    }

                    error = !checkIdValidity(entityData.getCollection(), element);
                    if (!error) {
                        uniqueIdCheckList.add(entityData.getCollection());
                        try {

                            builderClass(entity, entityData, element);

                        } catch (Exception e) {
                            error(e.getMessage(), null);
                        }
                    }
                }
            }
            MessagesUtil.box("Proceso de analisis finalizado");
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());

        }
        return false;
    }

    // </editor-fold>
// <editor-fold defaultstate="collapsed" desc="builderClass(Entity entity, EntityData entityData,Element element, TypeMirror typeEntity)">
    private void builderClass(Entity entity, EntityData entityData, Element element)
            throws Exception {
        try {

            /**
             *
             */
            /**
             * List<EntityField almacena la información de los atributos de los
             * entity
             */
            List<EntityField> entityFieldList = new ArrayList<>();
            /**
             *
             * Procesa el contenido de la interface
             */
            EntityAnalizer entityAnalizer = EntityAnalizer.get(element, messager, entityData.getDatabase(), entityFieldList, entityData);

            /**
             * Construye la clase Supplier
             */
            EntitySupplierBuilder entitySupplierSourceBuilder = new EntitySupplierBuilder();

            entitySupplierSourceBuilder.init(entity, entityData, entityFieldList, entityData.getDatabase(), entityData.getCollection(), element);

            /**
             * SupplierServices
             */
            /**
             * Crea el archivo
             */
            System.out.println("............................................................................");
            System.out.println("\t{entityData.getEntityName().toLowerCase()} " + entityData.getEntityName().toLowerCase());
            System.out.println("\t{}[encontrando el directorio del index]");

            FileWriter fw = new FileWriter(new File(p.toFile(), "src/main/webapp/pagesgenerated/" + entityData.getEntityName().toLowerCase() + "_generated.xhtml"));
            fw.append("some content...");
            fw.append(entitySupplierSourceBuilder.end());
            fw.close();

//  String n_p ="src/main/webapp/"+entityData.getEntityName().toLowerCase()+ ".xhtml";
//            generateJavaFile(entityData.getPackageOfEntity() + "." + entityData.getEntityName() + "Supplier", entitySupplierSourceBuilder.end());
        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="generateJavaFile(String qfn, String end)">
    private void generateJavaFile(String qfn, String end) throws IOException {
        try {

            JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(qfn);
            Writer writer = sourceFile.openWriter();
            writer.write(end);
            writer.close();

        } catch (Exception e) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + e.getLocalizedMessage());
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="boolean checkIdValidity(String name, Element e)">
    /**
     * Checking if the class to be generated is a valid java identifier Also the
     * name should be not same as the target interface
     */
    private boolean checkIdValidity(String name, Element e) {
        boolean valid = true;
        try {

            for (int i = 0; i < name.length(); i++) {
                if (i == 0 ? !Character.isJavaIdentifierStart(name.charAt(i))
                        : !Character.isJavaIdentifierPart(name.charAt(i))) {
                    error("Entity as should be valid java "
                            + "identifier for code generation: " + name, e);

                    valid = false;
                }
            }
            if (name.equals(ProcessorUtil.getTypeName(e))) {
                error("as should be different than the Interface name ", e);
            }
        } catch (Exception ex) {
            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " error() " + ex.getLocalizedMessage());

        }
        // testMsg("valid = " + valid, false);
        return valid;
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="error(String msg, Element e)">
    private void error(String msg, Element e) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg, e);
    }
    // </editor-fold>

// <editor-fold defaultstate="collapsed" desc="init(ProcessingEnvironment processingEnvironment)">
    @Override
    public void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

        messager = processingEnvironment.getMessager();
    }
// </editor-fold>    
// <editor-fold defaultstate="collapsed" desc="printError(Element element, String message)">

    private void printError(Element element, String message) {
        messager.printMessage(Diagnostic.Kind.ERROR, message, element);
    }
// </editor-fold>

}
