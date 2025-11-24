package com.Aga.Agali.repository;

import com.Aga.Agali.entity.UserInteraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserInteractionRepository extends JpaRepository<UserInteraction,Long> {
    List<UserInteraction> findByUserId(Long userId);

    List<UserInteraction> findByPropertyId(Long propertyId);
}
