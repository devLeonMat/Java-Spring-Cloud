package com.bsoftgroup.springcloudmsbpago.interfaces;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bsoftgroup.springcloudmsbpago.objetos.ServicioVO;
import com.bsoftgroup.springcloudmsbpago.objetos.Transaccion;


//@FeignClient(name="mspago", url="localhost:8085")
@FeignClient(name="apigateway")
@RibbonClient(name="ms-pago")
public interface PagoBusFeignInterface {
	
	@PutMapping(path = "/ms-pago/mspago/facturacion/pagar")
	public Transaccion pagarServicios(@RequestBody ServicioVO servicio);

}
