package com.palacios_chacana.tcgstore.cards;

import com.palacios_chacana.tcgstore.cards.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}