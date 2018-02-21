package pl.maciejpajak.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.maciejpajak.dto.ActivityDto;
import pl.maciejpajak.entity.Activity;
import pl.maciejpajak.repository.ActivityRepository;

@Service
public class ActivityService {
    
    @Autowired
    private ActivityRepository activityRepo;
    
    public List<ActivityDto> getRecentActivity() {
        List<Activity> activity = activityRepo.findAll();
        return activity.stream().map(new ConvertActivityToDto()).collect(Collectors.toList());
    }
    
    private class ConvertActivityToDto implements Function<Activity, ActivityDto> {

        @Override
        public ActivityDto apply(Activity a) {
            a.getObjectClass();

            return new ActivityDto(a.getCreated(),
                    a.getUser().getId(),
                    a.getUser().getEmail(), 
                    a.getObjectId(), "TODO NAME", a.getAction());
        }

    };
    
}
