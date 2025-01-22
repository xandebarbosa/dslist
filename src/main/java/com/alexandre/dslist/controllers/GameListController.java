package com.alexandre.dslist.controllers;

import com.alexandre.dslist.dto.GameDTO;
import com.alexandre.dslist.dto.GameListDTO;
import com.alexandre.dslist.dto.GameMinDTO;
import com.alexandre.dslist.services.GameListService;
import com.alexandre.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//GameController seria como a porta de entrada do back end, ele que disponibiliza a API
@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    //Injetando o Service no controller
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }
}
