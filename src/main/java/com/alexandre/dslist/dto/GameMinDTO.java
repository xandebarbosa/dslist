package com.alexandre.dslist.dto;

import com.alexandre.dslist.entities.Game;
import jakarta.persistence.Column;

public class GameMinDTO {

    //Colocar somente os dados minimos
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {}

    //Gerando um GameMinDO copiando os dados da enidade, vou instanciar GameMinDTO a partir do objeto game, copiando os dados do game para o dto
    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    //DTO precisamos somente dos metodos Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
