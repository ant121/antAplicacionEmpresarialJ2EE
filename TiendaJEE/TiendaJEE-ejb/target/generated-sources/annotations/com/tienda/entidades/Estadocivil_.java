package com.tienda.entidades;

import com.tienda.entidades.Empelado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T18:02:21")
@StaticMetamodel(Estadocivil.class)
public class Estadocivil_ { 

    public static volatile CollectionAttribute<Estadocivil, Empelado> empeladoCollection;
    public static volatile SingularAttribute<Estadocivil, Integer> codigoEstadoCivil;
    public static volatile SingularAttribute<Estadocivil, String> nombre;

}