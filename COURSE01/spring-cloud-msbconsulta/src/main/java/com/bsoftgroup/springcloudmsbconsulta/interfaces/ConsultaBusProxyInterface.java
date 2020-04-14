package com.bsoftgroup.springcloudmsbconsulta.interfaces;

import java.util.List;

import com.bsoftgroup.springcloudmsbconsulta.objetos.ServicioVO;

public interface ConsultaBusProxyInterface {
	
	
	public String holamicroservicios();
	public List<ServicioVO> getServicios(Integer idCliente, Integer idEmpresa);

}
