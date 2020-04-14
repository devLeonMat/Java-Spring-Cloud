package com.bsoftgroup.springcloudmsconsulta.integracion.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bsoftgroup.springcloudmsconsulta.core.interfaces.ConsultaServiceInterface;
import com.bsoftgroup.springcloudmsconsulta.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmsconsulta.core.util.AppException;
import com.bsoftgroup.springcloudmsconsulta.integracion.util.Util;
import com.bsoftgroup.springcloudmsconsulta.integracion.vo.ServicioVO;

@RestController
public class ConsultaRestController {

	@Autowired
	private ConsultaServiceInterface consultaService;
	
	@Autowired
	private Environment enviroment;


	public ConsultaRestController() {
	}

	@GetMapping(path = "/holamicroservicios")
	public String holamicroservicios() {
		return consultaService.holamicroservicios();
	}

	@GetMapping(path = "/facturacion/idCliente/{idCliente}/idEmpresa/{idEmpresa}")
	public List<ServicioVO> getServicios(@PathVariable("idCliente") Integer idCliente,
			@PathVariable("idEmpresa") Integer idEmpresa) {
		System.out.println("Puerto:"+enviroment.getProperty(("local.server.port")));
		// TODO Auto-generated method stub
		List<ServicioVO> serviciosvo = null;
		try {
			List<Servicio> servicios = consultaService.getServicios(idCliente, idEmpresa);
			serviciosvo = Util.passLstServicioBeanToServicioVo(servicios);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviciosvo;
	}
}
