package com.garyluoex.project.data;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by kaluo on 3/12/17.
 */
public class DataResult {

    private final AtomicReference<String> result = new AtomicReference<String>();

    public String getResult() {
        return result.get();
    }

    public void setResult(String newValue) {
        result.set(newValue);
    }
}
