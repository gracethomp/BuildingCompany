package com.solvd.models.abstractions;

public abstract class AbstractCity extends Entity{
    private String cityName;

    public AbstractCity(){}
    public AbstractCity(Long id, String cityName){
        super(id);
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' + '}';
    }
}
