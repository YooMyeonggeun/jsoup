package com.example.jsoup.entity;

import com.example.jsoup.dto.BookerDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "booker")
public class Jsoup{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String book_name;

    @Column(nullable = false)
    private String img_url;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, length = 1000)
    private String introduction;

    @Column(nullable = false)
    private String star;

    @Column(nullable = false)
    private String pub_date;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String insertion_time;

    @Column(nullable = false)
    private String modification_time;

    public  Jsoup(BookerDto bookerDto) {
        this.book_name = bookerDto.getBook_name();
        this.img_url = bookerDto.getImg_url();
        this.author = bookerDto.getAuthor();
        this.introduction = bookerDto.getIntroduction();
        this.star = bookerDto.getStar();
        this.pub_date = bookerDto.getPub_date();
        this.category = bookerDto.getCategory();
        this.insertion_time = bookerDto.getInsertion_time();
        this.modification_time = bookerDto.getModification_time();
    }

}
