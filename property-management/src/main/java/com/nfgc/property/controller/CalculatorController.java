package com.nfgc.property.controller;

import com.nfgc.property.dto.CalculatorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(@RequestParam("n1") Double n1, @RequestParam("n2") Double n2) {
        return n1 + n2;
    }

    @GetMapping("/substract/{n1}/{n2}")
    public Double substract(@PathVariable("n1") Double n1, @PathVariable("n2") Double n2) {
        return n1 > n2 ? n1 - n2 : n2 - n1;
    }

    @PostMapping("/multiply")
    public Double multiply(@RequestBody CalculatorDto dto) {
        return dto.getNum1() * dto.getNum2() * dto.getNum3() * dto.getNum4();
    }
}
