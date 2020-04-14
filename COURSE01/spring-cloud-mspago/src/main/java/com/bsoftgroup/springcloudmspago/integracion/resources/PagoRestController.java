package com.bsoftgroup.springcloudmspago.integracion.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bsoftgroup.springcloudmspago.core.interfaces.PagoServiceInterface;

import com.bsoftgroup.springcloudmspago.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmspago.core.util.Transaccion;
import com.bsoftgroup.springcloudmspago.integracion.util.Util;
import com.bsoftgroup.springcloudmspago.integracion.vo.ServicioVO;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PagoRestController {

	@Autowired
	private PagoServiceInterface pagoService;

	@Autowired
	private Environment enviroment;

	public PagoRestController() {
	}

	// métodos a agregar
	@PutMapping(path = "/facturacion/pagar")
	public Transaccion pagarServicio(@RequestBody ServicioVO serviciovo) {
		Transaccion tx = new Transaccion();
		System.out.println("puerto " +" enviroment-"+enviroment.getProperty("local.server.port"));
		try {
			Servicio servicio = Util.passServicioVOToServicioBean(serviciovo);
			tx = pagoService.pagarServicio(servicio);
			log.info("/facturacion/pagar->{}",enviroment.getProperty("local.server.port") );
//			tx.setCodigo(enviroment.getProperty("local.server.port"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tx;
	}
}
