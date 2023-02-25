package com.bolton.patpat.controller;

import com.bolton.patpat.dto.json.CommonResponse;
import com.bolton.patpat.dto.json.VehicleFilterRequestDTO;
import com.bolton.patpat.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bolton.patpat.constant.ResponseCodes.OPERATION_SUCCESS;
import static com.bolton.patpat.constant.ResponseCodes.SUCCESS_RESPONSE;

@RestController
@CrossOrigin
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommonResponse> filterVehicleDetails(@RequestParam(value = "model", required = false) String model,
                                                               @RequestParam(value = "title", required = false) String title,
                                                               @RequestParam(value = "brand", required = false) String brand,
                                                               @RequestParam(value = "description", required = false) String description,
                                                               @RequestParam(value = "location", required = false) String location,
                                                               @RequestParam(value = "usedType", required = false) String usedType,
                                                               @RequestParam(value = "fuelType", required = false) String fuelType,
                                                               @RequestParam(value = "year", required = false) String year,
                                                               @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                                               @RequestParam(value = "size", required = false, defaultValue = "0") int size) {


        VehicleFilterRequestDTO requestDTO = new VehicleFilterRequestDTO(model, title, brand, description, location, usedType,
                fuelType, year, page, size);

        //1--> filter without pagination
        //2--> filter with pagination
        return (page == 0 && size == 0) ?
                new ResponseEntity<>(new CommonResponse(OPERATION_SUCCESS, vehicleService.filterVehicleDetails(requestDTO)
                        , SUCCESS_RESPONSE), HttpStatus.OK)

                : new ResponseEntity<>(new CommonResponse(OPERATION_SUCCESS, vehicleService.filterVehicleDetailsWithPagination(requestDTO)
                , SUCCESS_RESPONSE), HttpStatus.OK);
    }
}
