package org.msc.dtos;

import org.msc.entities.Product;

import java.util.Date;

public record ProductResponse(Long id, String name, String type, Product.Season season, Date createdAt) {
}
