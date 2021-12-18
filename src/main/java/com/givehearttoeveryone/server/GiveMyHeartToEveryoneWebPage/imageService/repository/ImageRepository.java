package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.ImageItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ImageRepository {
    Map<Long, ImageItem> getImageItemsByCardId(Long cardId);
    void setImageItemsByCardId(Long cardId, Map<Long, ImageItem> imageItems);
    void editImageItems(Long cardId, Map<Long, ImageItem> imageItems);
    void deleteImageItemsByCardId(Long cardId);
}