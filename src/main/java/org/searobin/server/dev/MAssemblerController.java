package org.searobin.server.dev;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.StringTemplate.STR;

@RestController
@RequestMapping("/dev")
public class MAssemblerController {

    @GetMapping("genAssemble/{className}")
    public String generateModelAssembler(@PathVariable String className){

        String template = STR."""
                package org.searobin.server.\{className.toLowerCase()};
                               
                import org.springframework.hateoas.EntityModel;
                import org.springframework.hateoas.server.RepresentationModelAssembler;
                import org.springframework.stereotype.Component;
                               
                import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
                import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
                               
                @Component
                public class <\{className}>ModelAssembler implements RepresentationModelAssembler<\{className}, EntityModel<\{className}>> {
                    @Override
                    public EntityModel<\{className}> toModel(\{className} \{className.toLowerCase()}) {
                        return EntityModel.of(\{className.toLowerCase()},
                                linkTo(methodOn(\{className}Controller.\{className}).TODO.withSelfRel(),
                                linkTo(methodOn(\{className}Controller.\{className}).TODO.withRel("all\{className}"));
                    }
                }
                """;
        return template;
    }
}
