package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class ImageMemoryRepositoryTest {

    Map<Long, Map<Long, ImageItem>> saveImageItemsByCardId;
    Long sequence = 0L;
    Member member = new Member(sequence, "imaspear", Grade.VIP);
    CardItem testCard = new CardItem(++sequence, "testCard", member.getMemberId());

    @BeforeEach
    void set(){
        saveImageItemsByCardId = new HashMap<>();
    }

    @Test
    @DisplayName("임의의 이미지 아이템을 생성해 저장")
    void saveTextItemsByCardId() {
        //given
        Map<Long, ImageItem> imageItems = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            ImageItem imageItem = new ImageItem(++sequence, "/path/number");
            imageItems.put(imageItem.getImageId(), imageItem);
        }
        Long testCardId = testCard.getCardId();
        //when
        saveImageItemsByCardId.put(testCard.getCardId(), imageItems);
        //then
        assertThat(imageItems).isEqualTo(saveImageItemsByCardId.get(testCardId));
    }


    @Test
    @DisplayName("임의의 이미지 아이템을 가져오기")
    void getTextItemsByCardId() {
        //given
        saveTextItemsByCardId();
        Long testCardId = testCard.getCardId();
        //when
        //then
        for(Long key: saveImageItemsByCardId.get(testCardId).keySet()){
            System.out.println(saveImageItemsByCardId.get(testCardId).get(key).toString());
        }
    }

    @Test
    @DisplayName("하나의 카드 아이디를 가져와 수정하기")
    void editTextItems() {
        //given
        saveTextItemsByCardId();
        Long cardId = this.testCard.getCardId();
//      깊은 복사를 직접 해줘 판별하자
        Map<Long, ImageItem> imageItemMap = new HashMap<>();
        for (Long key : saveImageItemsByCardId.get(cardId).keySet()) {
            ImageItem textItem = new ImageItem(this.saveImageItemsByCardId.get(cardId).get(key).getImageId(), saveImageItemsByCardId.get(cardId).get(key).getPath() + "/new");
            imageItemMap.put(textItem.getImageId(), textItem);
        }
        //when
        ImageItem imageItem = new ImageItem(++sequence, "/path/new");
        imageItemMap.put(imageItem.getImageId(), imageItem);
        saveImageItemsByCardId.replace(testCard.getCardId(), imageItemMap);
        //then
//      imageItems을 전역변수로 설정하고, 이 메서드에서 전역 변수를 호출해서 사용하면 깊은 복사가 이뤄질 수 밖에 없다.
//      textItemMap과 textItems은 같은 객체이다. 하나를 변경하면 바뀐다.
//        textItemMap.clear();
//        assertThat(textItems).isEmpty();
//        assertThat(saveImageItemsByCardId.get(testCard.getCardId()))
    }

    @Test
    @DisplayName("삭제하는 테스트")
    void deleteTextItemsByCardId() {
        //given
        saveTextItemsByCardId();
        Long cardId = this.testCard.getCardId();
        //when
        saveImageItemsByCardId.remove(cardId);
        //then
        assertThat(saveImageItemsByCardId.get(cardId)).isNull();
    }

}