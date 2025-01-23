package com.alexandre.dslist.controllers;

import com.alexandre.dslist.dto.GameDTO;
import com.alexandre.dslist.dto.GameListDTO;
import com.alexandre.dslist.dto.GameMinDTO;
import com.alexandre.dslist.dto.ReplacementDTO;
import com.alexandre.dslist.services.GameListService;
import com.alexandre.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GameController seria como a porta de entrada do back end, ele que disponibiliza a API
@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    //Injetando o Service no controller
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
}
