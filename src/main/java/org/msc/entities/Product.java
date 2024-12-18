package org.msc.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

import static java.time.ZoneId.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
    private String type = "unknown";

    public enum Season {
        WINTER, SPRING, SUMMER, AUTUMN
    }

    @Enumerated(EnumType.STRING)
    private Season season;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "farmerId", nullable = false)
    private Farmer farmer;

    public Product(String name, String type, Season season, Date createdAt, Farmer farmer) {
        this.name = name;
        this.type = (type == null || type.isEmpty()) ? "unknown" : type;
        this.season = season;
        this.createdAt = createdAt;
        this.farmer = farmer;
    }

    @PrePersist
    public void onCreate(){
        LocalDateTime now = LocalDateTime.now(of("Europe/Valencia"));
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        createdAt = Date.from(instant);

        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        season = getSeason(month, dayOfMonth);
    }

    private Season getSeason(Month month, int dayOfMonth) {
        switch (month) {
            case DECEMBER, JANUARY, FEBRUARY:
                return season.WINTER;
            case MARCH:
                return dayOfMonth >= 20 ? season.SPRING : season.WINTER;
            case APRIL, MAY:
                return season.SPRING;
            case JUNE:
                return dayOfMonth < 21 ? season.SPRING : season.SUMMER;
            case JULY, AUGUST:
                return season.SUMMER;
            case SEPTEMBER:
                return dayOfMonth < 23 ? season.SUMMER : season.AUTUMN;
            case OCTOBER, NOVEMBER:
                return season.AUTUMN;
            default:
                return season.WINTER;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
}
