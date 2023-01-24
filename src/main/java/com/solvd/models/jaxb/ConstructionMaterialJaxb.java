package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class ConstructionMaterialJaxb {
    private Long id;
    private String material;

    public ConstructionMaterialJaxb() {
    }

    public ConstructionMaterialJaxb(Long id, String material) {
        this.id = id;
        this.material = material;
    }

    @XmlAttribute
    public Long getId() {
        return id;
    }
    @XmlValue
    public String getMaterial() {
        return material;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "ConstructionMaterialJaxb{" +
                "id=" + id +
                ", material='" + material + '\'' +
                '}';
    }
}
