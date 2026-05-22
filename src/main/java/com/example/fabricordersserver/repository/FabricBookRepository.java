package com.example.fabricordersserver.repository;

import com.example.fabricordersserver.entity.FabricBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FabricBookRepository extends JpaRepository<FabricBook, Long> {

    List<FabricBook> findByManufacturerContainingIgnoreCase(String manufacturer);

    List<FabricBook> findByBookNameContainingIgnoreCase(String bookName);

    List<FabricBook> findByBookCodeContainingIgnoreCase(String bookCode);

}
