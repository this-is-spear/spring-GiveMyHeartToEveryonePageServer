package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-29
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ImageService {
    // 저장
    void setImageItems(Long cardId, Map<Long, ImageItem> imageItems);
    // 수정
    //void editImageItemsByCardIdAndItemId(Long cardId, Long ItemId);
    // 삭제
    void deleteImageItemsByCardId(Long cardId);
    // 조회
    Map<Long, ImageItem> getImageItemListByCardId(Long cardId);
}
