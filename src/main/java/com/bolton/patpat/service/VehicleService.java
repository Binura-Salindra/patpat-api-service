package com.bolton.patpat.service;

import com.bolton.patpat.dto.VehicleDTO;
import com.bolton.patpat.dto.json.VehicleFilterRequestDTO;

import java.util.List;
import org.springframework.data.domain.Page;

public interface VehicleService {

    List<VehicleDTO> filterVehicleDetails(VehicleFilterRequestDTO requestDTO);

    Page<VehicleDTO> filterVehicleDetailsWithPagination(VehicleFilterRequestDTO requestDTO);
}
