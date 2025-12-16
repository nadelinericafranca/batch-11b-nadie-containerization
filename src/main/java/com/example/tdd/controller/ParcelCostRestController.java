package com.example.tdd.controller;

import com.example.tdd.service.ParcelCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ParcelCostRestController {
    @Autowired
    private ParcelCostService parcelCostService;

    @GetMapping("/parcel-cost-api/v1")
    public ResponseEntity<Object> getParcelCost(@RequestParam (required = false) String l, @RequestParam (required = false) String w, @RequestParam (required = false) String h) {
        double parsedL, parsedW, parsedH;

        // Check validity of Length parameter
        if (l == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Length is missing"));
        } else {
            try {
                parsedL = Double.parseDouble(l);
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid value for Length"));
            }
        }

        // Check validity of Width parameter
        if (w == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Width is missing"));
        } else {
            try {
                parsedW = Double.parseDouble(w);
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid value for Width"));
            }
        }

        // Check validity of Height parameter
        if (h == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Height is missing"));
        } else {
            try {
                parsedH = Double.parseDouble(h);
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(Map.of("error", "Invalid value for Height"));
            }
        }

        // Valid parameters
        double cost = parcelCostService.computeCost(parsedL, parsedW, parsedH);
        return ResponseEntity.ok("{\"cost\": " + cost + "}");
    }
}
