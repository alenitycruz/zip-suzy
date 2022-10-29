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
@Table(name = "tb_pontuacao")
public class Pontuacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pontuacao;

	private boolean[] marcar_presencas;

	private boolean[] atividades_realizadas;

	private boolean[] atrasos;

	@OneToMany
	@JoinColumn(name = "id_evento")
	private List<Evento> eventos = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "id")
	private List<Participante> participantes = new ArrayList<>();

	@OneToMany
	@JoinColumn(name = "id")
	private List<Atividade> atividades = new ArrayList<>();



	public int totalPontuacaoPorParticipante() {

		int totalPontos = 0;

		for (boolean presenca : this.marcar_presencas) {
			if (presenca == true) {
				totalPontos += 10;
			}
		}
		
		for (boolean atividade : this.atividades_realizadas) {
			if(atividade == true) {
				totalPontos += 5;
			}
		}
		
		for (boolean atraso : this.atrasos ) {
			if (atraso == true) {
				totalPontos -= 2;
			}
		}

		return totalPontos;
		
	}
	
	//====================================================================
	
	
	//////////////////////////////////////////////////////////////
		public int indiceDoArrayMarcarPresenca() {
			Evento auxEvento = new Evento();////////////////////////

			int i = (int) auxEvento.totalDiasDoEvento();////////////////////////////

			this.marcar_presencas = new boolean[i];/////////////////////////

			return this.marcar_presencas.length;/////////////////////////

		}
	//////////////////////////////////////////////////////////////	
		public void arrayMarcarPresenca() {
			Pontuacao pontuacaoAux = new Pontuacao();
			
			int i = pontuacaoAux.indiceDoArrayMarcarPresenca();
			this.marcar_presencas = new boolean[i];
		}
		

	
	//=========================================================================

	
	
	
	public int indiceDoArrayAtividadesRealizadas() {

		Evento auxEvento = new Evento();

		Atividade auxAtividade = new Atividade();

		int i = 0;
		if (auxEvento.getDataInicio().before(auxAtividade.getDataInicio())
				|| auxEvento.getDataInicio().equals(auxAtividade.getDataInicio())
				&& auxEvento.getDataFinal().after(auxAtividade.getDataFinal())
				|| auxEvento.getDataFinal().equals(auxAtividade.getDataFinal())) {
			
			this.atividades.add(auxAtividade);

			i = atividades.size();
		}
		
		this.atividades_realizadas = new boolean[i];

		return this.atividades_realizadas.length;
	}
	
	
	public void arrayAtividadesRealizadas() {
		Pontuacao pontuacaoAux = new Pontuacao();
		int i = pontuacaoAux.indiceDoArrayAtividadesRealizadas();
		this.atividades_realizadas = new boolean[i];
	}

	
	public void arrayAtraso() {
		Pontuacao pontuacaoAux = new Pontuacao();
		
		int i = pontuacaoAux.indiceDoArrayAtividadesRealizadas();
		this.atrasos = new boolean[i];
	}

	
	
	
	public Long getId_pontuacao() {
		return id_pontuacao;
	}

	public void setId_pontuacao(Long id_pontuacao) {
		this.id_pontuacao = id_pontuacao;
	}

	public boolean[] getMarcar_presencas() {
		return marcar_presencas;
	}

	public void setMarcar_presencas(boolean[] marcar_presencas) {
		this.marcar_presencas = marcar_presencas;
	}

	public boolean[] getAtividades_realizadas() {
		return atividades_realizadas;
	}

	public void setAtividades_realizadas(boolean[] atividades_realizadas) {
		this.atividades_realizadas = atividades_realizadas;
	}

	public boolean[] getAtrasos() {
		return atrasos;
	}

	public void setAtrasos(boolean[] atrasos) {
		this.atrasos = atrasos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
