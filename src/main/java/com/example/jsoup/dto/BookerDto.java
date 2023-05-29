package com.example.jsoup.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Field;

@AllArgsConstructor
@Getter
@Builder
public class BookerDto {
    private String book_name; // 책이름
    private String img_url; // 이미지url
    private String author; // 저자
    private String publisher; // 출판사
    private String introduction; // 한줄 소개
    private String star; // 별점
    private String pub_date; // 출판일
    private String category; // 카테고리
    private String insertion_time; //등록날짜
    private String modification_time; //수정날짜



    public boolean isDtoEntireVariableNull() {
        try {
            for (Field f : getClass().getDeclaredFields()) {
                if (f.get(this) != null) {
                    return false;
                }
            }
            return true;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
