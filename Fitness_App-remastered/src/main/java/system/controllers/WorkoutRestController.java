package system.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import system.entities.Workout;
import system.service.WorkoutService;

import java.util.List;
@RestController
public class WorkoutRestController {
    private WorkoutService workoutService;

    @Autowired
    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @RequestMapping(value = "/createWorkout", method = RequestMethod.POST)
    public void createWorkout(@RequestBody Workout workout) {
        workoutService.createWorkout(workout);
    }

    @RequestMapping(value = "/getAllWorkouts", method = RequestMethod.GET)
    public List<Workout> getWorkouts(){
        return workoutService.getAllWorkouts();
    }
}
