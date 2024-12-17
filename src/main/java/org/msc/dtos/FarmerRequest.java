package org.msc.dtos;

public record FarmerRequest(
    String name,
    String phone,
    String email,
    String address
) {
}
