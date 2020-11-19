package com.reindeer.reindeerolympics.utils;

import com.reindeer.reindeerolympics.models.ReindeerModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible to read the input files and parse it into multiple objects
 */
@Getter
@Setter
@Component
public class FileParser {

    private List<ReindeerModel> list = new ArrayList<>() ;

    private static final String FILE_PATH = "/reindeer-olympics.txt";
    private static final Integer DEER_NAME_INDEX = 0;
    private static final Integer DEER_SPEED_INDEX = 3;
    private static final Integer DEER_FLIGHTDURATION_INDEX = 6;
    private static final Integer DEER_RESTDURATION_INDEX = 13;

    /**
     * read data from FILE_PATH and parse it into a list of Reindeer
     * @return list of Reindeer
     */
    public  List<ReindeerModel> getReindeerListFromFile(){
        List<ReindeerModel> list = new ArrayList<>() ;

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                FileParser.class.getResourceAsStream(FILE_PATH)));

        reader.lines().forEach(line -> {

            String[] split = line.split(" ");

            String name = split[DEER_NAME_INDEX];

            Integer speed = Integer.valueOf(split[DEER_SPEED_INDEX]);

            Integer flightDuration = Integer.valueOf(split[DEER_FLIGHTDURATION_INDEX]);

            Integer restDuration = Integer.valueOf(split[DEER_RESTDURATION_INDEX]);

            list.add(new ReindeerModel(name,speed, flightDuration, restDuration ));
        });

        return list;
    }
}
