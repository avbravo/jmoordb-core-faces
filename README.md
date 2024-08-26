
# Jmoordb-core-faces

[https://github.com/avbravo/nerysdemo](https://github.com/avbravo/nerysdemo)

Framework Java para generar aplicaciones Jakarta Faces que trabajan con Jmoordb-core

Objetivos

* Generar converter a partir de un entity

* Generar ConverterServices a partir de un entity

* Generar Services y ServicesImplementation a partir de un RestClient

* Generar Controller

* Generar Paginas xhtml







```java

@Entity
@FacesEntity(name="Persona", layout="basic.json",controller="PersonaController", accessRole="ADMIN,COLABORADOR", deleteRole="ADMIN")
public class Persona {

@FacesHidden(hidden=true")
@Id
private Long idpersona;

@FacesTextField(name="nombre", label="field.nombre")
@Column
private String nombre;


@FacesAutocomplete(name="pais",label="label.pais",value="idpais", display="idpais, pais")
@Referenced
Pais pais;


@FacesDialogTable(name="deportes",label="label.deportes")
@Embedded
List<Deportes> deportes;

@FacesDialogForm(name="habilidades", label="label.habilidades")
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


## Icono

Entidad Simple

```java




```



## Menu

```java

@LeftMenu
public interface LeftMenu{

@LeftMenu(type=Menu.ACTION, icon="pi pi-home", title="", text="", action="", rollesAllowed={"ADMIN")
private void home();


@LeftMenu(type=Menu.ACTION, icon="pi pi-home", title="", text="", action="")
private void profile();

@SeparatorMenu
private void separator();






}


```