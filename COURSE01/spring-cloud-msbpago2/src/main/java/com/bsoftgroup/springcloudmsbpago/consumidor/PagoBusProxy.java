package com.bsoftgroup.springcloudmsbpago.consumidor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bsoftgroup.springcloudmsbpago.interfaces.PagoBusProxyInterface;
import com.bsoftgroup.springcloudmsbpago.objetos.AppException;
import com.bsoftgroup.springcloudmsbpago.objetos.ServicioVO;
import com.bsoftgroup.springcloudmsbpago.objetos.Transaccion;

@Component
public class PagoBusProxy implements PagoBusProxyInterface {

	private static String URL = " http://localhost:8082/mspago/servicio/pagar";

	@Override
	public String holamicroservicios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaccion pagarServicio(ServicioVO servicio) throws AppException {

		Transaccion tx = new Transaccion();
		HttpEntity<ServicioVO> requestEntity = new HttpEntity<ServicioVO>(servicio, null);
		ResponseEntity<Transaccion> responseEntity = new RestTemplate().exchange(URL, HttpMethod.PUT,requestEntity ,Transaccion.class);
		if (responseEntity != null && responseEntity.hasBody()) {
			tx = responseEntity.getBody();
		}
		return tx;

	}

}
