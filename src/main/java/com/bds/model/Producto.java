package com.bds.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_marca", nullable = false)
	private Marca marca;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_categoria_producto", nullable = false)
	private CategoriaProducto categoriaProducto;
	
	@Column(name = "identificador", nullable = true, length = 30)
	private String identificador;
	
	@Column(name = "descripcion", nullable = false, length = 70)
	private String descripcion;
	
	@Column(name = "maximo", nullable = false)
	private Integer maximo;
	
	@Column(name = "minimo", nullable = false)
	private Integer minimo;
	
	@Column(name = "valor_promedio", nullable = true)
	private Double valorPromedio;
	
	@Column(name = "saldo",  nullable = true)
	private Double saldo;
	
	@Column(name = "valor", nullable = true)
	private Double valor;
	
	@Column(name = "valor_unidad",  nullable = true)
	private Double valorUnidad;
	
	@Column(name = "perecedero", columnDefinition="boolean default false", nullable = false )
	private Boolean perecedero;
	
	@Column(name = "porcentaje_ganancia", nullable = true)
	private Double porcentajeGanancia;
	
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaSaldo;
	
	
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorUnidad() {
		return valorUnidad;
	}

	public void setValorUnidad(Double valorUnidad) {
		this.valorUnidad = valorUnidad;
	}

	public Boolean getPerecedero() {
		return perecedero;
	}

	public void setPerecedero(Boolean perecedero) {
		this.perecedero = perecedero;
	}


	public LocalDateTime getFechaSaldo() {
		return fechaSaldo;
	}

	public void setFechaSaldo(LocalDateTime fechaSaldo ) {
		this.fechaSaldo = fechaSaldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public CategoriaProducto getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getMaximo() {
		return maximo;
	}

	public void setMaximo(Integer maximo) {
		this.maximo = maximo;
	}

	public Integer getMinimo() {
		return minimo;
	}

	public void setMinimo(Integer minimo) {
		this.minimo = minimo;
	}

	public Double getValorPromedio() {
		return valorPromedio;
	}

	public void setValorPromedio(Double valorPromedio) {
		this.valorPromedio = valorPromedio;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(Double porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}
	
	

	

	
	
	
	
}
