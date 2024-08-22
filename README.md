
# JMoordb-core

Framework Java para bases de datos NoSQL


[Libro](http://leanpub.com/jmoordbcore)

Codigo base para los proyectos que implementan jmoordb-core-procesor


```
ObjectID layout
0	1	2	3|	4	5	6|	7	8	9	10	11
time	machine	pid	inc



.UUID, OBJECTID, NONE, AUTO
## Cambiar @Id

* autogeneratedActive por  strategy
*  AutogeneratedActive.UUID por  GenerationType.UUID


```
@Id(autogeneratedActive = AutogeneratedActive.UUID)
    private UUID id;
``
Quedaria

```
@Id(strategy= GenerationType.UUID)
    private UUID id;

```
---

## Sporte para ObjectId

Reglas:

1. Se puede utilizar como llave primaria @Id
@Id
ObjectId _id;

* Se debe llamar ObjectId _id; para que coincia con el atributo _id generado por MongoDB.
* Solo aplica a @Entity y @ViewEntity

2. Se puede utilizar como columna @Column

@Column
private ObjectId _id;

* Aplica a @Entity @ViewEntity @Embeddadble


## Convertir un String a ObjectId
```java
 ObjectId id =new ObjectId(stringvalue);

```

### Convertir Un ObjectId to String

```java

id.toString();

``

## Soporte para UUID

Reglas:

1. Se puede utilizar como llave primaria @Id
@Id
ObjectId _id;

* Se debe llamar ObjectId _id; para que coincia con el atributo _id generado por MongoDB.
* Solo aplica a @Entity y @ViewEntity

2. No aplica para columna @Column



// generar UUID
   UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();


// convertir a UUID
idUuidMongo.setId(UUID.fromString(document_.getString("id")));


