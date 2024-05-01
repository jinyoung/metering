package metering.infra;

import metering.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class CoefficientHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Coefficient>> {

    @Override
    public EntityModel<Coefficient> process(EntityModel<Coefficient> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/calculate")
                .withRel("calculate")
        );

        return model;
    }
}
