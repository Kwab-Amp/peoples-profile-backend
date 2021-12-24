package com.ttlabs.project.repositories;

import com.ttlabs.project.models.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechStackRepository extends JpaRepository<TechStack,Long> {
    List<TechStack> findByTechStackName(String stackName);
}
