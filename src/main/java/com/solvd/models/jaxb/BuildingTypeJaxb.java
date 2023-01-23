package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class BuildingTypeJaxb {
    private Long id;
    private String type;

    public BuildingTypeJaxb() {
    }

    public BuildingTypeJaxb(Long id, String type) {
        this.id = id;
        this.type = type;
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @XmlValue
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BuildingTypeJaxb{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
