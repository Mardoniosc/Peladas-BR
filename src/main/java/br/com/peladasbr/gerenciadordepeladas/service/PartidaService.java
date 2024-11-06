package br.com.peladasbr.gerenciadordepeladas.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Partida> buscarPartida(Long id) {
        return partidaRepository.findById(id);
    }

    public Partida atualizarResultado(Long id, Integer golsTimeA, Integer golsTimeB) {
        Partida partida = partidaRepository.findById(id).orElseThrow();
        partida.setGolsTimeA(golsTimeA);
        partida.setGolsTimeB(golsTimeB);
        return partidaRepository.save(partida);
    }
}

