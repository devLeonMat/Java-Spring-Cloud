package com.bsoftgroup.springcloudmsconsulta.integracion.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bsoftgroup.springcloudmsconsulta.core.negocio.bean.Servicio;
import com.bsoftgroup.springcloudmsconsulta.integracion.vo.ClienteVO;
import com.bsoftgroup.springcloudmsconsulta.integracion.vo.ProductoVO;
import com.bsoftgroup.springcloudmsconsulta.integracion.vo.ServicioVO;

public class Util {

	public static List<ServicioVO> passLstServicioBeanToServicioVo(List<Servicio> servicios){
		List<ServicioVO> serviciosvo = new ArrayList<>();
		Iterator<Servicio> itServicio = servicios.iterator();
		while(itServicio.hasNext()) {
		Servicio serviciotmp = itServicio.next();
		ServicioVO serviciovotmp = new ServicioVO();
		ProductoVO productovotmp = new ProductoVO();
		ClienteVO clientevotmp = new ClienteVO();
		serviciovotmp.setCodigo(serviciotmp.getCodigo());
		serviciovotmp.setEstado(serviciotmp.getEstado());
		serviciovotmp.setMonto(new Integer(serviciotmp.getMonto()).toString());
		clientevotmp.setCodigo(serviciotmp.getCliente().getCodigo());
		clientevotmp.setNombres(serviciotmp.getCliente().getNombres());
		productovotmp.setCodigo(serviciotmp.getProducto().getCodigo());
		productovotmp.setDescripcion(serviciotmp.getProducto().getDescripcion());
		serviciovotmp.setCliente(clientevotmp);
		serviciovotmp.setProducto(productovotmp);
		serviciosvo.add(serviciovotmp);
		serviciovotmp=null;
		}
		return serviciosvo;
		}
	
}
