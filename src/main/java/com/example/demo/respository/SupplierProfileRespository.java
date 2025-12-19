

package com.example.demo.repository;

import com.example.demo.model.SupplierProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierProfileRepository extends JpaRepository<SupplierProfile, Long> {
    SupplierProfile findBySupplierCode(String supplierCode);
}

