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

import br.com.peladasbr.gerenciadordepeladas.entity.Jogador;
import br.com.peladasbr.gerenciadordepeladas.service.JogadorService;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {
    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public Jogador criarJogador(@RequestBody Jogador jogador) {
        return jogadorService.criarJogador(jogador);
    }

    @GetMapping
    public List<Jogador> listarJogadors() {
        return jogadorService.listarJogadors();
    }

    @GetMapping("/{id}")
	public Jogador buscarJogador(@PathVariable Long id) {
    	return jogadorService.buscarJogador(id);
	}

    @PutMapping("/{id}")
    public Jogador atualizarNome(
            @PathVariable Long id,
            @RequestParam String nome) {
        return jogadorService.atualizarNome(id, nome);
    }
    
    @DeleteMapping("/{id}")
    public void deletarJogador(@PathVariable Long id) {
		try {
			jogadorService.deletarJogador(id);			
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir o jogador!");
		}
    }
}
