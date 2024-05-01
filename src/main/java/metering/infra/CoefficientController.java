package metering.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import metering.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/coefficients")
@Transactional
public class CoefficientController {

    @Autowired
    CoefficientRepository coefficientRepository;

    @RequestMapping(
        value = "coefficients/{id}/calculate",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public String calculate(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /coefficient/calculate  called #####");
        Optional<Coefficient> optionalCoefficient = coefficientRepository.findById(
            id
        );

        optionalCoefficient.orElseThrow(() -> new Exception("No Entity Found"));
        Coefficient coefficient = optionalCoefficient.get();
        return coefficient.calculate();

    }
}
//>>> Clean Arch / Inbound Adaptor
