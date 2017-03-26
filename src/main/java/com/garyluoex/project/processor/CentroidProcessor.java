package com.garyluoex.project.processor;

import static com.garyluoex.project.config.Configuration.*;
import com.garyluoex.project.data.CentroidData;
import com.garyluoex.project.data.SensorData;

/**
 * Created by kaluo on 3/15/17.
 */
public class CentroidProcessor {

    public static double[] xPosition = new double[] {20, 130, 20, 20, 130, 75, 170, 225, 280, 280, 170, 280};
    public static double[] yPosition = new double[] {280, 250, 190, 110, 150, 25, 150, 25, 110, 190, 250, 280};

    public static CentroidData processData(SensorData sensorData) {
        double xTotal = 0;
        double rawForce = 1;
        double yTotal = 0;
        for (int i = 0; i < SENSOR_COUNT; i++) {
            xTotal += sensorData.getForceData(i)*xPosition[i];
            rawForce += sensorData.getForceData(i);
            yTotal += sensorData.getForceData(i)*yPosition[i];
        }
        return new CentroidData(xTotal/rawForce, yTotal/rawForce);
    }

}
