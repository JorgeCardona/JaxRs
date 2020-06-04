package org.api.modelos;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModelProperty;

@XmlRootElement
public class Productos {

	@ApiModelProperty(value = "identificador del producto", example = "7")
	private int id;
	@ApiModelProperty(value = "nombre del producto", example = "Yogurth")
	private String nombre;
	@ApiModelProperty(value = "precio del producto", example = "5900")
	private double precio;
	
	public Productos(int id, String nombre, double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
