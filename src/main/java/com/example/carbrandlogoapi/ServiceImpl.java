package com.example.carbrandlogoapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200/")
@Service
public class ServiceImpl implements ModelService {

    @Override
    public List<Model> getModels() throws IOException {

        String url = "https://www.carlogos.org/car-brands/list_1_1.html";
        Document doc = Jsoup.connect(url).userAgent("Mozilla/11").get();
        Elements ul = doc.select(".logo-list");
        Elements li = ul.select("li");

        List<Model> modelList = new ArrayList<>();

        for (Element temp : li) {

            String logoURL = "https://www.carlogos.org" + temp.childNode(0).childNode(0).attributes().get("src");
            String brand = temp.select("a").first().childNode(1).toString();

            if (modelList.size() == 48) {
                url = "https://www.carlogos.org/car-brands/list_1_2.html";
                doc =Jsoup.connect(url).userAgent("Mozilla/11").get();
                ul=doc.select(".logo-list");
                li = ul.select("li");
            }

            modelList.add(new Model(brand, logoURL));
        }

        //multiple for loops will be removed/replaced for better performance soon...
        //recursive function

        for (Element temp : li) {

            String logoURL = "https://www.carlogos.org" + temp.childNode(0).childNode(0).attributes().get("src");
            String brand = temp.select("a").first().childNode(1).toString();

            if (modelList.size() == 95) {
                url = "https://www.carlogos.org/car-brands/list_1_3.html";
                doc =Jsoup.connect(url).userAgent("Mozilla/11").get();
                ul=doc.select(".logo-list");
                li = ul.select("li");
            }

            modelList.add(new Model(brand, logoURL));
        }

        for (Element temp : li) {

            String logoURL = "https://www.carlogos.org" + temp.childNode(0).childNode(0).attributes().get("src");
            String brand = temp.select("a").first().childNode(1).toString();

            modelList.add(new Model(brand, logoURL));
        }

        return modelList;
    }
}
