package com.bolton.patpat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {


    private int adId;
    private String model;
    private String title;
    private String brand;
    private String transmission;
    private String capacity;
    private String mileage;
    private String price;
    private String description;
    private String urlLink;
    private String img1;
    private String img2;
    private String img3;
    private String contactName;
    private String contactNumber;
    private String website;
    private String location;
    private Date createdAt;
    private Date updateAt;
    private String addedBy;
    private String usedType;
    private String fuelType;
    private String modelYear;
}
