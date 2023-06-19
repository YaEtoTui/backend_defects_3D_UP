package com.example.backend_defects_3d_up.adapter.web.controller;

import com.example.backend_defects_3d_up.domain.dto.response.DefectResponse;
import com.example.backend_defects_3d_up.service.impl.DefectServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class DefectController {

    DefectServiceImpl defectService;

    @GetMapping(value = "/defects")
    public ResponseEntity<List<DefectResponse>> read() {
        List<DefectResponse> defects = defectService.readAll();
        return  new ResponseEntity<>(defects, HttpStatus.OK);
    }
    @GetMapping(value = "/defects/{id}")
    public ResponseEntity<DefectResponse> read(@PathVariable(name = "id") int id) {
        DefectResponse defect = defectService.read(id);
        return new ResponseEntity<>(defect, HttpStatus.OK);
    }
}
