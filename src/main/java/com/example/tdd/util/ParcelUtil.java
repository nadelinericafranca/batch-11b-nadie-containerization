package com.example.tdd.util;

public class ParcelUtil {
    public static double computeVolume(double length, double width, double height) {
        return length * width * height;
    }

    public static double getMultiplier(double volume) {
        // Small Parcel
        if (volume < 1500) {
            return 0.03;
        }
        // Medium Parcel
        if (volume < 2500) {
            return 0.04;
        }
        // Large Parcel
        return 0.05;
    }
}
