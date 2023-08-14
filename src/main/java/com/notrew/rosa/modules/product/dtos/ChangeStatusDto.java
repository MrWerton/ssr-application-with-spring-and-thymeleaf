package com.notrew.rosa.modules.product.dtos;

import com.notrew.rosa.modules.product.constants.Status;

public record ChangeStatusDto(String id, String status) {
    public Status getStatus() {
        System.out.println(status);
        System.out.println(status.toLowerCase());

        return switch (status.toLowerCase()) {
            case "unavailable" -> Status.UNAVAILABLE;
            case "available" -> Status.AVAILABLE;
            default -> throw new IllegalArgumentException("Invalid status: " + status
            );
        };
    }
}
