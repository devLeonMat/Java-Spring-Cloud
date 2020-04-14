package com.bsoftgroup.springcloudmspago.core.negocio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsoftgroup.springcloudmspago.core.interfaces.PagoDaoInterface;
import com.bsoftgroup.springcloudmspago.core.interfaces.PagoServiceInterface;
import com.bsoftgroup.springcloudmspago.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmspago.core.util.AppException;
import com.bsoftgroup.springcloudmspago.core.util.Transaccion;

@Service
public class PagoService implements PagoServiceInterface {

	@Autowired
	private PagoDaoInterface pagoDao;
	
	public PagoService() {}
	public Transaccion pagarServicio(Servicio servicio) throws AppException {
	// TODO Auto-generated method stub
	return pagoDao.pagarServicio(servicio);
	}


}
