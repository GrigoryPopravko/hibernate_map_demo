package by.itacademy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "car")
public class CarEntity {

    @EmbeddedId
    private InternationalCarNumber number;

    @Column(name = "brand", length = 20)
    private String brand;

    @Column(name = "model", length = 20)
    private String model;

    @Column(name = "description")
    private String description;
}
