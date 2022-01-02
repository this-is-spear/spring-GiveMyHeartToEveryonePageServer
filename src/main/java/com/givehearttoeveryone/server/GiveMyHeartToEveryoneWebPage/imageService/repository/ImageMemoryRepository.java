package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ImageMemoryRepository implements ImageRepository{
    Map<Long, Map<Long, ImageItem>> imageItemList = new ConcurrentHashMap<>();

    @Override
    public Map<Long, ImageItem> getImageItemListByCardId(Long cardId) {
        return imageItemList.get(cardId);
    }

    @Override
    public ImageItem getImageItemByCardIdAndImageId(Long cardId, Long imageId) {
        return imageItemList.get(cardId).get(imageId);
    }

    @Override
    public void setImageItemsByCardId(Long cardId, Map<Long, ImageItem> imageItems) {
        imageItemList.put(cardId, imageItems);
    }

//    @Override
//    public void editImageItems(Long cardId, Map<Long, ImageItem> imageItems) {
//        saveImageItmes.put(cardId, imageItems);
//    }

    @Override
    public void deleteImageItemsByCardId(Long cardId) {
        imageItemList.remove(cardId);
    }
}
