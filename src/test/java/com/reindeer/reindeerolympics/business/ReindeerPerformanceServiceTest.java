package com.reindeer.reindeerolympics.business;

import com.reindeer.reindeerolympics.models.ReindeerModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class ReindeerPerformanceServiceTest {

    @InjectMocks
    ReindeerPerformanceService reindeerPerformanceService;

    private final static String NAME1 = "Comet";
    private final static Integer SPEED1 = 14;
    private final static Integer FLIGHT_DURATION1 = 10;
    private final static Integer REST_DURATION1 =127;
    private final static String NAME2 = "Dancer";
    private final static Integer SPEED2 = 16;
    private final static Integer FLIGHT_DURATION2 = 11;
    private final static Integer REST_DURATION2 =162;
    private final static Integer DURATION =1000;
    private final static Integer EXPECTED_DISTANCE1 = 1120;
    private final static Integer EXPECTED_DISTANCE2 = 1056;

    ReindeerModel reindeerModel1;
    ReindeerModel reindeerModel2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        reindeerModel1 = new ReindeerModel(NAME1, SPEED1, FLIGHT_DURATION1, REST_DURATION1);
        reindeerModel2 = new ReindeerModel(NAME2, SPEED2, FLIGHT_DURATION2, REST_DURATION2);
    }

    @Test
    public void getDistanceTraveled() {
        //PREPARATIONS
        Integer result1 = reindeerPerformanceService.getDistanceTraveled(reindeerModel1,DURATION );
        Integer result2 = reindeerPerformanceService.getDistanceTraveled(reindeerModel2,DURATION );

        //ASSERTIONS
        Assert.assertEquals(EXPECTED_DISTANCE1, result1);
        Assert.assertEquals(EXPECTED_DISTANCE2, result2);
    }
}