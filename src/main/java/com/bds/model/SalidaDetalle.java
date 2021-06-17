package com.bds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="salida_detalle")
public class SalidaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSalidaDetalle;
	
	@ManyToOne
	@JoinColumn(name="id_salida",nullable = false, foreignKey = @ForeignKey(name = "salida_detalle_salida"))
	private Salida salida;
	
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable = false, foreignKey = @ForeignKey(name = "salida_detalle_producto"))
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Column(name = "valor_total", nullable = true)
	private Double valorTotal;

	public Integer getIdSalidaDetalle() {
		return idSalidaDetalle;
	}

	public void setIdSalidaDetalle(Integer idSalidaDetalle) {
		this.idSalidaDetalle = idSalidaDetalle;
	}

	public Salida getSalida() {
		return salida;
	}

	public void setSalida(Salida salida) {
		this.salida = salida;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
