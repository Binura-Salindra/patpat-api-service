package com.bolton.patpat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "vehicle")
public class VehicleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adId;
    @Column
    private String model;
    @Column
    private String title;
    @Column
    private String brand;
    @Column
    private String transmission;
    @Column
    private String capacity;
    @Column
    private String mileage;
    @Column
    private String price;
    @Column(length = 3000)
    private String description;
    @Column(length = 1000)
    private String urlLink;
    @Column(length = 1000)
    private String img1;
    @Column(length = 1000)
    private String img2;
    @Column(length = 1000)
    private String img3;
    @Column
    private String contactName;
    @Column
    private String contactNumber;
    @Column
    private String website;
    @Column
    private String location;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @Column
    private String addedBy;
    @Column
    private String usedType;
    @Column
    private String fuelType;
    @Column
    private String modelYear;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleEntity that = (VehicleEntity) o;
        return adId == that.adId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adId);
    }
}
