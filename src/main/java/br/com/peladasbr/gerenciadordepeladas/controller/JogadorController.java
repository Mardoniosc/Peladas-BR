package br.com.peladasbr.gerenciadordepeladas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.peladasbr.gerenciadordepeladas.entity.Jogador;
import br.com.peladasbr.gerenciadordepeladas.service.JogadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/jogadores")
@Tag(name = "Jogadores", description = "Gerenciamento das jogadores de futebol amador")
public class JogadorController {
    @Autowired
    private JogadorService jogadorService;

    @Operation(summary = "Cadastra uma jogador")
    @PostMapping
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorService.criarJogador(jogador);
    }

    @Operation(summary = "Busca todas as jogadores", description = "Retorna uma lista de todas as jogadores registradas")
    @GetMapping
    public List<Jogador> listarJogadors() {
        return jogadorService.listarJogadors();
    }

    @Operation(summary = "Busca uma jogador")
    @GetMapping("/{id}")
	public Jogador buscarJogador(@PathVariable Long id) {
    	return jogadorService.buscarJogador(id);
	}

    @Operation(summary = "Atualiza o nome de um jogador")
    @PatchMapping("/{id}")
    public Jogador atualizarNome(
            @PathVariable Long id,
            @RequestParam String nome) {
        return jogadorService.atualizarNome(id, nome);
    }
    
    @Operation(summary = "Exclui uma jogador")
    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Long id) {
		try {
			jogadorService.deletarJogador(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir o jogador!");
		}
    }
}
