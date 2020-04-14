package com.bsoftgroup.springcloudmspago.core.interfaces;

import com.bsoftgroup.springcloudmspago.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmspago.core.util.AppException;
import com.bsoftgroup.springcloudmspago.core.util.Transaccion;

public interface PagoServiceInterface {
	
	public Transaccion pagarServicio(Servicio servicio) throws AppException;

}
