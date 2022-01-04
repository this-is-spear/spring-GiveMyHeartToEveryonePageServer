package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-29
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ImageService {
    // 저장
    void setImageList(Long cardId, Map<Long, ImageItem> imageItems);
    // 수정
    //void editImageItemsByCardIdAndItemId(Long cardId, Long ItemId);
    ImageItem getImageItem(Long cardId, Long imageId);
    // 삭제
    void deleteImageListByCardId(Long cardId);
    // 조회
    Map<Long, ImageItem> getImageListByCardId(Long cardId);
}
