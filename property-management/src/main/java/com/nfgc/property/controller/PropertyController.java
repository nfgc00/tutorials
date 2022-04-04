package com.nfgc.property.controller;

import com.nfgc.property.dto.PropertyDto;
import com.nfgc.property.service.IPropertyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    private IPropertyService propertyService;

    @Value("${pms.dummy:}")
    private String dummy;

    public PropertyController(IPropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<PropertyDto> addProperty(@RequestBody PropertyDto propertyDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(propertyService.addProperty(propertyDto));
    }

    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAll() {
        log.info("Property Val: {}", dummy);
        return ResponseEntity.ok(propertyService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<PropertyDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(propertyService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<PropertyDto> update(@PathVariable Integer id, @RequestBody PropertyDto propertyDto) {
        return ResponseEntity.ok(propertyService.update(id, propertyDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        propertyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello...");
    }
}
