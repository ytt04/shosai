package com.example.shosai.domain;
 
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
 /**
 *
 * @author djped
 */
@Entity
@Data
@Table(name = "inventarios")
public class Inventarios {
 
    @Id
    private Integer idinventarios;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fecha_ingreso;
    private String estado;
 
    @ManyToOne
    @JoinColumn(name = "usuario_identificaion")
    private Usuario usuario;
 
    public Inventarios() {
 
    }
 
    public Inventarios(Integer id) {
        this.idinventarios = id;
    }
 
}