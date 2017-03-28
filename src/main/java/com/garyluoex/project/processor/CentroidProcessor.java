package com.garyluoex.project.processor;

import static com.garyluoex.project.config.Configuration.*;
import com.garyluoex.project.data.CentroidData;
import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.data.SensorData;

/**
 * Created by kaluo on 3/15/17.
 */
public class CentroidProcessor {

    private static final double[] xPosition = SENSOR_POSITION_X;
    private static final double[] yPosition = SENSOR_POSITION_Y;
    private static final double[] sensorWeight = SENSOR_FORCE_WEIGHT;

    public static CentroidData processData(SensorData sensorData) {
        double xTotal = 0;
        double rawForce = 1;
        double yTotal = 0;
        for (int i = 0; i < SENSOR_COUNT; i++) {
            xTotal += sensorData.getForceData(i)*xPosition[i]*sensorWeight[i];
            yTotal += sensorData.getForceData(i)*yPosition[i]*sensorWeight[i];
            rawForce += sensorData.getForceData(i)*sensorWeight[i];
        }
        if (rawForce < SEATED_THRESHOLD) {
            ResultData.setSeated(false);
        } else {
            ResultData.setSeated(true);
        }

        return new CentroidData(xTotal/rawForce, yTotal/rawForce);
    }

}
