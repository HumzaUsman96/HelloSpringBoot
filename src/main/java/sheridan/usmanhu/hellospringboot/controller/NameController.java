package sheridan.usmanhu.hellospringboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.usmanhu.hellospringboot.domain.User;


@Controller
public class NameController {
private final Logger logger = LoggerFactory.getLogger(NameController.class);
    @GetMapping("/Input")
    public String input(@ModelAttribute User user, Model model){
        model.addAttribute(user);

        logger.trace("input() is called");


        return "Input";
    }

    @GetMapping("/Output")
    public String output(@Validated @ModelAttribute User user, BindingResult bindingResult, Model model){
        logger.trace("output() is called");
        logger.debug(user.toString());
        if (bindingResult.hasErrors()){
            logger.trace("Errors in the user Input");
            return "Input";
        }else{
            model.addAttribute("user",user);
            logger.trace("Input is alright");
            return "Output";
        }

    }
}
