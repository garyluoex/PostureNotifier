package com.garyluoex.project.processor;

import com.garyluoex.project.data.DataResult;

/**
 * Created by kaluo on 3/12/17.
 */
public class TestDataProcessor implements DataProcessor{

    private final DataResult result;

    public TestDataProcessor(DataResult result) {
        this.result = result;
    }

    @Override
    public String processData(String data) {
        result.setResult(data);
        return result.getResult();
    }
}
