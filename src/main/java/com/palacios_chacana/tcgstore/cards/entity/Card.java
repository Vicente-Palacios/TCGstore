package com.palacios_chacana.tcgstore.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    private String id;

    private String name;        // Nombre de la carta (ej: "Charizard", "Black Lotus")
    private String game;        // Juego al que pertenece (ej: "Pokemon", "Magic", "Yu-Gi-Oh")
    private String setName;     // Edición/expansión (ej: "Base Set", "Alpha")
    private String rarity;      // Rareza (ej: "Common", "Rare", "Ultra Rare", "Secret Rare")
    private String condition;   // Estado físico (ej: "Near Mint", "Lightly Played", "Damaged")
    private Double price;
    private Integer stock;

    // Esto lo requiere JPA
    protected Card() {

    }

    public Card(String id, String name, String game, String setName, String rarity,
                String condition, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.game = game;
        this.setName = setName;
        this.rarity = rarity;
        this.condition = condition;
        this.price = price;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

