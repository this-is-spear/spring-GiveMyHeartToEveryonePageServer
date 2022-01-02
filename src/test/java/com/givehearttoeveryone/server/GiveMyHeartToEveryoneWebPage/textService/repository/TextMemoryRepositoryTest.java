package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import org.assertj.core.api.Assertions;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class TextMemoryRepositoryTest {
    private final TextRepository textRepository;

    public TextMemoryRepositoryTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.textRepository = applicationContext.getBean("textRepository", TextRepository.class);
    }

    Long sequence = 0L;
    Member member = new Member(sequence, "imaspear", Grade.VIP);
    CardItem testCard = new CardItem(++sequence, "testCard", member.getMemberId());

    @Test
    @DisplayName("임의의 텍스트 아이템을 생성해 저장")
    void saveTextItemsByCardId() {
        //given
        Map<Long, TextItem> textItems = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            TextItem textItem = new TextItem(++sequence, "/path/number");
            textItems.put(textItem.getTextId(), textItem);
        }
        //when
        Long testCardId = testCard.getCardId();
        textRepository.setTextItemsByCardId(testCardId, textItems);
        //then
    }


    @Test
    @DisplayName("cardId를 이용해 카드의 텍스트 정보 가져오기")
    void getTextItemsByCardId() {
        //given
        saveTextItemsByCardId();
        //when
        Long testCardId = testCard.getCardId();
        //then
        for(Long key: textRepository.getTextItemListByCardId(testCardId).keySet()){
            System.out.println(textRepository.getTextItemByCardIdAndTextId(testCardId, key));
        }
    }

    @Test
    @DisplayName("해당 카드의 텍스트 변경하기")
    void editTextItems() {
        saveTextItemsByCardId();
        Long testCardId = this.testCard.getCardId();

//      깊은 복사를 직접 해줘 판별하자
        Map<Long, TextItem> textItemMap = new HashMap<>();
        for (Long key :textRepository.getTextItemListByCardId(testCardId).keySet()) {
            TextItem textItem = new TextItem(key, textRepository.getTextItemListByCardId(testCardId).get(key).getPath() + "/new");
            textItemMap.put(textItem.getTextId(), textItem);
        }
        TextItem textItem = new TextItem(++sequence, "/path/new");
        textItemMap.put(textItem.getTextId(), textItem);

        textRepository.deleteTextItemsByCardId(testCardId);
        textRepository.setTextItemsByCardId(testCardId, textItemMap);

//      textItemMap과 textItems은 같은 객체이다. 하나를 변경하면 바뀐다.
//        textItemMap.clear();
//        assertThat(textItems).isEmpty();
    }

    @Test
    @DisplayName("해당 카드의 텍스트 삭제하기")
    void deleteTextItemsByCardId() {
        //given
        saveTextItemsByCardId();
        Long testCardId = this.testCard.getCardId();
        //when
        textRepository.deleteTextItemsByCardId(testCardId);
        //then
        System.out.println(textRepository.getTextItemListByCardId(testCardId));
    }
}