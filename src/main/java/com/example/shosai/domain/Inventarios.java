/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.domain;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Data
@Table(name= "inventarios")
public class Inventarios {
     @Id
     private Integer id_inventarios;
      private String nombre_inventario;
      private Integer cantidad;
      @DateTimeFormat(pattern="yyyy-MM-dd")
      @Temporal(TemporalType.DATE)
      private Date fecha_ingreso;
      @DateTimeFormat(pattern="yyyy-MM-dd")
      @Temporal(TemporalType.DATE)
      private Date fecha_salida;
      
      public Inventarios() {
    	
      }
      
      public Inventarios(Integer id) {
    	  this.id_inventarios=id;
      }
      
  
}
