package br.com.peladasbr.gerenciadordepeladas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/partidas")
@Tag(name = "Partidas", description = "Gerenciamento das partidas de futebol amador")
public class PartidaController {
    @Autowired
    private PartidaService partidaService;

    @Operation(summary = "Cadastra uma partida")
    @PostMapping
    public Partida criarPartida(@RequestBody Partida partida) {
        return partidaService.criarPartida(partida);
    }

    @Operation(summary = "Busca todas as partidas", description = "Retorna uma lista de todas as partidas registradas")
    @GetMapping
    public List<Partida> listarPartidas() {
        return partidaService.listarPartidas();
    }

    @Operation(summary = "Busca uma partida")
    @GetMapping("/{id}")
	public Partida buscarPartida(@PathVariable Long id) {
    	return partidaService.buscarPartida(id);
	}

    @Operation(summary = "Atualiza o resultado de gols da partida")
    @PutMapping("/{id}/resultado")
    public Partida atualizarResultado(
            @PathVariable Long id,
            @RequestParam Integer golsTimeA,
            @RequestParam Integer golsTimeB) {
        return partidaService.atualizarResultado(id, golsTimeA, golsTimeB);
    }
    
    @Operation(summary = "Exclui uma partida")
    @DeleteMapping("/{id}")
    public void deletarPartida(@PathVariable Long id) {
		try {
			partidaService.deletarPartida(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir uma partida que possui jogadores");
		}
    }
}
