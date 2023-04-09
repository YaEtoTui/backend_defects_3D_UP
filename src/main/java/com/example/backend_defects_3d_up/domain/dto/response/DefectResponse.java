package com.example.backend_defects_3d_up.domain.dto.response;

import lombok.Value;

@Value
public class DefectResponse {
    public Integer id;
    public String name;
    public String description;
    public String reasons;
    public String solutions;
    public String picture;
}