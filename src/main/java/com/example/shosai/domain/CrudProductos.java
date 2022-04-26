package com.example.shosai.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name= "productos")
public class CrudProductos{
    @Id
    private Integer idproducto; 
    private String nombreproducto;
    private Integer cantidadproducto; 
    private Integer precioproducto; 
    
    @ManyToOne
    @JoinColumn(name="inventarios_id_inventraios")
    private Inventarios inventarios;
}

