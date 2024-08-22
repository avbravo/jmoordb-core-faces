
# Jmoordb-core-faces

Framework Java para generar aplicaciones Jakarta Faces que trabajan con Jmoordb-core

Objetivos

* Generar converter a partir de un entity

* Generar ConverterServices a partir de un entity

* Generar Services y ServicesImplementation a partir de un RestClient

* Generar Controller

* Generar Paginas xhtml


# Generar anotaciones con el procesador

[How to generate xhtml files in webapp using javac annotation processor](https://stackoverflow.com/questions/52525655/how-to-generate-xhtml-files-in-webapp-using-javac-annotation-processor)


```java



 FileObject f = processingEnv.getFiler().createResource(StandardLocation.SOURCE_OUTPUT, "", "DUMMY");
  Path p = Paths.get(f.toUri())
          .getParent()  // {PROJECT_ROOT}/target/generated-sources/annotations
          .getParent()  // {PROJECT_ROOT}/target/generated-sources
          .getParent()  // {PROJECT_ROOT}/target
          .getParent(); // {PROJECT_ROOT}
  FileWriter fw = new FileWriter(new File(p.toFile(), "src/main/webapp/generated.xhtml"));
  fw.append("some content...");
  fw.close();)
```



```java

@Entity
@Faces(name="Persona", layout="basic.json",controller="PersonaController", accessRole="ADMIN,COLABORADOR", deleteRole="ADMIN")
public class Persona {

@ViewHidden(hidden=true")
@Id
private Long idpersona;

@ViewTextField(name="nombre", label="field.nombre")
@Column
private String nombre;


@ViewAutocomplete(name="pais",label="label.pais",value="idpais", display="idpais, pais")
@Referenced
Pais pais;


@ViewDialogTable(name="deportes",label="label.deportes")
@Embedded
List<Deportes> deportes;

@ViewDialogForm(name="habilidades", label="label.habilidades")
@Embedded
List<Habilidades> habilidades;

```



# Controller

```java

public interface PersonaController extends FacesController<Persona,Long>{

public default beforeSave(){

}

public default afterSave(){

}


}


```
