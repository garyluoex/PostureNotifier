package com.garyluoex.project.data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kaluo on 3/12/17.
 */
public class DataResult {
    private AtomicInteger result = new AtomicInteger();

    public int getResult() {
        return result.get();
    }

    public void setResult(int newValue) {
        result.getAndSet(newValue);
    }
}
