package br.com.peladasbr.gerenciadordepeladas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.peladasbr.gerenciadordepeladas.entity.Partida;


@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {}