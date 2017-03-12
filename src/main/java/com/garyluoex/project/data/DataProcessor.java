package com.garyluoex.project.data;

/**
 * Created by kaluo on 3/12/17.
 */
public class DataProcessor {

    private static final DataResult result = new DataResult();

    public static String processData(String input) {
        int data = Integer.parseInt(input);
        result.setResult(data);
        return input + " processed!";
    }

    public static final int getResult() {
        return result.getResult();
    }
}
