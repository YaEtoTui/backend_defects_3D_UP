package com.example.backend_defects_3d_up.adapter.repository;

import com.example.backend_defects_3d_up.domain.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Long> {
}
