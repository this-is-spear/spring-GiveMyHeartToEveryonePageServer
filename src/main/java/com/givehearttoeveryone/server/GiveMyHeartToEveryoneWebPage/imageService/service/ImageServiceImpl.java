package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;

import java.util.Map;

/**
 * Created by Imaspear on 2022-01-03
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ImageServiceImpl implements ImageService{
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public void setImageList(Long cardId, Map<Long, ImageItem> imageItems) {
        imageRepository.setImageItemsByCardId(cardId, imageItems);
    }

    @Override
    public void deleteImageListByCardId(Long cardId) {
        imageRepository.deleteImageItemsByCardId(cardId);
    }

    @Override
    public Map<Long, ImageItem> getImageListByCardId(Long cardId) {
        return imageRepository.getImageItemListByCardId(cardId);
    }

    @Override
    public ImageItem getImageItem(Long cardId, Long imageId) {
        return imageRepository.getImageItemByCardIdAndImageId(cardId, imageId);
    }
}
