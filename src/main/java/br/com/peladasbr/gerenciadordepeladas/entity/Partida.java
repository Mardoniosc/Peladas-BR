package br.com.peladasbr.gerenciadordepeladas.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime dataHora;
    
    private String local;

    @ManyToMany
    private List<Jogador> jogadoresTimeA = new ArrayList<>();

    @ManyToMany
    private List<Jogador> jogadoresTimeB = new ArrayList<>();

    private Integer golsTimeA;
    private Integer golsTimeB;
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public List<Jogador> getJogadoresTimeA() {
		return jogadoresTimeA;
	}
	public void setJogadoresTimeA(List<Jogador> jogadoresTimeA) {
		this.jogadoresTimeA = jogadoresTimeA;
	}
	public List<Jogador> getJogadoresTimeB() {
		return jogadoresTimeB;
	}
	public void setJogadoresTimeB(List<Jogador> jogadoresTimeB) {
		this.jogadoresTimeB = jogadoresTimeB;
	}
	public Integer getGolsTimeA() {
		return golsTimeA;
	}
	public void setGolsTimeA(Integer golsTimeA) {
		this.golsTimeA = golsTimeA;
	}
	public Integer getGolsTimeB() {
		return golsTimeB;
	}
	public void setGolsTimeB(Integer golsTimeB) {
		this.golsTimeB = golsTimeB;
	}

}
