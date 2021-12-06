package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.enums.AlignText;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemoryRepository implements ItemRepository{

    private static Map<Long, CardItem> cardStore = new HashMap<>();
    private static Map<Long, ImageItem> imageStore = new HashMap<>();
    private static Map<Long, TextItem> textStore = new HashMap<>();
    private static long sequence = 0L;

    public boolean saveTextItembyCardId(long cardId) {
        try {
            TextItem item1 = new TextItem(++sequence,null,1,0,AlignText.CENTER,cardId);
            textStore.put(item1.getId(), item1);
            TextItem item2 = new TextItem(++sequence,null,2,0,AlignText.CENTER,cardId);
            textStore.put(item2.getId(), item2);
            TextItem item3 = new TextItem(++sequence,null,3, 0,AlignText.CENTER,cardId);
            textStore.put(item3.getId(), item3);
            TextItem item4 = new TextItem(++sequence,null,4, 0,AlignText.CENTER,cardId);
            textStore.put(item4.getId(), item4);
            TextItem item5 = new TextItem(++sequence,null,5, 0,AlignText.CENTER,cardId);
            textStore.put(item5.getId(), item5);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean saveImageItembyCardId(long cardId) {
        try {
            List<ImageItem> imageItemList = new ArrayList<>();
            ImageItem item1 = new ImageItem(++sequence,1, null, 0 , cardId);
            imageStore.put(item1.getId(), item1);
            ImageItem item2 = new ImageItem(++sequence,2, null, 0 , cardId);
            imageStore.put(item2.getId(), item2);
            ImageItem item3 = new ImageItem(++sequence,3, null, 0 , cardId);
            imageStore.put(item3.getId(), item3);
            ImageItem item4 = new ImageItem(++sequence,4, null, 0 , cardId);
            imageStore.put(item4.getId(), item4);
            ImageItem item5 = new ImageItem(++sequence,5, null, 0 , cardId);
            imageStore.put(item5.getId(), item5);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<TextItem> findTextItembyCardId(long cardId) {
        return null;
    }

    @Override
    public List<ImageItem> findImageItembyCardId(long cardId) {
        return null;
    }

    @Override
    public boolean findCardItem(long cardId) {
        return false;
    }

    @Override
    public CardItem temporarySaveCardItem(){
        return new CardItem(++sequence, "card");
    }

}
