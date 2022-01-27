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
    public Response saveTechStack(@PathVariable String email, @RequestBody TechStack techStack){
        return techStackService.addATechStack(techStack,email);
    }

    @GetMapping()
    public Response getAll() {
        return new Response(true, "Hello World");
    }

    @PostMapping(name = "save-list-of-tech-stack/list/{email}")
    public Response saveListOfTechStack(@PathVariable String email, @RequestBody List<TechStack> techStackList){
        return techStackService.addListOfTechStack(techStackList,email);
    }
}
