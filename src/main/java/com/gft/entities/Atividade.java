package com.gft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "tb_atividade")
public class Atividade implements Serializable {
	
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_atividade;

    private String nome;
   
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFinal;


	public long getId_atividade() {
		return id_atividade;
	}

	public void setId_atividade(long id_atividade) {
		this.id_atividade = id_atividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
    



}
