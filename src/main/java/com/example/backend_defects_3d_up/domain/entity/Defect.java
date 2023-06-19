package com.example.backend_defects_3d_up.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "defects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Defect {
    @Id
    Integer id;
    String name;
    String description;
    String reasons;
    String solutions;
    String picture;
}
