package com.example.backend_defects_3d_up.domain.dto.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "defects")
@Data
public class Defect {
    @Id
    Integer id;
    String name;
    String description;
    String reasons;
    String solutions;
    String picture;
}
