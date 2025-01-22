package org.searobin.server.angler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/angler")
public class AnglerController {

    private AnglerRepository anglerRepository;
    private AnglerModelAssembler assembler;

    public AnglerController (@Autowired AnglerRepository anglerRepository, @Autowired AnglerModelAssembler assembler){
        this.anglerRepository = anglerRepository;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    public EntityModel<Angler> getAnglerById(@PathVariable UUID id){
       Angler angler = new Angler();
       try {
            angler = anglerRepository.findById(id).orElseThrow(ClassNotFoundException::new);
       } catch (ClassNotFoundException ex) {
           System.out.println("Angler not found: " + ex.getException());
       }
       return assembler.toModel(angler);
    }

    @GetMapping
    public CollectionModel<EntityModel<Angler>> getAllAnglers(){
        // replace with HATEOAS api eventually
        List<Angler> allAnglers = anglerRepository.findAll();
        List<EntityModel<Angler>> anglerList = allAnglers.stream().map(assembler::toModel).toList();
        return CollectionModel.of(anglerList, linkTo(methodOn(AnglerController.class).getAllAnglers()).withSelfRel());
    }

}
