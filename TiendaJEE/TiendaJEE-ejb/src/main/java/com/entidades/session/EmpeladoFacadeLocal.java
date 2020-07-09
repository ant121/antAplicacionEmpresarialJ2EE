/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades.session;

import com.tienda.entidades.Empelado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author antho
 */
@Local
public interface EmpeladoFacadeLocal {

    void create(Empelado empelado);

    void edit(Empelado empelado);

    void remove(Empelado empelado);

    Empelado find(Object id);

    List<Empelado> findAll();

    List<Empelado> findRange(int[] range);

    int count();
    
}
