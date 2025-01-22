package com.alexandre.dslist.projections;

// Interface usada como uma "projeção" para consultas específicas no banco de dados.
// Permite selecionar apenas os campos necessários, otimizando o uso de recursos.
// Projections são úteis para evitar carregar toda a entidade e para moldar os resultados das consultas.
// Essa interface é interpretada automaticamente pelo Spring Data JPA.

public interface GameMinProjection {
    // Deve ter métodos "get" correspondentes às colunas ou campos retornados pela consulta.
    // Esses métodos definem o "shape" do objeto retornado pelo banco de dados.

    // Retorna o ID do jogo (geralmente a chave primária).
    Long getId();
    // Retorna o título do jogo.
    String getTitle();
    // Retorna o ano de lançamento do jogo.
    Integer getYear();
    // Retorna a URL da imagem do jogo.
    String getImgUrl();
    // Retorna uma descrição curta do jogo.
    String getShortDescription();
    // Retorna a posição do jogo em um ranking ou lista.
    Integer getPosition();
}
