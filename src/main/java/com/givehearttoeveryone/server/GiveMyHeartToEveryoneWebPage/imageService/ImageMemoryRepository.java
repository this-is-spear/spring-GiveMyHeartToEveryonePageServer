package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ImageMemoryRepository implements ImageRepository{
    Map<Long, Map<Long, ImageItem>> saveImageItmes = new HashMap<>();

    @Override
    public Map<Long, ImageItem> getImageItemsByCardId(Long cardId) {
        return saveImageItmes.get(cardId);
    }

    @Override
    public void saveImageItems(Long cardId, Map<Long, ImageItem> imageItems) {
        saveImageItmes.put(cardId, imageItems);
    }

    @Override
    public void editImageItems(Long cardId, Map<Long, ImageItem> imageItems) {
        saveImageItmes.put(cardId, imageItems);
    }

    @Override
    public void deleteImageItemsByCardId(Long cardId) {
        saveImageItmes.remove(cardId);
    }
}
