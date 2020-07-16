/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managebean;

import com.tienda.entidades.Proveedor;
import com.tienda.session.ProveedorFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author antho
 */
@Named(value = "proveedorManagebBean")
@ViewScoped
public class ProveedorManagebBean implements Serializable, ManagedBeanInterface<Proveedor> {

   
    // PASO 1.- INSTANCIAR AL SESSION BEAN
    @EJB
    private ProveedorFacadeLocal proveedorFacadeLocal;
    
    private List<Proveedor> listaProveedores;
    private Proveedor proveedor;
    
    // PASO 2.- INICIALIZAR EL SESSION BEAN
    @PostConstruct
    public void init() {
        listaProveedores = proveedorFacadeLocal.findAll();
    }
    
    // CONSTRUCTOR DE LA CLASE
    public ProveedorManagebBean() {
    }

    // METODOS DE L INTERFAZ
    @Override
    public void nuevo() {
        proveedor = new Proveedor();
    }

    @Override
    public void grabar() {
         try {
            if (proveedor.getCodigo() == null) {
                proveedorFacadeLocal.create(proveedor);
            } else {
                proveedorFacadeLocal.edit(proveedor);
            }
            proveedor = null;
            listaProveedores = proveedorFacadeLocal.findAll();
            mostrarMnesajeTry("INFORMACIÓN OK", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMnesajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void seleccionar(Proveedor p) {
        proveedor = p;
    }

    @Override
    public void eliminar(Proveedor p) {
        try {
           proveedorFacadeLocal.remove(p);
            listaProveedores = proveedorFacadeLocal.findAll();
            mostrarMnesajeTry("INFORMACIÓN OK", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMnesajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
        proveedor=null;
        listaProveedores = proveedorFacadeLocal.findAll();
    }

    // SET AND GET
    public ProveedorFacadeLocal getProveedorFacadeLocal() {
        return proveedorFacadeLocal;
    }

    public void setProveedorFacadeLocal(ProveedorFacadeLocal proveedorFacadeLocal) {
        this.proveedorFacadeLocal = proveedorFacadeLocal;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    private void mostrarMnesajeTry(String información_ok, FacesMessage.Severity SEVERITY_INFO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
