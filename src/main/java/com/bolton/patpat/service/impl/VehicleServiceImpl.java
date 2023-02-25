package com.bolton.patpat.service.impl;

import com.bolton.patpat.dto.VehicleDTO;
import com.bolton.patpat.dto.json.VehicleFilterRequestDTO;
import com.bolton.patpat.entity.VehicleEntity;
import com.bolton.patpat.repository.VehicleRepository;
import com.bolton.patpat.service.VehicleService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.bolton.patpat.constant.ResponseCodes.WEBSITE;

@Log4j2
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, ModelMapper modelMapper) {
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VehicleDTO> filterVehicleDetails(VehicleFilterRequestDTO requestDTO) {
        try {

            List<VehicleEntity> filterVehicleList = vehicleRepository.filterVehicle(requestDTO.getModel(), requestDTO.getTitle(), requestDTO.getBrand(),
                    requestDTO.getDescription(), requestDTO.getLocation(), requestDTO.getUsedType(), requestDTO.getFuelType(),
                    requestDTO.getYear(), WEBSITE);

           if(filterVehicleList == null || filterVehicleList.isEmpty())
               return new ArrayList<>();

            return filterVehicleList.stream().map(this::mapEntityToDTO).collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Method filterVehicleDetails : " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<VehicleDTO> filterVehicleDetailsWithPagination(VehicleFilterRequestDTO requestDTO) {
        try {

            Pageable pageable = PageRequest.of(requestDTO.getPage(), requestDTO.getSize());

            Page<VehicleEntity> filterVehicleWithPagination = vehicleRepository.filterVehicleWithPagination(requestDTO.getModel(), requestDTO.getTitle(), requestDTO.getBrand(),
                    requestDTO.getDescription(), requestDTO.getLocation(), requestDTO.getUsedType(), requestDTO.getFuelType(),
                    requestDTO.getYear(), WEBSITE, pageable);

            return filterVehicleWithPagination.map(this::mapEntityToDTO);

        } catch (Exception e) {
            log.error("Method filterVehicleDetailsWithPagination : " + e.getMessage(), e);
            throw e;
        }
    }

    private VehicleDTO mapEntityToDTO(VehicleEntity vehicleEntity) {
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
}
