package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.service.ImageService;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2022-01-03
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class TextServiceImplTest {
    private final TextService textService;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final TextRepository textRepository;
    Long memberId;

    public TextServiceImplTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.textService = applicationContext.getBean("textService", TextService.class);
        this.memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
        this.cardRepository = applicationContext.getBean("cardRepository", CardRepository.class);
        this.textRepository = applicationContext.getBean("textRepository", TextRepository.class);
    }

    @BeforeEach
    void setUp() {
        Member member = new Member(10000L, "ThisIsSpear", Grade.VIP);
        Long memberId = memberRepository.setMember(member.getMemberId(), member);

        for (long i = 3000L; i < 4000L; i++) {
            Long cardId = i;
            CardItem cardItem = new CardItem(cardId, "ImASpear", memberId);
            cardRepository.setCardItem(cardId, cardItem);
            Map<Long, TextItem> textList = new ConcurrentHashMap<>();
            textList.put(1005L+i, new TextItem(1005L+i, "/path/new"+String.valueOf(i)));
            textList.put(3000L+i, new TextItem(3000L+i, "/path/new"+String.valueOf(i)));
            textService.setTextList(cardId, textList);
        }
    }

    @Test
    @DisplayName("카드 아이디를 이용해 다량의 이미지 저장")
    void setImageListByCardId() {

        for (long i = 0L; i < 1000L; i++) {
            Long cardId = i;
            CardItem cardItem = new CardItem(cardId, "ImASpear", memberId);
            cardRepository.setCardItem(cardId, cardItem);
            Map<Long, TextItem> textList = new ConcurrentHashMap<>();
            textList.put(1005L+i, new TextItem(1005L+i, "/path/new"+String.valueOf(i)));
            textList.put(3000L+i, new TextItem(3000L+i, "/path/new"+String.valueOf(i)));
            textService.setTextList(cardId, textList);
        }
        for (long i = 0L; i < 1000L; i++) {
            System.out.println();
            for(TextItem value:textRepository.getTextListByCardId(i).values()){
                System.out.println("value = " + value.toString());
            }
        }
    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 리스트 가져오기")
    void getImageListByCardId() {
        Long cardId = 3005L;
        for (TextItem value : textService.getTextListByCardId(cardId).values()){
            System.out.println("value = " + value.toString());
        }
    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 삭제")
    void deleteImageListByCardId() {
        Long cardId = 3005L;
        textService.deleteTextListByCardId(cardId);
        System.out.println("textRepository = " + textRepository.getTextListByCardId(cardId));
    }
}