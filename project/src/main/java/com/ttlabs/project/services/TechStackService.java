package com.ttlabs.project.services;

import com.ttlabs.project.models.Response;
import com.ttlabs.project.models.TechStack;

import java.util.List;

public interface TechStackService {
    Response addATechStack(TechStack techStack,String email);
    Response addListOfTechStack(List<TechStack> techStacks,String email);

    Response getAllTechStacks();
//    Response getATechStackByEmail(String email);
    Response updateTechStack(TechStack techStack);
    Response deleteTechStack(Long techStackId);
    Response findTechStackByName(String techStackName);
    Response findTechStackById(Long id);
}
