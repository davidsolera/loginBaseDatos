/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginbasedatos;

/**
 *
 * @author solera
 */
public class Herramientas {
    String referencia, nombre, familia;
	float stock, precio;
	
	
	public Herramientas (String referencia, String nombre, String familia, float stock, float precio){
		
		 this.referencia = referencia;
		 this.nombre = nombre;
		 this.familia = familia;
		 this.stock=stock;
		 this.precio=precio;
		 
	}
	
	
	
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public float getStock() {
		return stock;
	}
	public void setStock(float stock) {
		this.stock = stock;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
}
