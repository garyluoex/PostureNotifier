package com.garyluoex.project.data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by kaluo on 3/12/17.
 */
public class ResultData {

    public static final AtomicReference<String> postureQuality = new AtomicReference<String>("0.0");
    public static final AtomicReference<String> postureQuality_x = new AtomicReference<String>("0.0");
    public static final AtomicReference<String> postureQuality_y = new AtomicReference<String>("0.0");


    public static double getResult() {
        return Double.parseDouble(postureQuality.get());
    }
    public static double getResult_x() {
        return Double.parseDouble(postureQuality_x.get());
    }

    public static double getResult_y() {
        return Double.parseDouble(postureQuality_y.get());
    }


    public static void setResult(double postureQuality) {
        ResultData.postureQuality.set(Double.toString(postureQuality));
    }
    public static void setResult_x(double postureQuality_x) {
        ResultData.postureQuality_x.set(Double.toString(postureQuality_x));
    }
    public static void setResult_y(double postureQuality_y) {
        ResultData.postureQuality_y.set(Double.toString(postureQuality_y));
    }
}
