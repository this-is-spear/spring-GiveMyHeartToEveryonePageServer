package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ViewImageCardService {
    private final ItemRepository itemRepository;

    @Autowired
    public ViewImageCardService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<TextItem> viewTextEnvent(long cardId){

        List<TextItem> items = itemRepository.findTextItembyCardId(cardId);
        return null;
    }

    public List<ImageItem> viewImageEnvent(long cardId){

        List<ImageItem> items = itemRepository.findImageItembyCardId(cardId);
        return null;
    }
}
