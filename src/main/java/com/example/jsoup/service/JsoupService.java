package com.example.jsoup.service;


import com.example.jsoup.dto.BookerDto;
import com.example.jsoup.repository.JsoupRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class JsoupService {

    private final JsoupRepository jsoupRepository;

    public void jsoupbestservice() throws Exception {
        for (int j = 1; j < 399; j++) {
//            final String inflearnUrl = "http://www.yes24.com/24/category/bestseller?CategoryNumber=001001025&sumgb=06&PageNumber="+j;
            final String inflearnUrl = "http://www.yes24.com/24/Category/Display/001001001012?PageNumber=" + j;
            Connection conn = Jsoup.connect(inflearnUrl);
            Document doc = conn.get();

            //책이름
            Elements bookname = doc.select("td.goodsTxtInfo>p:nth-child(1)>a:nth-child(1)");
            //카테고리
            Elements category = doc.select("p.location>a");
//        System.out.println(category.text().replaceAll(" ", ">"));
            //이미지 링크
            Elements imgurl = doc.select("td.image>div.goodsImgW>a>img");
            // 저자, 출판사, 출판일자
            Elements authorandpub = doc.select("td.goodsTxtInfo>div.aupu");
            for (int i = 0; i < authorandpub.size(); i++) {
                String listline = authorandpub.get(i).text();  // 원본
                String author = listline.substring(0, listline.indexOf("|")).replaceAll(" ", "");  // 작성자
                String publisher = listline.substring(listline.indexOf("|") + 1).substring(0, listline.substring(listline.indexOf("|") + 1).indexOf("|")).replaceAll(" ", ""); //출판사
                String pub_date = listline.substring(listline.indexOf("|") + 1).substring(listline.substring(listline.indexOf("|") + 1).indexOf("|") + 1).replaceAll(" ", ""); // 출판일자
                System.out.println("책이름 : " + bookname.get(i).text());
                System.out.println("작성자 : " + author);
                System.out.println("출판사 : " + publisher);
                System.out.println("출판일자 : " + pub_date);
                System.out.println("이미지url : " + imgurl.attr("src"));
            }
        }
    }


    public void jsoupservice() {
        List<String> urlliStrings = new ArrayList<>();
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001011019");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001011018");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001011011");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025007");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025008");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025010");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025009");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025001");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025011");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025006");
//        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001025012");
//        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004020");
//        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004009");
//        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004019");
//        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004005"); //영어 독해/문법/작문/번역
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004001");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004004");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004002");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004012");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004003");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004010");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004008");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004014");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004006");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004018");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004011");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004016");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004013");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004015");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004007");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004004017");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003002");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003002");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003001");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003009");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003004");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003008");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003010");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003005");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004003007");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005007");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005010");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005006");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005005");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005001");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005004");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005003");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005008");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005002");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004005009");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006005");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006001");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006002");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006006");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006003");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006004");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006008");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004006007");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004007");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004012");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004011");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004010");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004009");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001004020");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001014008");
        urlliStrings.add("https://www.yes24.com/24/Category/Display/001001014008001004");
        urlliStrings.add("");


        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String insertion_time = formatter.format(date);
        String modification_time = formatter.format(date);


        for (int k = 0; k < urlliStrings.size(); k++) {
            int numbercount = countpage(urlliStrings.get(k));
            for (int j = 1; j < numbercount + 1; j++) {
                final String inflearnUrl = urlliStrings.get(k) + "?PageNumber=" + j;
                Connection conn = Jsoup.connect(inflearnUrl);
                try {
                    Document doc = conn.get();
                    //카테고리
                    Elements category = doc.select("h3.cateTit_txt");
                    //책이름
                    Elements bookname = doc.select("div.goods_info>div.goods_name>a:nth-child(2)");
                    // 저자
                    Elements author = doc.select("div.goods_pubGrp>span.goods_auth");
                    //출판사
                    Elements publisher = doc.select("div.goods_pubGrp>span.goods_pub");
                    //출판일
                    Elements pub_date = doc.select("div.goods_pubGrp>span.goods_date");
                    //한줄 소개
                    Elements introduction = doc.select("div.goods_info>div.goods_read");
                    //이미지 url
                    Elements img_url = doc.select("div.cCont_goodsSet>p.goods_img>span.goods_imgSet>span.imgBdr>a>img");
                    //별점
                    Elements star = doc.select("div.cCont_goodsSet>div.goods_info>div.goods_rating>span.gd_rating>em.yes_b");
                    BookerDto bookerDto;
                    String categorys = category.text();
                    for (int i = 0; i < star.size(); i++) {
                        String booknames = bookname.get(i).text();
                        String imgurl = img_url.get(i).attr("src");
                        String authors = author.get(i).text().replaceAll(" 저", "");
                        String publishers = publisher.get(i).text();
                        String introductions = introduction.get(i).text();
                        String starts = star.get(i).text();
                        String pubdate = pub_date.get(i).text();
                        bookerDto = new BookerDto(booknames, imgurl, authors, publishers, introductions, starts, pubdate, categorys,insertion_time,modification_time);
                        jsoupRepository.saveAndFlush(new com.example.jsoup.entity.Jsoup(bookerDto));
                    }
                } catch (Exception e) {
//                e.printStackTrace();
                    continue;
                }
            }
        }
    }


    public int countpage(String url) {
        final String inflearnUrlcount = url;
        Connection conn1 = Jsoup.connect(inflearnUrlcount);
        int numbercount = 0;
        try {
            Document doc = conn1.get();
            Elements page = doc.select("div.cCont_sortArea>div.cCont_sortBot>span.cCont_sortLft>div.yesUI_pagenS>a:last-child");
            String[] count = page.attr("href").split("PageNumber=");
            numbercount = Integer.parseInt(count[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numbercount;
    }
}
