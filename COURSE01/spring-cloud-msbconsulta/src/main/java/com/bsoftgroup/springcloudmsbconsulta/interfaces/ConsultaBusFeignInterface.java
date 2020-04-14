package com.bsoftgroup.springcloudmsbconsulta.interfaces;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bsoftgroup.springcloudmsbconsulta.objetos.ServicioVO;

//@FeignClient(name = "ms-consulta", url = "localhost:8081")
//@FeignClient(name = "ms-consulta")
//@FeignClient(name = "ms-consulta")
@FeignClient(name = "apigateway")
@RibbonClient(name = "ms-consulta")
public interface ConsultaBusFeignInterface {

	@GetMapping(path = "/ms-consulta/msconsulta/facturacion/idCliente/{idCliente}/idEmpresa/{idEmpresa}")
	public List<ServicioVO> getServicios(@PathVariable("idCliente") Integer idCliente, @PathVariable("idEmpresa") Integer idEmpresa );

}
