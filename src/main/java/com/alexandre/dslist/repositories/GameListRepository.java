package com.alexandre.dslist.repositories;

import com.alexandre.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

//Com a classe abaixo, extendendo de JpaRepository temos possibilidade termos acesso ao banco para consulta, inserção, atualização e deleção
public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
            void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
