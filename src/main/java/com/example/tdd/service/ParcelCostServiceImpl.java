package com.example.tdd.service;

import com.example.tdd.util.ParcelUtil;
import org.springframework.stereotype.Service;

@Service
public class ParcelCostServiceImpl implements ParcelCostService {
    @Override
    public double computeCost(double length, double width, double height) throws RuntimeException {
        // Validate parameters
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }

        double volume = ParcelUtil.computeVolume(length, width, height);
        double multiplier = ParcelUtil.getMultiplier(volume);

        return multiplier * volume;
    }
}
