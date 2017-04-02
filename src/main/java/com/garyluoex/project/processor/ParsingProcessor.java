package com.garyluoex.project.processor;

import static com.garyluoex.project.config.Configuration.*;
import com.garyluoex.project.data.SensorData;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by kaluo on 3/15/17.
 */
public class ParsingProcessor {

    public static SensorData processData(String data) {
        //System.out.println(data);
        String[] dataArray = data.split(",");
        if (dataArray.length >= 16) {
            dataArray[8] = dataArray[9];
            dataArray[9] = dataArray[10];
            dataArray[10] = dataArray[13];
            dataArray[11] = dataArray[15];
        }

        try {
            return new SensorData(Arrays.stream(dataArray)
                    .mapToDouble(Double::parseDouble).toArray());
        } catch (Exception e) {
            return new SensorData(new double[SENSOR_COUNT]);
        }

    }
}
