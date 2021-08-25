package com.example.carbrandlogoapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
@Service

public class ServiceImpl implements ModelService{

    @Override
    public List<Model> getModels() throws IOException {
        Document doc = Jsoup.connect("https://www.carlogos.org/car-brands/list_1_1.html").userAgent("Mozilla/11").get();
        Elements ul = doc.select(".logo-list");
        Elements li = ul.select("li");
        List<Model> modelList=new ArrayList<>();

        for(Element temp:li){

            String logoURL="https://www.carlogos.org"+temp.childNode(0).childNode(0).attributes().get("src");
            String brand=temp.select("a").first().childNode(1).toString();
            modelList.add(new Model(brand,logoURL));
        }
        return modelList;
    }
}
