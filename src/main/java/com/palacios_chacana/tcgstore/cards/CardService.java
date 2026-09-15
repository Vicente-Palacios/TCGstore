
package com.palacios_chacana.tcgstore.cards;

import com.palacios_chacana.tcgstore.cards.dto.CardRequestDto;
import com.palacios_chacana.tcgstore.cards.dto.CardResponseDto;
import com.palacios_chacana.tcgstore.cards.entity.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardResponseDto> getAll() {
        return cardRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Optional<CardResponseDto> getById(String id) {
        return cardRepository.findById(id).map(this::toResponseDto);
    }

    public CardResponseDto create(CardRequestDto request) {
        Card card = new Card(
                UUID.randomUUID().toString(),
                request.name(),
                request.game(),
                request.setName(),
                request.rarity(),
                request.condition(),
                request.price(),
                request.stock()
        );
        return toResponseDto(cardRepository.save(card));
    }

    public Optional<CardResponseDto> update(String id, CardRequestDto request) {
        return cardRepository.findById(id).map(card -> {
            card.setName(request.name());
            card.setGame(request.game());
            card.setSetName(request.setName());
            card.setRarity(request.rarity());
            card.setCondition(request.condition());
            card.setPrice(request.price());
            card.setStock(request.stock());
            return toResponseDto(cardRepository.save(card));
        });
    }

    public Optional<CardResponseDto> partialUpdate(String id, CardRequestDto request) {
        return cardRepository.findById(id).map(card -> {
            if (request.name() != null) card.setName(request.name());
            if (request.game() != null) card.setGame(request.game());
            if (request.setName() != null) card.setSetName(request.setName());
            if (request.rarity() != null) card.setRarity(request.rarity());
            if (request.condition() != null) card.setCondition(request.condition());
            if (request.price() != null) card.setPrice(request.price());
            if (request.stock() != null) card.setStock(request.stock());
            return toResponseDto(cardRepository.save(card));
        });
    }

    public boolean delete(String id) {
        if (!cardRepository.existsById(id)) {
            return false;
        }
        cardRepository.deleteById(id);
        return true;
    }

    private CardResponseDto toResponseDto(Card card) {
        return new CardResponseDto(
                card.getId(),
                card.getName(),
                card.getGame(),
                card.getSetName(),
                card.getRarity(),
                card.getCondition(),
                card.getPrice(),
                card.getStock()
        );
    }
}
