package com.example.shosai.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name= "ventas")
public class CrudVentas{
    @Id
    private Integer codigo_ventas; 
    private String detalles_venta;
    
    
    @ManyToOne
    @JoinColumn(name="CLIENTE_id_cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="DOMICILIOS_id_domicilio")
    private Domicilios domicilios;
}