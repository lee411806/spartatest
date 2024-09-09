package com.sparta.spratatest.dto;

import com.sparta.spratatest.entity.Item;
import lombok.Getter;

@Getter
public class ResponseDto {

    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
