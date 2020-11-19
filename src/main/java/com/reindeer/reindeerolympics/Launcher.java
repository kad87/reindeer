package com.reindeer.reindeerolympics;

import com.reindeer.reindeerolympics.business.ReindeerPerformanceService;
import com.reindeer.reindeerolympics.models.ReindeerModel;
import com.reindeer.reindeerolympics.utils.FileParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * The class responsible to execute the compute process
 */
@Component
public class Launcher {

    @Autowired
    FileParser fileParser;

    @Autowired
    ReindeerPerformanceService reindeerPerformanceService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void launch(Integer duration){
        HashMap<ReindeerModel, Integer> computedReindeerList = new HashMap<>();
        HashMap<ReindeerModel, Integer> sorted = new HashMap<>();

        List<ReindeerModel> reindeerList = fileParser.getReindeerListFromFile();
        reindeerList.forEach( r -> {
            computedReindeerList.put(r, reindeerPerformanceService.getDistanceTraveled(r, duration));
        });

        AtomicInteger i = new AtomicInteger(1);
        Map<ReindeerModel, Integer> result = computedReindeerList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                //.reversed()).forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));


        result.entrySet().stream().forEach(e-> log.info(e.getKey().getName()
                +" is ranked "+ i.getAndIncrement() + " with a travellled distance of : "+ e.getValue()));
    }
}
