package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
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
class ImageServiceImplTest {
    private final ImageService imageService;
    private final MemberRepository memberRepository;
    private final CardRepository cardRepository;
    private final ImageRepository imageRepository;
    Long memberId;

    public ImageServiceImplTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.imageService = applicationContext.getBean("imageService", ImageService.class);
        this.memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
        this.cardRepository = applicationContext.getBean("cardRepository", CardRepository.class);
        this.imageRepository = applicationContext.getBean("imageRepository", ImageRepository.class);
    }

    @BeforeEach
    void setUp() {
        Member member = new Member(10000L, "ThisIsSpear", Grade.VIP);
        Long memberId = memberRepository.setMember(member.getMemberId(), member);

        for (long i = 3000L; i < 4000L; i++) {
            Long cardId = i;
            CardItem cardItem = new CardItem(cardId, "ImASpear", memberId);
            cardRepository.setCardItem(cardId, cardItem);
            Map<Long, ImageItem> imageItemList = new ConcurrentHashMap<>();
            imageItemList.put(1005L+i, new ImageItem(1005L+i, "/path/new"+String.valueOf(i)));
            imageItemList.put(3000L+i, new ImageItem(3000L+i, "/path/new"+String.valueOf(i)));
            imageService.setImageList(cardId, imageItemList);
        }
    }

    @Test
    @DisplayName("카드 아이디를 이용해 다량의 이미지 저장")
    void setImageListByCardId() {

        for (long i = 0L; i < 1000L; i++) {
            Long cardId = i;
            CardItem cardItem = new CardItem(cardId, "ImASpear", memberId);
            cardRepository.setCardItem(cardId, cardItem);
            Map<Long, ImageItem> imageItemList = new ConcurrentHashMap<>();
            imageItemList.put(1005L+i, new ImageItem(1005L+i, "/path/new"+String.valueOf(i)));
            imageItemList.put(3000L+i, new ImageItem(3000L+i, "/path/new"+String.valueOf(i)));
            imageService.setImageList(cardId, imageItemList);
        }
        for (long i = 0L; i < 1000L; i++) {
            System.out.println();
            for(Long key:imageRepository.getImageItemListByCardId(i).keySet()){
                System.out.println("item"+ i +" = " + imageRepository.getImageItemByCardIdAndImageId(i,key));
            }
        }
    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 리스트 가져오기")
    void getImageListByCardId() {
        Long cardId = 3005L;
        imageService.getImageListByCardId(cardId);
        for (ImageItem imageItem : imageService.getImageListByCardId(cardId).values()){
            System.out.println("imageItem = " + imageItem.toString());
        }
//        Map<Long, ImageItem> imageItemList = imageService.getImageItemListByCardId(cardId);
    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 삭제")
    void deleteImageListByCardId() {
        Long cardId = 305L;
        imageService.deleteImageListByCardId(cardId);
        System.out.println("imageRepository = " + imageRepository.getImageItemListByCardId(cardId));
    }
}