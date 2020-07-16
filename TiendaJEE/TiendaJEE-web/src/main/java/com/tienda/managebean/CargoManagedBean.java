package com.tienda.managebean;

import com.tienda.entidades.Cargo;
import com.tienda.session.CargoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;


@Named(value = "cargoManagedBean")
@ViewScoped
public class CargoManagedBean implements Serializable, ManagedBeanInterface<Cargo>{
    
    @EJB
    private CargoFacadeLocal cargoFacadeLocal;
    
    //Una Lista para traer el listado de cargos
    private List<Cargo> listaCargos;    
    
    //Objeto de tipo Cargo
    private Cargo cargo;
    
    //Constructor
    public CargoManagedBean() {
    }
    
    
    //Paso 2
    @PostConstruct
    public void init(){
        //lista de los cargos que estan en la BDD
        listaCargos = cargoFacadeLocal.findAll();
    }
    
    @Override
    public void nuevo(){
        cargo = new Cargo();
    }
    
    @Override
    public void grabar(){
        try{
            if(cargo.getCodigoCargo() == null){
                cargoFacadeLocal.create(cargo);
            }else{
                cargoFacadeLocal.edit(cargo);
            }
            
            cargo = null;
            
            listaCargos = cargoFacadeLocal.findAll();
            mostrarMensajeTry("Informacion OK", FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
            mostrarMensajeTry("Ocurrio un error", FacesMessage.SEVERITY_ERROR);
        }   
    }
    
    @Override
    public void seleccionar(Cargo c){
        cargo = c;
    }
    
    @Override
    public void eliminar(Cargo c){
        try{
            cargoFacadeLocal.remove(c);
            
            listaCargos = cargoFacadeLocal.findAll();
            
            mostrarMensajeTry("Informacion OK", FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
            mostrarMensajeTry("Ocurrio un error", FacesMessage.SEVERITY_ERROR);
        }
        
    }
    
    @Override
    public void cancelar(){
        cargo = null;
        listaCargos = cargoFacadeLocal.findAll();
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

   

    
    
}
