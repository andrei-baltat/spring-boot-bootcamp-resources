package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
    
    @GetMapping("/")
    public String getShows(Model model) {
        model.addAttribute("movie1",new Movie("Breaking Bad","Ozymandias","10.0"));
        model.addAttribute("movie2",new Movie("Attack on Titan","Hero","9.9"));
        model.addAttribute("movie3",new Movie("Attack on Titan","Perfect Game","9.9"));
        model.addAttribute("movie4",new Movie("Star Wars: The Clone Wars","Victory and Death","9.9"));
        model.addAttribute("movie5",new Movie("Mr. Robot","407 Proxy Authentication Required","9.9"));
        return "shows";
    }

}
