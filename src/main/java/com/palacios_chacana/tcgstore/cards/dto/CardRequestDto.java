package com.palacios_chacana.tcgstore.cards.dto;

public record CardRequestDto(
        String name,
        String game,
        String setName,
        String rarity,
        String condition,
        Double price,
        Integer stock
) {
}
