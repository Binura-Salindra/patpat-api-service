package com.bolton.patpat.dto.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleFilterRequestDTO {

    private String model;
    private String title;
    private String brand;
    private String description;
    private String location;
    private String usedType;
    private String fuelType;
    private String year;
    private int page;
    private int size;


}
