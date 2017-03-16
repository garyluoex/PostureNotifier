package com.garyluoex.project.data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by kaluo on 3/12/17.
 */
public class ResultData {

    public static final AtomicReference<String> postureQuality = new AtomicReference<String>("0.0");

    public static double getResult() {
        return Double.parseDouble(postureQuality.get());
    }

    public static void setResult(double postureQuality) {
        ResultData.postureQuality.set(Double.toString(postureQuality));
    }
}
