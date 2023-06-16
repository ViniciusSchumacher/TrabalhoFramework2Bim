/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.unipar.frameworks.model.dao;

import br.com.unipar.frameworks.model.Usuario;
import java.util.List;

/**
 *
 * @author Juliane
 */


public interface UsuarioDAO {
    public void save(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
    public Usuario findById(int id);
    public List<Usuario> findAll();
}


