package com.fernandoschimidt.car.dto;

public record CarRequest(
        String name,
        Integer year,
        String color
) {
}
