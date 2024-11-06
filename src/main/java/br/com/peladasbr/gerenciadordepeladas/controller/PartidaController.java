package br.com.peladasbr.gerenciadordepeladas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.peladasbr.gerenciadordepeladas.entity.Partida;
import br.com.peladasbr.gerenciadordepeladas.service.PartidaService;

@RestController
@RequestMapping("/api/partidas")
public class PartidaController {
    @Autowired
    private PartidaService partidaService;

    @PostMapping
    public Partida criarPartida(@RequestBody Partida partida) {
        return partidaService.criarPartida(partida);
    }

    @GetMapping
    public List<Partida> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @PutMapping("/{id}/resultado")
    public Partida atualizarResultado(
            @PathVariable Long id,
            @RequestParam Integer golsTimeA,
            @RequestParam Integer golsTimeB) {
        return partidaService.atualizarResultado(id, golsTimeA, golsTimeB);
    }
}
