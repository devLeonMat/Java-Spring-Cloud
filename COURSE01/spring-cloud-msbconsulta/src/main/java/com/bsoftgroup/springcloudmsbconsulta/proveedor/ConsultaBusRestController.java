package com.bsoftgroup.springcloudmsbconsulta.proveedor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bsoftgroup.springcloudmsbconsulta.interfaces.ConsultaBusFeignInterface;
import com.bsoftgroup.springcloudmsbconsulta.interfaces.ConsultaBusProxyInterface;
import com.bsoftgroup.springcloudmsbconsulta.objetos.ClienteVO;
import com.bsoftgroup.springcloudmsbconsulta.objetos.ProductoVO;
import com.bsoftgroup.springcloudmsbconsulta.objetos.ServicioVO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ConsultaBusRestController {

	@Autowired
	private ConsultaBusProxyInterface consultaBusProxy;

	@Autowired
	private ConsultaBusFeignInterface consultaBusFeign;

	@GetMapping(path = "/holamicroservicios")
	public String holamicroservicios() {
		return consultaBusProxy.holamicroservicios();
	}

	@GetMapping("/facturacion/idCliente/{idCliente}/idEmpresa/{idEmpresa}")
	public List<ServicioVO> getServicios(@PathVariable("idCliente") Integer idCliente,
			@PathVariable("idEmpresa") Integer idEmpresa) {
		return consultaBusProxy.getServicios(idCliente, idEmpresa);
	}

	@GetMapping("/facturacion/feign/idCliente/{idCliente}/idEmpresa/{idEmpresa}")
	@HystrixCommand(fallbackMethod="getServiciosFeignHystrix")
	public List<ServicioVO> getServiciosFeign(@PathVariable("idCliente") Integer idCliente,
			@PathVariable("idEmpresa") Integer idEmpresa) {
		return consultaBusFeign.getServicios(idCliente, idEmpresa);
	}
	
	public List<ServicioVO> getServiciosFeignHystrix(@PathVariable("idCliente") Integer idCliente,
			@PathVariable("idEmpresa") Integer idEmpresa) {
		log.info("idCliente ->{}", idCliente);
		ServicioVO  s1 = new ServicioVO();
		ClienteVO c1 = new ClienteVO();
		ProductoVO p1 = new ProductoVO(); 
		c1.setCodigo(1);
		c1.setNombres("clientes 1");
		
		p1.setCodigo(1);
		p1.setDescripcion("producto 1");
		
		s1.setCodigo(1);
		s1.setCliente(c1);
		s1.setProducto(p1);
		
		List<ServicioVO> servicios = new ArrayList<>();
		servicios.add(s1);
		
		
		return servicios;
	}

}
