package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-19
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class SimpleQuickCardServiceTest{
    SimpleCardService simpleCardService;
    CardRepository cardRepository;
    ImageRepository imageRepository;
    TextRepository textRepository;

    Long sequence = 0L;
    Member imaspear = new Member(++sequence, "ImaSpear", Grade.VIP);

    @BeforeEach
    public void beforeEach(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        simpleCardService = applicationContext.getBean("simpleCardService", SimpleCardService.class);
        cardRepository = applicationContext.getBean("cardRepository", CardRepository.class);
        imageRepository = applicationContext.getBean("imageRepository", ImageRepository.class);
        textRepository = applicationContext.getBean("textRepository", TextRepository.class);
    }

    @Test
    @DisplayName("카드 아이템을 생성해 이미지와 텍스트를 저장하는 테스트")
    public void makeCardTest() throws Exception{
        //given
        Long memberId = this.imaspear.getMemberId();
        //when
        Map<Long, ImageItem> imageItems = new HashMap<>();
        for (Long i = 0L; i < 10L; i++) {
            new ImageItem(++i, "test/image/item");
        }
        Map<Long, TextItem> textItems = new HashMap<>();
        for (Long i = 0L; i < 10L; i++) {
            new TextItem(++i, "test/text/item");
        }
        Long cardId = simpleCardService.makeCard(memberId, imageItems, textItems);
        //then
        Assertions.assertThat(memberId).isEqualTo(cardRepository.getOneByCardId(cardId).getMemberId());
    }
}