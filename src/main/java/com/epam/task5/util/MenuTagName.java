package com.epam.task5.util;


public enum MenuTagName {
    NAME,
    PRICE,
    DISCRIPTION,
    PORTION,
    ELEMENT,
    PHOTOURL,
    COLD_SNACKS,
    HOT_SNACKS,
    BREAKFAST,
    MENU_MENU;

    public static MenuTagName getElementTagName(String element) {
        switch (element) {
            case "name":
                return NAME;
            case "price":
                return PRICE;
            case "discription":
                return DISCRIPTION;
            case "portion":
                return PORTION;
            case "element":
                return ELEMENT;
            case "photourl":
                return PHOTOURL;
            case "cold-snacks":
                return COLD_SNACKS;
            case "hot-snacks":
                return HOT_SNACKS;
            case "breakfast":
                return BREAKFAST;
            case "menu":
                return MENU_MENU;
            default:
                throw new EnumConstantNotPresentException(MenuTagName.class,element);


        }
    }
}
