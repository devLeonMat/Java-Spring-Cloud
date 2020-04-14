package com.bsoftgroup.springcloudmspago.core.negocio.bean;

import java.util.List;

public class Empresa {
	
	private Integer codigo;
	private String razonsocial;
	
	//atributos de relaciones
	private List<Cliente> clientes;


}
