package com.aysevarlik.springboothomework.mvc;


import com.aysevarlik.springboothomework.database.dto.CvDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
public class FormController {

    //http://localhost:8081/form
    @GetMapping("form")
    public String getCvForm(Model model, String cvDto){
        model.addAttribute("form_key",new CvDto());
        return "form";
    }

    @PostMapping("form")
    public String postCvForm(Model model, CvDto cvDto){
        model.addAttribute("form_key", cvDto);
        log.info(cvDto);
        return "form";
    }


}
