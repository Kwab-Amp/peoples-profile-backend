package com.ttlabs.project.controllers;

import com.ttlabs.project.models.Response;
import com.ttlabs.project.models.TechStack;
import com.ttlabs.project.services.TechStackService;
import com.ttlabs.project.services.TechStackServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechStackController {
    private final TechStackServiceImpl techStackService;

    public TechStackController(TechStackServiceImpl techStackService) {
        this.techStackService = techStackService;
    }

    @RequestMapping(name = "save-tech-stack/{email}",method = RequestMethod.POST)
    public Response saveTechStack(@PathVariable String email, @RequestBody TechStack techStack){
        return techStackService.addATechStack(techStack,email);
    }

    @RequestMapping(name = "save-list-of-tech-stack/{email}",method = RequestMethod.POST)
    public Response saveListOfTechStack(@PathVariable String email, @RequestBody List<TechStack> techStackList){
        return techStackService.addListOfTechStack(techStackList,email);
    }
}
