package com.ttlabs.project.services;

import com.ttlabs.project.models.Response;
import com.ttlabs.project.models.TechStack;
import com.ttlabs.project.repositories.TechStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechStackServiceImpl implements TechStackService{
    TechStackRepository techStackRepository;

    @Autowired
    public TechStackServiceImpl(TechStackRepository techStackRepository) {
        this.techStackRepository = techStackRepository;
    }

    @Override
    public Response addATechStack(TechStack techStack) {
        TechStack res =  techStackRepository.save(techStack);
        return new Response(true,res);
    }

    @Override
    public Response addListOfTechStack(List<TechStack> techStacks) {
        List<TechStack> res = techStackRepository.saveAll(techStacks);

        return new Response(true,res);
    }

    @Override
    public Response getAllTechStacks() {
        List<TechStack> techStacks = techStackRepository.findAll();
        return new Response(true,techStacks);
    }

    @Override
    public Response findTechStackById(Long id) {
        boolean exists = techStackRepository.existsById(id);
        if (!exists){
            return new Response(false,"Tech Stack with id: "+id +"does not exist");
        }
        Optional<TechStack> res = techStackRepository.findById(id);
        return new Response(true,res);
    }

    @Override
    public Response updateTechStack(TechStack techStack) {
        return null;
    }

    @Override
    public Response deleteTechStack(Long techStackId) {
        boolean exists = techStackRepository.existsById(techStackId);
        if (!exists){
            return  new Response(false,"Tech Stack with id: "+techStackId +"does not exist");
        }
         techStackRepository.deleteById(techStackId);
        return new Response(true,"Tech stack with id: "+techStackId+"deleted successfully");
    }

    @Override
    public Response findTechStackByName(String techStackName) {
        List<TechStack> res = techStackRepository.findByTechStackName(techStackName);
        return new Response(true,res);
    }
}
