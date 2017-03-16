package com.garyluoex.project.processor;

import com.garyluoex.project.data.SensorData;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by kaluo on 3/15/17.
 */
public class ParsingProcessor {

    public static SensorData processData(String data) {
        System.out.println(data);
        String[] dataArray = data.split(",");
        return new SensorData(Arrays.stream(dataArray)
                .mapToDouble(Double::parseDouble).toArray());
    }
}
