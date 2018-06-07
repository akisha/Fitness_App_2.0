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
    public void createWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts(){  //check
        return workoutRepository.findAll();
    }

    public int getWorkoutId(Workout workout){
        return workout.getId();
    }
}
