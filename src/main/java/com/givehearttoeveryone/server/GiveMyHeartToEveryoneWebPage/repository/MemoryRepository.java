package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.TextItem;
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

    public void saveTextItembyCardId(long cardId) {
        TextItem item1 = new TextItem(++sequence,null,0,0,cardId);
        textStore.put(item1.getId(), item1);
        TextItem item2 = new TextItem(++sequence,null,0,0,cardId);
        textStore.put(item2.getId(), item2);
        TextItem item3 = new TextItem(++sequence,null,0,0,cardId);
        textStore.put(item3.getId(), item3);
        TextItem item4 = new TextItem(++sequence,null,0,0,cardId);
        textStore.put(item4.getId(), item4);
        TextItem item5 = new TextItem(++sequence,null,0,0,cardId);
        textStore.put(item5.getId(), item5);
    }

    public void saveImageItembyCardId(long cardId) {
        List<ImageItem> imageItemList = new ArrayList<>();
        ImageItem item1 = new ImageItem(++sequence, null, 0 , cardId);
        imageStore.put(item1.getId(), item1);
        ImageItem item2 = new ImageItem(++sequence, null, 0 , cardId);
        imageStore.put(item2.getId(), item2);
        ImageItem item3 = new ImageItem(++sequence, null, 0 , cardId);
        imageStore.put(item3.getId(), item3);
        ImageItem item4 = new ImageItem(++sequence, null, 0 , cardId);
        imageStore.put(item4.getId(), item4);
        ImageItem item5 = new ImageItem(++sequence, null, 0 , cardId);
        imageStore.put(item5.getId(), item5);
    }

    @Autowired
    public CardItem saveCardItem(){
        return new CardItem(++sequence, "card");
    }

//    @Override
//    public boolean findCardItem(long cardId) {
//        long cardId = this.cardId;
//        return false;
//    }

    @Override
    public boolean saveALlItem(long cardId) {
        try {
            saveTextItembyCardId(cardId);
            saveImageItembyCardId(cardId);
            return true;
        } catch (Exception e) {
//            throw new saveException();
            return false;
        }
//        finally{
////            finally 문 안에 return을 작성하면 위의 메소드 값은 finally 안에 있는 false 값으로 리턴한다.
////            return false;
//        }
    }
}
