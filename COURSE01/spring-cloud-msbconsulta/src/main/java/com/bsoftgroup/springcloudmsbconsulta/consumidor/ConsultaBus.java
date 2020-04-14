package com.bsoftgroup.springcloudmsbconsulta.consumidor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bsoftgroup.springcloudmsbconsulta.interfaces.ConsultaBusProxyInterface;
import com.bsoftgroup.springcloudmsbconsulta.objetos.ServicioVO;

@Component
public class ConsultaBus implements ConsultaBusProxyInterface{
	
	private static String URL =	"http://localhost:8081/msconsulta/facturacion/idCliente/{idCliente}/idEmpresa/{idEmpresa}";

	

	@Override
	public String holamicroservicios() {
		// TODO Auto-generated method stub
		ResponseEntity<String> respuestaservicio = new RestTemplate().exchange(URL, HttpMethod.GET, null, String.class);
		String respuesta = respuestaservicio.getBody();
		
		
		return respuesta;
	}


	@Override
	public List<ServicioVO> getServicios(Integer idCliente, Integer idEmpresa) {
		List<ServicioVO> servicios = new ArrayList<>();
		Map<String, Integer> uriVariables = new HashMap<>();
		uriVariables.put("idCliente", idCliente);
		uriVariables.put("idEmpresa", idEmpresa);
		ResponseEntity<List<ServicioVO>> responseEntity = new
		RestTemplate().exchange(URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<ServicioVO>>(){}, uriVariables);
		if(responseEntity != null && responseEntity.hasBody()){
		servicios = responseEntity.getBody();
		}
		return servicios;
	}

}
