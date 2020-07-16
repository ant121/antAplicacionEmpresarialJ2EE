package com.tienda.entidades;

import com.tienda.entidades.Empelado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T01:39:55")
@StaticMetamodel(Cargo.class)
public class Cargo_ { 

    public static volatile CollectionAttribute<Cargo, Empelado> empeladoCollection;
    public static volatile SingularAttribute<Cargo, Integer> codigoCargo;
    public static volatile SingularAttribute<Cargo, String> nombre;

}