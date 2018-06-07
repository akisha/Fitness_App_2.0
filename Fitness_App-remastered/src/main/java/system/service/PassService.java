package system.service;

import org.springframework.security.access.annotation.Secured;
import system.dto.PassDTO;
import system.dto.WorkoutDTO;
import system.entities.User;
import system.entities.Pass;
import system.entities.WorkoutType;
import system.repository.PassRepository;
import system.repository.WorkoutTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;

@Service
public class PassService {

    @Autowired
    private WorkoutTypeRepository workoutTypeRepository;

    @Autowired
    private PassRepository passRepository;

    @Secured("ROLE_MANAGER")
    public void createPass(PassDTO passDTO){
        WorkoutType passType = workoutTypeRepository.findOne(passDTO.getType_id());
        Pass pass = new Pass();
        pass.setName(passDTO.getName());
        pass.setPrice(passDTO.getPrice());
        pass.setDescription(passDTO.getDescription());
        pass.setRemain(passDTO.getRemain());
        pass.setType(passType);
        passRepository.save(pass);
    }

    public List<Pass> getAllPasses(){  //check
        return passRepository.findAll();
    }

    public int getPassId(Pass pass){
        return pass.getId();
    }

}
