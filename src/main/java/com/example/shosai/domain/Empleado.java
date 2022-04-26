/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author YURLEY
 */
@Entity
@Data
@Table(name= "empleado")
public class Empleado {
    
    @Id
    private Integer id_empelado;
    private String cargo;
    
    @ManyToOne
    @JoinColumn(name="USUARIO_identificaion")
    private Usuario usuario;
    
    
    
}