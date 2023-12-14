package org.searobin.server.fish;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// Could also be known as FishLinkAssembler or FishHATEOASAssembler
@Component
public class FishModelAssembler implements RepresentationModelAssembler<Fish, EntityModel<Fish>> {
    @Override
    public EntityModel<Fish> toModel(Fish fish) {
        return EntityModel.of(fish, linkTo(methodOn(FishController.class).getFishByName(fish.getId())).withSelfRel(), linkTo(methodOn(FishController.class).getAllFish()).withRel("allFish"));
    }
}
