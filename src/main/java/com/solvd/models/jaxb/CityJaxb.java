package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class CityJaxb {
    private Long id;
    private String cityName;

    public CityJaxb() {
    }

    public CityJaxb(Long id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }
    @XmlValue
    public String getCityName() {
        return cityName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "CityJaxb{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
