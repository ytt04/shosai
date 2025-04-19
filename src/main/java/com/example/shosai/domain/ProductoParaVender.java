/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

/**
 *
 * @author HP
 */

public class ProductoParaVender extends Producto {
    private Float cantidad;
 
    public ProductoParaVender(String nombre, String codigo, Float precio, Float existencia, Integer id, Float cantidad) {
        super(nombre, codigo, precio, existencia, id);
        this.cantidad = cantidad;
    }
 
    public ProductoParaVender(String nombre, String codigo, Float precio, Float existencia, Float cantidad) {
        super(nombre, codigo, precio, existencia);
        this.cantidad = cantidad;
    }
 
    public void aumentarCantidad() {
        this.cantidad++;
    }
 
    public Float getCantidad() {
        return cantidad;
    }
 
    public Float getTotal() {
        return this.getPrecio() * this.cantidad;
    }
}
