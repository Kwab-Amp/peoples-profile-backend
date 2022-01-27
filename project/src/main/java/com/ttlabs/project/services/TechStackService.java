package com.ttlabs.project.services;

import com.ttlabs.project.models.Response;
import com.ttlabs.project.models.TechStack;

import java.util.List;

public interface TechStackService {
    void addATechStack(TechStack techStack,String email);
    void addListOfTechStack(List<TechStack> techStacks,String email);

    List<TechStack> getAllTechStacks();
//    Response getATechStackByEmail(String email);
    Response updateTechStack(TechStack techStack);
    Response deleteTechStack(Long techStackId);
    Response findTechStackByName(String techStackName);
    Response findTechStackById(Long id);
}
