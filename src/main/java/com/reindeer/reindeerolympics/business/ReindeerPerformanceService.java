package com.reindeer.reindeerolympics.business;

import com.reindeer.reindeerolympics.models.ReindeerModel;
import org.springframework.stereotype.Service;

/**
 * Service class providing needed methods to compute the performance of Reindeer
 */
@Service
public class ReindeerPerformanceService {

    public Integer getDistanceTraveled(ReindeerModel reindeerModel, Integer duration){

        Integer flightDistance = 0;
        
        int converedDuration = duration / (reindeerModel.getRestDuration() + reindeerModel.getFlightDuration());

        flightDistance += converedDuration * reindeerModel.getSpeed() * reindeerModel.getFlightDuration();

        int leftDuration = duration % (reindeerModel.getRestDuration() + reindeerModel.getFlightDuration());

        if (leftDuration < reindeerModel.getFlightDuration()) {
            flightDistance += reindeerModel.getSpeed() * leftDuration;
        } else {
            flightDistance += reindeerModel.getSpeed() * reindeerModel.getFlightDuration();
        }
        return flightDistance;
    }
}
