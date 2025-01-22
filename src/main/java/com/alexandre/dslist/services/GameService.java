package com.alexandre.dslist.services;

//Como Game service e uma classe comum e não esta herdando de nada, Temos que registrar a classe GameService
// como sendo um componente do sistema,
// isso e um conceito mportante no desenvolvimento de sistemas utilizando frameworks, temos cos componentes que tem que ser
// registrados, por que o framework que vai gerenciar esses componentes para gene, ele que sabe instanciar o componente
// para reaproveitar. Para registrar basta colocar @Component, podemos colocar um apelido @Service, vai registrar como sendo um componente do sistema
// Podemos injetarr um componente no outro, qdo fazemos a composição de componentes, chamamos de injetar

import com.alexandre.dslist.dto.GameDTO;
import com.alexandre.dslist.dto.GameMinDTO;
import com.alexandre.dslist.entities.Game;
import com.alexandre.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    //para implementar findAll vamos Injetar o GameRepository
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDTO gameDTO = new GameDTO(result);
        return gameDTO;
    }

    //Vai devolver uma list de games resumidos GameMinDTO
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        //List de GameMinDTO para obter os dados minimos
        //stream = lib do Java que permite fazer operações com sequência de dados,
        // chamando Map que transforma obetos de uma coisa para outra
        //e para voltar esse stream para ua lista normal colocamos no final .toList
        List<GameMinDTO> dto = result.stream().map(game -> new GameMinDTO(game)).toList();
        return dto;
    }
}
