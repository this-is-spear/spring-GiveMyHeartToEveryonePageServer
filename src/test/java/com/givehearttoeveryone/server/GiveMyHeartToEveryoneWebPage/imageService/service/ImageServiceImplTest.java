package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
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

    public ImageServiceImplTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.imageService = applicationContext.getBean("imageService", ImageService.class);
    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 저장")
    void setImageListByCardId() {
        Long cardId = 0L;
        Map<Long, ImageItem> imageItemList = new ConcurrentHashMap<>();
        imageService.setImageItems(cardId, imageItemList);
    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 리스트 가져오기")
    void getImageListByCardId() {
        Long cardId = 0L;
        Map<Long, ImageItem> imageItemList = imageService.getImageItemListByCardId(cardId);

    }

    @Test
    @DisplayName("카드 아이디를 이용해 이미지 삭제")
    void deleteImageListByCardId() {
        Long cardId = 0L;
        imageService.deleteImageItemsByCardId(cardId);
    }
}