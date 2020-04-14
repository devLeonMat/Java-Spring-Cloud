package com.bsoftgroup.springcloudmanagementproperties.conexion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatosConexionController {

	@Autowired
	private ConfiguracionDataSource service;
	
	@GetMapping("datosconexion")
	public DatosConexion getDatosConexion() {
	DatosConexion datosconexion= new DatosConexion
	(
	service.getDriverclassname(),
	service.getUrl(),
	service.getUsername(),
	service.getPassword());
	return datosconexion;
	}
	
}
