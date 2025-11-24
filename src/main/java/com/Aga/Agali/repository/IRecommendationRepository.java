package com.Aga.Agali.repository;

import com.Aga.Agali.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation,Long> {
    List<Recommendation> findByUserId(Long userId);

    List<Recommendation> findByPropertyId(Long propertyId);
}
