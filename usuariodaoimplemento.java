package com.emergentes.dao;

import com.emergentes.modelo.usuario;
import com.emergentes.utiles.conexionbd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class usuariodaoimplemento extends conexionbd implements usuariodao {

    @Override
    public void insertar(usuario usuario) throws Exception {

        String consulta = "insert into usuarios (nombre,correo,clave) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void actualizar(usuario usuario) throws Exception {
        String consulta = "update usuarios set nombre = ?, correo = ?, clave = ? where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getCorreo());
        ps.setString(3, usuario.getClave());
        ps.setInt(4, usuario.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void eliminar(int id) throws Exception {
        String consulta = "delete from usuarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<usuario> getAll() throws Exception {
        List<usuario> lista = new ArrayList<usuario>();
        String consulta = "select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            usuario u = new usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setCorreo(rs.getString("correo"));
            u.setClave(rs.getString("clave"));

            lista.add(u);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public usuario getByid(int id) throws Exception {
        usuario u = new usuario();
        String consulta = "select * from usuarios where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(consulta);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setCorreo(rs.getString("correo"));
            u.setClave(rs.getString("clave"));
        }

        this.desconectar();
        return u;
    }
}
