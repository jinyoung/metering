package metering.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import metering.MeteringApplication;

@Entity
@Table(name = "Coefficient_table")
@Data
//<<< DDD / Aggregate Root
public class Coefficient {

    @Id
    private String topicId;

    @ElementCollection
    private List<Value> values;

    @PostPersist
    public void onPostPersist() {}

    public static CoefficientRepository repository() {
        CoefficientRepository coefficientRepository = MeteringApplication.applicationContext.getBean(
            CoefficientRepository.class
        );
        return coefficientRepository;
    }

    //<<< Clean Arch / Port Method
    public void calculate() {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
