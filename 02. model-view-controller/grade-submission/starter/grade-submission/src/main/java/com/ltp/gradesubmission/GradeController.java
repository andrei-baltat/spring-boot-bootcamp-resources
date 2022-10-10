package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GradeController {

    @GetMapping("/hello")
    public String getRequest(Model model){

        Grade grade = new Grade("Harry","Potions","10");
        model.addAttribute("grade", grade);
        return "grades";

    }
}
