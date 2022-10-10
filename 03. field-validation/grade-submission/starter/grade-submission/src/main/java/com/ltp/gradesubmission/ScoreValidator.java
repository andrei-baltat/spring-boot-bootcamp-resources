package com.ltp.gradesubmission;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

//adnotarea, si tipul de valoare ce o validezi
public class ScoreValidator implements ConstraintValidator<ValidScore, String> {

    List<String> scores = Arrays.asList(
            "A+","A","A-",
            "B+","B","B-",
            "C+","C","C-",
            "D+","D","D-",
            "F"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return scores.stream().anyMatch(s -> s.equals(value));
    }
}
