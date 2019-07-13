package spittr.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.bean.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("spitter")
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;

    //使用Spring表单，设置了commandName属性之后需要在模型Model中有一个key为spitter的对象
    @RequestMapping(value = "/register", method = GET)
    public String showRegistraionJSP(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "register", method = POST)
    public String processRegistration(@Valid Spitter spitter, Errors error){
        if (error.hasErrors()){
            return "registerForm";
        }

        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
