/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.shosai.Dao;


import org.springframework.data.repository.CrudRepository;
import com.example.shosai.domain.Domicilios; 
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface DomiciliosDao extends CrudRepository<Domicilios, Integer> {
    
@Query (value = "select * from domicilios d inner join ventas v on  (d.id_domicilio = v.DOMICILIOS_id_domicilio) ",  nativeQuery = true)
   public List<Domicilios> Domicilios();  
}
