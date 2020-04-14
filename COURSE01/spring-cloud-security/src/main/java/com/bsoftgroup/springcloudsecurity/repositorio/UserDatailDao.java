package com.bsoftgroup.springcloudsecurity.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bsoftgroup.springcloudsecurity.bean.Usuario;
import com.bsoftgroup.springcloudsecurity.util.Conexion;

@Repository
public class UserDatailDao implements UserDetailDaoInterface {

	@Override
	public Usuario getUsuario(String username) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		Usuario usuario = null;
		try {
		conn = new Conexion().getConexion();
		String SQL = "Select username, password from esqmicroservicios.tbl_usuario where username=? order by id";
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, username);
		rs = pstmt.executeQuery();
		while(rs.next()) {
		usuario = new Usuario();
		usuario.setUsername(rs.getString("username"));
		usuario.setPassword(rs.getString("password"));
		}
		} catch (Exception e) {
		e.getStackTrace();
		}finally {
		try {
		conn.close();
		rs.close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		}
		return usuario;

	}

}
