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
@Table(name="ingreso_detalle")
public class IngresoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idIngresoDetalle;
	
	@ManyToOne
	@JoinColumn(name="id_Ingreso",nullable = false, foreignKey = @ForeignKey(name = "ingreso_detalle_ingreso"))
	private Ingreso ingreso;
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable = false, foreignKey = @ForeignKey(name = "ingreso_detalle_producto"))
	private Producto producto;
	
	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Column(name = "valor_total", nullable = true)
	private Double valorTotal;

	public Integer getIdIngresoDetalle() {
		return idIngresoDetalle;
	}

	public void setIdIngresoDetalle(Integer idIngresoDetalle) {
		this.idIngresoDetalle = idIngresoDetalle;
	}

	public Ingreso getIngreso() {
		return ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
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
