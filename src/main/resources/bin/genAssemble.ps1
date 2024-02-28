param([String] $className)

Write-Host @"
package org.searobin.server.$($className.ToLower());

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ${className}ModelAssembler implements RepresentationModelAssembler<${className}, EntityModel<${className}>> {
    @Override
    public EntityModel<${className}> toModel(${className} $($className.ToLower())) {
        return EntityModel.of(($($className.ToLower()),
                linkTo(methodOn(${className}Controller.${className}).TODO.withSelfRel(),
                linkTo(methodOn(${className}Controller.${className}).TODO.withRel("all${className}"));
    }
}
"@