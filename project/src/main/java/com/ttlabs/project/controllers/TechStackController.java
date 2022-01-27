package com.ttlabs.project.controllers;

import com.ttlabs.project.models.Response;
import com.ttlabs.project.models.TechStack;
import com.ttlabs.project.services.TechStackService;
import com.ttlabs.project.services.TechStackServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/tech-stack")
public class TechStackController {
    @Autowired
    TechStackService techStackService;

//    public TechStackController(TechStackServiceImpl techStackService) {
//        this.techStackService = techStackService;
//    }

    @PostMapping(path = "/save-tech-stack/{email}")
    public void saveTechStack(@PathVariable String email, @RequestBody TechStack techStack){
         techStackService.addATechStack(techStack,email);
    }

    @GetMapping()
    public List<TechStack> getAll() {
        return techStackService.getAllTechStacks();
    }

    @PostMapping(path = "/save-list-of-tech-stack/list/{email}")
    public void saveListOfTechStack(@PathVariable String email, @RequestBody List<TechStack> techStackList){
        techStackService.addListOfTechStack(techStackList,email);
    }
}
