package com.solvd.models.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuildingJaxb {
    private Long id;
    private BuildingTypeJaxb type;
    private Double area;
    private Integer floors;
    private ConstructionMaterialJaxb constructionMaterial;
    private CityJaxb city;
    private String address;

    public BuildingJaxb() {
    }

    public BuildingJaxb(Long id, BuildingTypeJaxb type, Double area, Integer floors,
                        ConstructionMaterialJaxb material, CityJaxb city, String address) {
        this.id = id;
        this.type = type;
        this.area = area;
        this.floors = floors;
        this.constructionMaterial = material;
        this.city = city;
        this.address = address;
    }
    @XmlAttribute
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingTypeJaxb getType() {
        return type;
    }

    public void setType(BuildingTypeJaxb type) {
        this.type = type;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public ConstructionMaterialJaxb getConstructionMaterial() {
        return constructionMaterial;
    }

    public void setConstructionMaterial(ConstructionMaterialJaxb constructionMaterial) {
        this.constructionMaterial = constructionMaterial;
    }
    @XmlElement(name = "cityBuilding")
    public CityJaxb getCity() {
        return city;
    }

    public void setCity(CityJaxb city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BuildingJaxb{" +
                "id=" + id +
                ", type=" + type +
                ", area=" + area +
                ", floors=" + floors +
                ", material=" + constructionMaterial +
                ", city=" + city +
                ", address='" + address + '\'' +
                '}';
    }
}
