package com.alexandre.dslist.repositories;

import com.alexandre.dslist.entities.Game;
import com.alexandre.dslist.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Com a classe abaixo, extendendo de JpaRepository temos possibilidade termos acesso ao banco para consulta, inserção, atualização e deleção
//Lembrando que repository é o responsavel pelo acesso ao banco de dados
//Qdo tiver uma consulta SQL devo colocar no Repository
public interface GameRepository  extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
        SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")
    List<GameMinProjection> searchByList(Long listId);
}
