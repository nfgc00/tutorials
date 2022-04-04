package com.nfgc.property.domain;

import com.nfgc.property.dto.PropertyDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROPERTIES")
public class Property {

    @Id
    @SequenceGenerator(name = "seq_properties", sequenceName = "SEQ_PROPERTIES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_properties")
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    private BigDecimal price;
    private String address;

    public Property(PropertyDto dto) {
        this.title = dto.getTitle();
        this.description = dto.getDescription();
//        this.ownerName = dto.getOwnerName();
//        this.ownerEmail = dto.getOwnerEmail();
        this.price = dto.getPrice();
        this.address = dto.getAddress();
    }
}
