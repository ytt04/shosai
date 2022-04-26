package com.example.shosai.domain;

/**
 *
 * @author YURLEY
 */
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    private String idrol;
    private String nombrerol;
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;
}