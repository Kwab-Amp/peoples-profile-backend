package com.ttlabs.project.services;

import com.ttlabs.project.models.Profile;
import com.ttlabs.project.models.Response;
import com.ttlabs.project.models.TechStack;
import com.ttlabs.project.repositories.ProfileRepository;
import com.ttlabs.project.repositories.TechStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TechStackServiceImpl implements TechStackService{
    TechStackRepository techStackRepository;
    ProfileRepository profileRepository;

    @Autowired
    public TechStackServiceImpl(TechStackRepository techStackRepository,ProfileRepository profileRepository) {
        this.techStackRepository = techStackRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public void addATechStack(TechStack techStack,String email) {
        Profile profile = profileRepository.findByEmail(email);
        techStack.setProfile(profile);
        TechStack res =  techStackRepository.save(techStack);
//        return new Response(true,res);
    }

    @Override
    public void addListOfTechStack(List<TechStack> techStacks,String email) {
        Profile profile = profileRepository.findByEmail(email);
        for (TechStack techStack:techStacks) {
            techStack.setProfile(profile);
        }
        List<TechStack> res = techStackRepository.saveAll(techStacks);
//        return new Response(true,res);
    }

    @Override
    public List<TechStack> getAllTechStacks() {
        List<TechStack> techStacks = techStackRepository.findAll();
        return techStacks;
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
        List<TechStack> res = techStackRepository.findByStackName(techStackName);
        return new Response(true,res);
    }
}
