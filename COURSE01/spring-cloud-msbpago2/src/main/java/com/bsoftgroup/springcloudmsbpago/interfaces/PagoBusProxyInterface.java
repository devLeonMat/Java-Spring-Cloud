package com.bsoftgroup.springcloudmsbpago.interfaces;

import java.util.List;

import com.bsoftgroup.springcloudmsbpago.objetos.AppException;
import com.bsoftgroup.springcloudmsbpago.objetos.ServicioVO;
import com.bsoftgroup.springcloudmsbpago.objetos.Transaccion;

public interface PagoBusProxyInterface {
	
	public String holamicroservicios();
	
	public Transaccion pagarServicio(ServicioVO servicio) throws AppException;

}
