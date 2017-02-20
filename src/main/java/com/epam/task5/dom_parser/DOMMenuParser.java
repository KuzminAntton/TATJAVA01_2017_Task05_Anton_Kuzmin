package com.epam.task5.dom_parser;


import com.epam.task5.bean.Meal;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMMenuParser {

    private static final String tagMenu = "menu";
    private static final String tagColdSnacks = "cold-snacks";
    private static final String tagHotSnacks = "hot-snacks";
    private static final String tagBreakfast = "breakfast";
    private static final String tagElement = "element";
    private static final String tagId = "id";
    private static final String tagName = "name";
    private static final String tagDiscription = "discription";
    private static final String tagPortion = "portion";
    private static final String tagPrice = "price";

    public static void startParser(String resourceName) throws IOException, SAXException {

        DOMParser parser = new DOMParser();
        parser.parse(resourceName);
        Document document = parser.getDocument();
        List<String> tagList = null;

        Element root = document.getDocumentElement();

        List<Meal> menu = new ArrayList<>();


        tagList = new ArrayList<>();
        tagList.add(tagColdSnacks);
        tagList.add(tagHotSnacks);
        tagList.add(tagBreakfast);



        Meal meal = null;

        for (int i = 0; i < tagList.size(); i++) {
            NodeList categoryNodes = root.getElementsByTagName(tagList.get(i));
            Element category = (Element) categoryNodes.item(0);
            NodeList mealNodes = category.getElementsByTagName(tagElement);


            for (int j = 0; j < mealNodes.getLength(); j++) {
                meal = new Meal();
                meal.setCategory(category.getAttribute(tagName));
                Element mealElement = (Element) mealNodes.item(j);


                meal.setId(Integer.parseInt(mealElement.getAttribute(tagId)));
                meal.setName(getSingleChild(mealElement, tagName).getTextContent().trim());
                meal.setDiscription(getSingleChild(mealElement, tagDiscription).getTextContent().trim());
                meal.setPortion(getSingleChild(mealElement, tagPortion).getTextContent().trim());
                meal.setPrice(Integer.parseInt(getSingleChild(mealElement, tagPrice).getTextContent().trim()));
                menu.add(meal);

            }


        }


//        for (int j = 0; j < mealNodes.getLength(); j++) {
//            meal = new Meal();
//            Element mealElement = (Element) mealNodes.item(j);
//
//
//            meal.setId(Integer.parseInt(mealElement.getAttribute("id")));
//            meal.setName(getSingleChild(mealElement, "name").getTextContent().trim());
//            meal.setDiscription(getSingleChild(mealElement, "discription").getTextContent().trim());
//            meal.setPortion(getSingleChild(mealElement, "portion").getTextContent().trim());
//            meal.setPrice(Integer.parseInt(getSingleChild(mealElement, "price").getTextContent().trim()));
//            menu.add(meal);
//
//        }


        for (Meal m : menu) {
            System.out.println(m);
        }


    }

    private static Element getSingleChild(Element element, String childName) {
        NodeList nlist = element.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

}
