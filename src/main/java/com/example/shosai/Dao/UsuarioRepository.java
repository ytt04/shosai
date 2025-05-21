/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.shosai.Dao;

/**
 *
 * @author Andrea Gonzáles
 */

 
import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.shosai.domain.Usuario;
 
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
 
}