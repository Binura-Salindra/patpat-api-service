package com.bolton.patpat.repository;

import com.bolton.patpat.entity.VehicleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static com.bolton.patpat.constant.NativeQueries.FILTER_VEHICLE_COUNT_QUERY;
import static com.bolton.patpat.constant.NativeQueries.FILTER_VEHICLE_QUERY;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer> {

    /**
     * Filter vehicle details
     *
     * @return Array List of Vehicles
     */
    @Query(value = FILTER_VEHICLE_QUERY, nativeQuery = true)
    List<VehicleEntity> filterVehicle(String model, String title, String brand, String description,
                                      String location, String usedType, String fuelType, String website, String year);


    /**
     * Filter vehicle details with pagination
     *
     * @return Pagination object and Array List of Vehicles
     */
    @Query(value = FILTER_VEHICLE_QUERY, countQuery = FILTER_VEHICLE_COUNT_QUERY, nativeQuery = true)
    Page<VehicleEntity> filterVehicleWithPagination(String model, String title, String brand, String description,
                                                    String location, String usedType, String fuelType, String year,
                                                    String website, Pageable page);
}
