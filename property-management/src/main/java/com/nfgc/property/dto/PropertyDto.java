package com.nfgc.property.dto;

import com.nfgc.property.domain.Property;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class PropertyDto {

    private Integer id;
    private String title;
    private String description;
    private String ownerName;
    private String ownerEmail;
    private BigDecimal price;
    private String address;

    public PropertyDto(Property p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.description = p.getDescription();
//        this.ownerName = p.getOwnerName();
//        this.ownerEmail = p.getOwnerEmail();
        this.price = p.getPrice();
        this.address = p.getAddress();
    }
}
