package com.alexandre.dslist.repositories;

import com.alexandre.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

//Com a classe abaixo, extendendo de JpaRepository temos possibilidade termos acesso ao banco para consulta, inserção, atualização e deleção
public interface GameRepository  extends JpaRepository<Game, Long> {
}
