package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageMemoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class CardMemoryRepositoryTest {
    
    Map<Long, CardItem> cardItemMap = new HashMap<>();
    Long sequence = 0L;
    Member imaspear = new Member(sequence, "imaspear", Grade.VIP);
    Member imnotaspear = new Member(++sequence, "imnotaspear",Grade.Basic);
    
    @BeforeEach
    void setUp() {
//      기존 저장되어 있는 객체들이라 가정
        for (int i = 0; i < 20; i++) {
            CardItem itemOfImaspear = new CardItem(++sequence, "hihi" + i, imaspear.getMemberId());
            CardItem itemOfImnotaspear = new CardItem(++sequence, "youdo" + i, imnotaspear.getMemberId());

            cardItemMap.put(itemOfImaspear.getCardId(), itemOfImaspear);
            cardItemMap.put(itemOfImnotaspear.getCardId(), itemOfImnotaspear);
        }
    }

    @Test
    @DisplayName("카드 하나 조회하기 위해 카드 ID를 이용해 데이터 가져오기")
    void getOneByCardId() {
        for (Long i = 5L; i < 20L; i++) {
            System.out.println(cardItemMap.get(i));
            Assertions.assertThat(cardItemMap.get(i)).isNotNull();
        }
    }

    @Test
    @DisplayName("추가로 데이터들을 저장하기")
    void saveOneByCardId() {
        for (int i = 0; i < 20; i++) {
            CardItem itemOfImaspear = new CardItem(++sequence, "hihi" + i, imaspear.getMemberId());
            CardItem itemOfImnotaspear = new CardItem(++sequence, "youdo" + i, imnotaspear.getMemberId());
            cardItemMap.put(itemOfImaspear.getCardId(), itemOfImaspear);
            cardItemMap.put(itemOfImnotaspear.getCardId(), itemOfImnotaspear);
        }
        Assertions.assertThat(cardItemMap.size()).isEqualTo(80);
    }

    @Test
    @DisplayName("카드 하나 삭제하기")
    void deleteOneByCardId() {
        if(!cardItemMap.isEmpty()){
            cardItemMap.remove(5L);
        }
        Assertions.assertThat(cardItemMap.get(5L)).isNull();
    }
}