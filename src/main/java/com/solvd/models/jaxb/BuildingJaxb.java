package com.solvd.models.jaxb;

import com.solvd.models.BuildingType;
import com.solvd.models.City;
import com.solvd.models.ConstructionMaterial;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BuildingJaxb {
    private Long id;
    private BuildingTypeJaxb type;
    private Double area;
    private Integer floors;
    private ConstructionMaterialJaxb material;
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
        this.material = material;
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

    public ConstructionMaterialJaxb getMaterial() {
        return material;
    }

    public void setMaterial(ConstructionMaterialJaxb material) {
        this.material = material;
    }

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
                ", material=" + material +
                ", city=" + city +
                ", address='" + address + '\'' +
                '}';
    }
}
