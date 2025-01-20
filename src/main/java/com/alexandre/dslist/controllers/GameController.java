package com.alexandre.dslist.controllers;

import com.alexandre.dslist.dto.GameMinDTO;
import com.alexandre.dslist.entities.Game;
import com.alexandre.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//GameController seria como a porta de entrada do back end, ele que disponibiliza a API
@RestController
@RequestMapping(value = "/games")
public class GameController {
    //Injetando o Service no controller
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}
