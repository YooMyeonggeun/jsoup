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



    public void test() {
        final String inflearnUrl = "https://www.yes24.com/24/Category/Display/001001001";
        Connection conn = Jsoup.connect(inflearnUrl);
        try {
            Document doc = conn.get();
            Elements el = doc.select("div#cateLiWrap>ul#mCateLi>li.cate2d>div.subCateLi.clearfix>ul>li>a");
            System.out.println("사이즈 : "+el.size());
            for (int i = 0; i < 3; i++) {
                System.out.println(el.get(i).attr("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    // url 가져오는 함수
    public List<String> yes24url() {
        final String inflearnUrl = "https://www.yes24.com/24/Category/Display/001001001";
        Connection conn = Jsoup.connect(inflearnUrl);
        List<String> arrlist = new ArrayList<>();;
        try {
            Document doc = conn.get();
            Elements el = doc.select("div#cateLiWrap>ul#mCateLi>li.cate2d>div.subCateLi.clearfix>ul>li>a");
            for (int i = 0; i < 9; i++) {
                arrlist.add(el.get(i).attr("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrlist;
    }



    public void jsoupservice() {
        List<String> urlliStrings = yes24url();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String insertion_time = formatter.format(date);
        String modification_time = formatter.format(date);

        int counts = 0;
        for (int k = 0; k < urlliStrings.size(); k++) {
            int numbercount = countpage(urlliStrings.get(k));
            for (int j = 1; j < numbercount + 1; j++) {
                final String inflearnUrl = urlliStrings.get(k) + "?PageNumber=" + j;
                Connection conn = Jsoup.connect("https://www.yes24.com/"+inflearnUrl);
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
                        if(booknames != null && imgurl != null && authors != null &&  publishers != null && introductions != null && starts != null &&  pubdate != null && categorys != null) {
                            jsoupRepository.saveAndFlush(new com.example.jsoup.entity.Jsoup(bookerDto));
                        }else{
                            counts += 1;
                            continue;
                        }
                    }
                } catch (Exception e) {
//                e.printStackTrace();
                    continue;
                }
            }

            System.out.println("누락된 숫자 : "+counts);
        }
    }


    //마지막페이지 알아보는 함수
    public int countpage(String url) {
        final String inflearnUrlcount = url;
        Connection conn1 = Jsoup.connect("https://www.yes24.com/"+inflearnUrlcount);
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
