package com.alexandre.dslist.controllers;

import com.alexandre.dslist.dto.GameDTO;
import com.alexandre.dslist.dto.GameMinDTO;
import com.alexandre.dslist.entities.Game;
import com.alexandre.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GameController seria como a porta de entrada do back end, ele que disponibiliza a API
@RestController
@RequestMapping(value = "/games")
public class GameController {
    //Injetando o Service no controller
    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    @PostMapping
    public GameDTO insert(@RequestBody GameDTO gameDTO) {
        GameDTO result = gameService.insert(gameDTO);
        return result;
    }
}
