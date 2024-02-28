package org.searobin.server.angler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AnglerModelAssembler implements RepresentationModelAssembler<Angler, EntityModel<Angler>> {
    @Override
    public EntityModel<Angler> toModel(Angler angler) {
        return EntityModel.of(angler,
                linkTo(methodOn(AnglerController.class).getAnglerById(angler.getId())).withSelfRel(),
                linkTo(methodOn(AnglerController.class).getAllAnglers()).withRel("allAnglers"));
    }
}
