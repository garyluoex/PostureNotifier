package com.garyluoex.project.processor;

import static com.garyluoex.project.config.Configuration.*;
import com.garyluoex.project.data.CentroidData;
import com.garyluoex.project.data.SensorData;

/**
 * Created by kaluo on 3/15/17.
 */
public class CentroidProcessor {

    public static double[] xPosition = new double[] {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1};
    public static double[] yPosition = new double[] {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1};

    public static CentroidData processData(SensorData sensorData) {
        double xTotal = 0;
        double yTotal = 0;
        for (int i = 0; i < SENSOR_COUNT; i++) {
            xTotal += sensorData.getForceData(i)*xPosition[i];
            yTotal += sensorData.getForceData(i)*yPosition[i];
        }
        return new CentroidData(xTotal/SENSOR_COUNT, yTotal/SENSOR_COUNT);
    }

}
