package com.ltp.gradesubmission.controller;

import javax.validation.Valid;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.service.GradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {
    GradeService gradeService = new GradeService();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        int index = gradeService.getGradeIndex(id);
        model.addAttribute("grade", gradeService.getGradeById(index));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form";

        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }
}