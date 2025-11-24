package com.Aga.Agali.controller.impl;

import com.Aga.Agali.controller.IPropertyController;
import com.Aga.Agali.dto.PropertyCreateDTO;
import com.Aga.Agali.dto.PropertyResponseDTO;
import com.Aga.Agali.services.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rest/api/property")
public class PropertyControllerIMPL implements IPropertyController {
    @Autowired
    private IPropertyService propertyService;

    @Override
    @PostMapping
    public PropertyResponseDTO save(@RequestBody PropertyCreateDTO dto) {
        return propertyService.save(dto);
    }

    @Override
    @GetMapping("/{id}")
    public PropertyResponseDTO getById(@PathVariable(name = "id") Long id) {
        return propertyService.getById(id);
    }

    @Override
    @GetMapping
    public List<PropertyResponseDTO> getAll() {
        return propertyService.getAll();
    }

    @Override
    @PutMapping("/{id}")
    public PropertyResponseDTO update(@PathVariable(name = "id") Long id,@RequestBody PropertyCreateDTO dto) {
        return propertyService.update(id,dto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")Long id) {
        propertyService.delete(id);

    }
}
