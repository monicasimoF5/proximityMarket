package org.msc.dtos;

public record FarmerResponse(
        Long id,
        String name,
        String phone,
        String email,
        String address
) {
}
