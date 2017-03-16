package com.garyluoex.project.data;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/15/17.
 */
public class SensorData {
    double[] forceReading;

    public SensorData(double[] forceReading) {
        this.forceReading = forceReading;
    }

    public double getForceData(int index) {
        if (index >= SENSOR_COUNT || index < 0)
            throw new IndexOutOfBoundsException("There are only " + SENSOR_COUNT + " sensors");

        return forceReading[index];
    }
}
