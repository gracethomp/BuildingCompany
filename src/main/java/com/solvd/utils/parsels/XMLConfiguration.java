package com.solvd.utils.parsels;

public enum XMLConfiguration {
    USER("user"), USER_MANAGER("userManager"), USER_STATUS("userStatus"),
    CITY("city"), CITY_BUILDING("cityBuilding"),
    BUILDING_ORDERS("buildingOrders"), BUILDING_ORDER("buildingOrder"),
    BUILDING("building"), MANAGER("manager"), STATUS("status"),
    TYPE("type"), MATERIAL("constructionMaterial"), DEPARTMENT("department"),
    EMAIL("email"), PASSWORD("password"), FIRST_NAME("fName"),
    LAST_NAME("lName"), PHONE_NUMBER("phoneNumber"), AREA("area"),
    FLOORS("floors"), ADDRESS("address"), TITLE("title"),
    SALARY("salary"), EDIT_USER_RIGHTS("editUserRight"), ID("id"),
    EDIT_BUILDING_RIGHTS("editBuildingRight"), TOTAL_PRICE("totalPrice"),
    FILE("src/main/resources/client.xml");

    private String value;

    XMLConfiguration(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
