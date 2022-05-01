package com.emergentes.dao;

import com.emergentes.modelo.usuario;
import java.util.List;

public interface usuariodao {

    public void insertar(usuario usuario) throws Exception;

    public void actualizar(usuario usuario) throws Exception;

    public void eliminar(int id) throws Exception;

    public List<usuario> getAll() throws Exception;

    public usuario getByid(int id) throws Exception;
}
