package br.com.peladasbr.gerenciadordepeladas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.peladasbr.gerenciadordepeladas.entity.Partida;
import br.com.peladasbr.gerenciadordepeladas.repository.PartidaRepository;

@Service
public class PartidaService {
    @Autowired
    private PartidaRepository partidaRepository;

    public Partida criarPartida(Partida partida) {
        return partidaRepository.save(partida);
    }

    public List<Partida> listarPartidas() {
        return partidaRepository.findAll();
    }

    public Partida buscarPartida(Long id) {
		return partidaRepository.findById(id).orElseThrow();
	}

    public Partida atualizarResultado(Long id, Integer golsTimeA, Integer golsTimeB) {
        Partida partida = buscarPartida(id);
        partida.setGolsTimeA(golsTimeA);
        partida.setGolsTimeB(golsTimeB);
        return partidaRepository.save(partida);
    }
    
    public Partida atualizarJogadoresTimes(Partida partidaAtualizada) {
    	Partida partida = buscarPartida(partidaAtualizada.getId());
    	partida.setJogadoresTimeA(partidaAtualizada.getJogadoresTimeA());
    	partida.setJogadoresTimeB(partidaAtualizada.getJogadoresTimeB());
    	return partidaRepository.save(partida);
    }
    
    public void deletarPartida(Long id) {
    	buscarPartida(id);
    	partidaRepository.deleteById(id);
    }
}

