package com.tienda.entidades;

import com.tienda.entidades.Cargo;
import com.tienda.entidades.Estadocivil;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-16T18:02:21")
@StaticMetamodel(Empelado.class)
public class Empelado_ { 

    public static volatile SingularAttribute<Empelado, Integer> codigoEmpleado;
    public static volatile SingularAttribute<Empelado, Date> fechaNacimiento;
    public static volatile SingularAttribute<Empelado, String> cedula;
    public static volatile SingularAttribute<Empelado, String> apellido;
    public static volatile SingularAttribute<Empelado, Estadocivil> codigoEstadoCivil;
    public static volatile SingularAttribute<Empelado, Cargo> codigoCargo;
    public static volatile SingularAttribute<Empelado, String> nombre;

}