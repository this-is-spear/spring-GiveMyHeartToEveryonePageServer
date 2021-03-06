package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class CardItem {
    private Long cardId;
    private String cardName;
    private Long memberId;
//    private Map<Long, ImageItem> imageItems;
//    private Map<Long, TextItem> textItems;

    public CardItem(Long cardId, String cardName, Long memberId) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.memberId = memberId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
