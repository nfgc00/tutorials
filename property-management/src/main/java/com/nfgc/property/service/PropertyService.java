package com.nfgc.property.service;

import com.nfgc.property.domain.Property;
import com.nfgc.property.dto.PropertyDto;
import com.nfgc.property.exception.ResourceNotFoundException;
import com.nfgc.property.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PropertyService implements IPropertyService {

    private PropertyRepository propertyRepository;

    @Override
    public PropertyDto addProperty(PropertyDto propertyDto) {
        Property property = new Property(propertyDto);
        propertyRepository.save(property);
        propertyDto.setId(property.getId());
        return propertyDto;
    }

    @Override
    public List<PropertyDto> getAll() {
        return propertyRepository.findAll().stream().map(p -> new PropertyDto(p)).collect(Collectors.toList());
    }

    @Override
    public PropertyDto getById(Integer id) {
        return new PropertyDto(propertyRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property", "Id", id)));
    }

    @Override
    public PropertyDto update(Integer id, PropertyDto propertyDto) {
        PropertyDto dto = getById(id);
        Property property = new Property(propertyDto);
        property.setId(id);
        propertyRepository.save(property);
        propertyDto.setId(id);
        return propertyDto;
    }

    @Override
    public void delete(Integer id) {
        PropertyDto dto = getById(id);
        propertyRepository.deleteById(id);
    }
}
