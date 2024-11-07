package br.com.peladasbr.gerenciadordepeladas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.peladasbr.gerenciadordepeladas.entity.Jogador;
import br.com.peladasbr.gerenciadordepeladas.repository.JogadorRepository;

@Service
public class JogadorService {
    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador criarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listarJogadors() {
        return jogadorRepository.findAll();
    }

    public Jogador buscarJogador(Long id) {
		return jogadorRepository.findById(id).orElseThrow();
	}

    public Jogador atualizarNome(Long id, String nome) {
        Jogador jogador = buscarJogador(id);
        jogador.setNome(nome);
        return jogadorRepository.save(jogador);
    }
    
    public void deletarJogador(Long id) {
    	buscarJogador(id);
    	jogadorRepository.deleteById(id);
    }
}

