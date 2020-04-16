package com.formacionbdi.springboot.app.item.models;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;
import lombok.Data;

@Data
public class Item {

	private Producto producto;
	private Integer cantidad;

	public Item() {
	}

	public Item(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}


}
