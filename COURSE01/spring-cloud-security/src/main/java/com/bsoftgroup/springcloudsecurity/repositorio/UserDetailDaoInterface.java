package com.bsoftgroup.springcloudsecurity.repositorio;

import com.bsoftgroup.springcloudsecurity.bean.Usuario;

public interface UserDetailDaoInterface {
	
	public Usuario getUsuario(String username);

}
