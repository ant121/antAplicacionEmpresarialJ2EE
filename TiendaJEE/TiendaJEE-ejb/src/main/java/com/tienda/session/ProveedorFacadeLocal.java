package com.tienda.session;

import com.tienda.entidades.Proveedor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author antho
 */
@Local
public interface ProveedorFacadeLocal {

    void create(Proveedor proveedor);

    void edit(Proveedor proveedor);

    void remove(Proveedor proveedor);

    Proveedor find(Object id);

    List<Proveedor> findAll();

    List<Proveedor> findRange(int[] range);

    int count();
    
}
