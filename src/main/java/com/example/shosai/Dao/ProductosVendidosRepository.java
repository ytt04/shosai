/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.Dao;

import org.springframework.data.repository.CrudRepository;
 
import com.example.shosai.domain.ProductoVendido;

/**
 *
 * @author HP
 */
public interface ProductosVendidosRepository extends CrudRepository<ProductoVendido, Integer> {
 
}