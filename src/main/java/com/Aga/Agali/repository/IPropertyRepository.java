package com.Aga.Agali.repository;

import com.Aga.Agali.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropertyRepository extends JpaRepository<Property,Long> {
}
