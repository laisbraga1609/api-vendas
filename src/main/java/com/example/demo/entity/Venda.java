package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType .IDENTITY)
	private Long id;
	
	private LocalDate dataVenda;
	private Double valor;
	private Long vendedorId;
	private String vendedorNome;
	public Long getId() {return id;}
	
	
	public LocalDate getDataVenda() {return dataVenda;}
	public void setDataVenda(LocalDate dataVenda) {this.dataVenda = dataVenda;}
	
	public Double getValor() {return valor;}
	public void setValor(Double valor) {this.valor = valor;}
	
	public Long getVendedorId() {return vendedorId;}
	public void setVendedorId(Long vendedorId) {this.vendedorId = vendedorId;}
	
	public String getVendedorNome() {return vendedorNome;}
	public void setVendedorNome(String vendedorNome) {this.vendedorNome = vendedorNome;}
	
}
