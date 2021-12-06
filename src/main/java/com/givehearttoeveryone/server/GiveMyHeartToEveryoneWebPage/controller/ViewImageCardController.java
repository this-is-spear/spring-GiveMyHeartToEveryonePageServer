package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.controller;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service.SaveImageCardService;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service.ViewImageCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Controller
public class ViewImageCardController {
    private final ViewImageCardService viewImageCardService;
    private final SaveImageCardService saveImageCardService;

    @Autowired
    public ViewImageCardController(ViewImageCardService viewImageCardService, SaveImageCardService saveImageCardService) {
        this.viewImageCardService = viewImageCardService;
        this.saveImageCardService = saveImageCardService;
    }

    @GetMapping("/image-card/temp")
    public String temporarySaveImageCardView(Model model){
        saveImageCardService.saveImageCard();
//        임시 cardId
        long cardId = 1L;
        List<TextItem> textItems = viewImageCardService.viewTextEnvent(cardId);
        model.addAttribute("textItems",textItems);
        List<ImageItem> imageItems = viewImageCardService.viewImageEnvent(cardId);
        model.addAttribute("imageItems", imageItems);
        return "";
    }
}
