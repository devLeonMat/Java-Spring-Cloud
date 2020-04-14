package com.bsoftgroup.springcloudmsbpago.proveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bsoftgroup.springcloudmsbpago.interfaces.PagoBusFeignInterface;
import com.bsoftgroup.springcloudmsbpago.interfaces.PagoBusProxyInterface;
import com.bsoftgroup.springcloudmsbpago.objetos.AppException;
import com.bsoftgroup.springcloudmsbpago.objetos.ServicioVO;
import com.bsoftgroup.springcloudmsbpago.objetos.Transaccion;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PagoBusRestController {

	@Autowired
	private PagoBusProxyInterface pagoBusProxy;

	@Autowired
	private PagoBusFeignInterface pagoBusFeign;

	@PutMapping("/servicio/pagar")
	public Transaccion pagarServicio(@RequestBody ServicioVO servicio) {
		Transaccion tx = new Transaccion();
		try {
			pagoBusProxy.pagarServicio(servicio);
		} catch (AppException ape) {
			System.out.println(ape.getMessage());
		}
		return tx;
	}

	@PutMapping("/servicio/feign/pagar")
	public Transaccion pagarServicioFeign(@RequestBody ServicioVO servicio) {
		log.info("log msb pago ->{}",servicio.getCodigo());
		return pagoBusFeign.pagarServicios(servicio);
	}

}
