package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.access.annotation.Secured;
import system.entities.User;
import system.entities.Workout;
import system.entities.WorkoutType;
import system.repository.WorkoutRepository;
import system.repository.WorkoutTypeRepository;
import system.repository.UserRepository;
import system.dto.WorkoutDTO;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutTypeRepository workoutTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    @Secured("ROLE_MANAGER")
    public void createWorkout(WorkoutDTO workoutDTO){
        User trainer = userRepository.findOne(workoutDTO.getTrainer_id());
        WorkoutType workoutType = workoutTypeRepository.findOne(workoutDTO.getType_id());
        if((trainer.getRole() == "ROLE_TRAINER") && (trainer != null) && (workoutType!=null)){
            Workout workout = new Workout();
            workout.setDescription(workoutDTO.getDescription());
            workout.setRemain(workoutDTO.getRemain());
            workout.setName(workoutDTO.getName());
            workout.setTrainer(trainer);
            workout.setType(workoutType);
            workout.setPrice(workoutDTO.getPrice());
            workoutRepository.save(workout);
        }
    }

    public List<Workout> getAllWorkouts(){  //check
        return workoutRepository.findAll();
    }

    public int getWorkoutId(Workout workout){
        return workout.getId();
    }
}
