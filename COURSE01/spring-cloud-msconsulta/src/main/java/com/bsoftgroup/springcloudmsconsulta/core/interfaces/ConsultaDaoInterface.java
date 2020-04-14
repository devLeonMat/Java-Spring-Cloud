package com.bsoftgroup.springcloudmsconsulta.core.interfaces;

import java.util.List;

import com.bsoftgroup.springcloudmsconsulta.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmsconsulta.core.util.AppException;

public interface ConsultaDaoInterface {

	
	public String holamicroservicios();
	
	public List<Servicio> getServicios(Integer idCliente, Integer idEmpresa) throws AppException; 

}
