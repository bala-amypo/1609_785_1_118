package com.example.demo.repository;

import com.example.demo.SupplierProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SupplierProfileRepository extends JpaRepository<SupplierProfile, Long> {
    Optional<SupplierProfile> findBySupplierCode(String supplierCode);
}