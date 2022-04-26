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
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Mahecha Ortiz
 */
@Entity
@Data
@Getter
@Setter
@Table(name = "domicilios")
public class Domicilios {

    @Id
    private Integer id_domicilio;
    private String nombre_destinatario;
    private String apellido_destinatario;
    private String dirección_destinatario;
    private String telefono_destinatario;
   

}
