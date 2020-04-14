package com.bsoftgroup.springcloudmspago.integracion.util;

import com.bsoftgroup.springcloudmspago.core.negocio.bean.Cliente;
import com.bsoftgroup.springcloudmspago.core.negocio.bean.Producto;
import com.bsoftgroup.springcloudmspago.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmspago.integracion.vo.ServicioVO;

public class Util {

	public static Servicio passServicioVOToServicioBean(ServicioVO serviciovo) {
		Servicio servicio = new Servicio();
		servicio.setCliente(
				new Cliente(new Integer(serviciovo.getCliente().getCodigo()), serviciovo.getCliente().getNombres()));
		servicio.setProducto(new Producto(new Integer(serviciovo.getProducto().getCodigo()),
				serviciovo.getProducto().getDescripcion()));
		if (serviciovo.getCodigo() != null)
			servicio.setCodigo(new Integer(serviciovo.getCodigo()));
		servicio.setEstado(serviciovo.getEstado());
		if (serviciovo.getMonto() != null)
			servicio.setMonto(new Integer(serviciovo.getMonto()));
		return servicio;
	}

}
