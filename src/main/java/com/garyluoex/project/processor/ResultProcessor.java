package com.garyluoex.project.processor;

import static com.garyluoex.project.config.Configuration.*;
import com.garyluoex.project.data.CentroidData;
import com.garyluoex.project.data.ResultData;

import java.io.IOException;

/**
 * Created by kaluo on 3/15/17.
 */
public class ResultProcessor {
    public static boolean calibration = false;
    public static CentroidData calibrationCentroid = new CentroidData(0, 0);

    public static void processData(CentroidData centroidData) {
        if (ResultProcessor.calibration) {
            calibrationCentroid = centroidData;
        }

        ResultData.setResult(normalizeDistance(findDistance(centroidData)));

        if (ResultData.getResult() > 0.9) {
            try {
                System.out.println("Trying to sent data to arduino: " + "echo 1 > " + USB_DEVICE_URL);
                Runtime.getRuntime().exec(new String[]{"sh","-c", "echo 5 > " + USB_DEVICE_URL});
            } catch (IOException e) {
                throw new RuntimeException("Can not send vibration signal to arduino", e);
            }
        }

        double xDiff = centroidData.getX() - ResultProcessor.calibrationCentroid.getX();
        double yDiff = centroidData.getY() - ResultProcessor.calibrationCentroid.getY();

        ResultData.setResult_x(xDiff);
        ResultData.setResult_y(yDiff);

        System.out.println("Normalized Distance: " + ResultData.getResult());
        System.out.println("X Distance: " + ResultData.getResult_x());
        System.out.println("Y Distance: " + ResultData.getResult_y());

    }

    private static double findDistance(CentroidData dataCenter) {
        double xDiff = dataCenter.getX() - ResultProcessor.calibrationCentroid.getX();
        double yDiff = dataCenter.getY() - ResultProcessor.calibrationCentroid.getY();

        return Math.sqrt((yDiff)*(yDiff) +(xDiff)*(xDiff));
    }

    private static double normalizeDistance(double distance) {
        double normalizedDistance = distance/NORMALIZATION_FACTOR;

        System.out.println("Distance: " + distance);
        if (normalizedDistance > 1.0) {
            return 1.0;
        }

        if (normalizedDistance < 0.0) {
            return 0.0;
        }

        return normalizedDistance;
    }
}
