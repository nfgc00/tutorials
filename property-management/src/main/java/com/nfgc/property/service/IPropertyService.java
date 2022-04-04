package com.nfgc.property.service;

import com.nfgc.property.dto.PropertyDto;

import java.util.List;

public interface IPropertyService {

    PropertyDto addProperty(PropertyDto propertyDto);
    List<PropertyDto> getAll();
    PropertyDto getById(Integer id);
    PropertyDto update(Integer id, PropertyDto propertyDto);
    void delete(Integer id);
}
