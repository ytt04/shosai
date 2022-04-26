/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.Dao;


import org.springframework.data.repository.CrudRepository;
import com.example.shosai.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
    
   @Query(value = "select * from cliente a inner join ventas b on (a.id_cliente = b.CLIENTE_id_cliente) ", nativeQuery = true)
   public List<Cliente> Cliente();
}
