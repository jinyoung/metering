package metering.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    transient // 이 값은 메모리상에 올라왔을때만 사용합니다.
    private Map<String, Double> valuMap;

    @PostPersist
    public void onPostPersist() {}

    public static CoefficientRepository repository() {
        CoefficientRepository coefficientRepository = MeteringApplication.applicationContext.getBean(
            CoefficientRepository.class
        );
        return coefficientRepository;
    }

    //<<< Clean Arch / Port Method
    public String calculate() {
        //로직이 topic에 따라 달라질 수 있는 것은 Strategy Pattern이나 기타 계산식 처리를 휘한 프레임워크를 사용한다고 가정합니다. 
        //여기서는 계수 Aggregate의 설계를 평가하기 위한 임의의 예제로 설정하였을뿐입니다. 
        this.valuMap = getCurrentlyActivatedValues();
        
        Double 계수1 = this.valuMap.get("계수1");
        Double 계수2 = this.valuMap.get("계수2");

        return "계산결과="+ 계수1 + "*X + "+계수2+"*Y";

    }

    protected Map<String, Double> getCurrentlyActivatedValues(){
        HashMap<String, Double> map = new HashMap<>();
        HashMap<String, Date> activateDateByKey = new HashMap<>();
        Date today = new Date();

        for(Value value: this.values){
            Date currentBest = activateDateByKey.get(value.getKey());

            if(value.getActivateFrom().before(today) && (currentBest==null || value.getActivateFrom().after(currentBest))){
                map.put(value.getKey(), Double.valueOf(value.getValue()));
                activateDateByKey.put(value.getKey(), value.getActivateFrom());
            }
                
        }

        return map;

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
