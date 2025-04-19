/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.shosai.Dao;
/**
 *
 * @author Andrea Gonzáles
 */


import org.springframework.data.repository.CrudRepository;
 
import com.example.shosai.domain.Producto;
 
public interface ProductosRepository extends CrudRepository<Producto, Integer> {
 
    Producto findFirstByCodigo(String codigo);
}