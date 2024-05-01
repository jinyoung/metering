package metering.domain;

import metering.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "coefficients",
    path = "coefficients"
)
public interface CoefficientRepository
    extends PagingAndSortingRepository<Coefficient, String> {}
