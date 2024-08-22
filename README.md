
# Jmoordb-core-faces

Framework Java para generar aplicaciones Jakarta Faces que trabajan con Jmoordb-core

Objetivos

* Generar converter a partir de un entity

* Generar ConverterServices a partir de un entity

* Generar Services y ServicesImplementation a partir de un RestClient

* Generar Controller

* Generar Paginas xhtml


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