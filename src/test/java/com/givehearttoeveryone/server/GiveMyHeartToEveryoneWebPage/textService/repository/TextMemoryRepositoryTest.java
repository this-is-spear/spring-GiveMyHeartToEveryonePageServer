package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import org.assertj.core.api.Assertions;
import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class TextMemoryRepositoryTest {
    Map<Long, Map<Long, TextItem>> saveTextItemsByCardId;
    Long sequence = 0L;
    Member member = new Member(sequence, "imaspear", Grade.VIP);
    CardItem testCard = new CardItem(++sequence, "testCard", member.getMemberId());
    @BeforeEach
    void set(){
        saveTextItemsByCardId = new HashMap<>();
    }

    @Test
    @DisplayName("임의의 텍스트 아이템을 생성해 저장")
    void saveTextItemsByCardId() {
        //given
        Map<Long, TextItem> textItems = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            TextItem textItem = new TextItem(++sequence, "/path/number");
            textItems.put(textItem.getTextId(), textItem);
        }
        //when
        saveTextItemsByCardId.put(testCard.getCardId(), textItems);
        //then
        assertThat(textItems).isEqualTo(saveTextItemsByCardId.get(testCard.getCardId()));
    }


    @Test
    @DisplayName("cardId를 이용해 카드의 텍스트 정보 가져오기")
    void getTextItemsByCardId() {
        //given
        saveTextItemsByCardId();
        //when
        Long testCardId = testCard.getCardId();
        //then
        for(Long key: saveTextItemsByCardId.get(testCardId).keySet()){
            assertThat(saveTextItemsByCardId.get(testCardId).get(key).getPath()).isNotEmpty();
        }
    }

    @Test
    @DisplayName("해당 카드의 텍스트 변경하기")
    void editTextItems() {
        saveTextItemsByCardId();
//      깊은 복사를 직접 해줘 판별하자
        Map<Long, TextItem> textItemMap = new HashMap<>();
        for (Long key : saveTextItemsByCardId.get(testCard.getCardId()).keySet()) {
            TextItem textItem = new TextItem(saveTextItemsByCardId.get(testCard.getCardId()).get(key).getTextId(), saveTextItemsByCardId.get(testCard.getCardId()).get(key).getPath() + "/new");
            textItemMap.put(textItem.getTextId(), textItem);
        }
        TextItem textItem = new TextItem(++sequence, "/path/new");
        textItemMap.put(textItem.getTextId(), textItem);
        saveTextItemsByCardId.replace(testCard.getCardId(), textItemMap);

//      textItemMap과 textItems은 같은 객체이다. 하나를 변경하면 바뀐다.
//        textItemMap.clear();
//        assertThat(textItems).isEmpty();
    }

    @Test
    @DisplayName("해당 카드의 텍스트 삭제하기")
    void deleteTextItemsByCardId() {
        //given
        saveTextItemsByCardId();
        Long cardId = this.testCard.getCardId();
        //when
        saveTextItemsByCardId.remove(cardId);
        //then
        assertThat(saveTextItemsByCardId.get(cardId)).isNull();
    }
}