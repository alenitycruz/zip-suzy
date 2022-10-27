package com.gft.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "raking_tb")
public class Ranking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_raking;
	
	@OneToMany
	@JoinColumn(name = "id_pontuacao")
	private List<Pontuacao> pontuacoes = new ArrayList<>();
	
	@OneToMany
	@JoinColumn(name = "id_grupo")
	private List<Grupo> grupos = new ArrayList<>();
	
	//Map<Grupo, Pontuacao> usuarios = new HashMap<>();
	
	public int calcularGrupo() {

		Pontuacao pontuacaoAux = new Pontuacao();
		
		int total = 0;
		
		int calc = pontuacaoAux.totalPontuacaoPorParticipante();
		
		
			for(Grupo grupo : grupos) {
			total = grupo.getParticipantes().size() * calc;
			}
		

		
		
		return total;
	}

}
