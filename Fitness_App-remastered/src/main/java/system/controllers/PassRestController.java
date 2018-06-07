package system.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.dto.PassDTO;
import system.entities.Pass;
import system.service.PassService;

import java.util.List;

@RestController
public class PassRestController {
    private PassService passService;

    @Autowired
    public void setPassService(PassService passService) {
        this.passService = passService;
    }

    @RequestMapping(value = "/createPass", method = RequestMethod.POST)
    public void createPass(@RequestBody PassDTO passDTO) {
        passService.createPass(passDTO);
    }

    @RequestMapping(value = "/getAllPasses", method = RequestMethod.GET)
    public List<Pass> getPasses(){
        return passService.getAllPasses();
    }



}
