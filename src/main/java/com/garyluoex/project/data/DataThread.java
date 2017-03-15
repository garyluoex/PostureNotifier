package com.garyluoex.project.data;

import com.garyluoex.project.config.Configuration;
import com.garyluoex.project.processor.TestDataProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by kaluo on 3/12/17.
 */
public class DataThread implements Runnable {
    private final Thread thread;
    private final TestDataProcessor processor;

    public DataThread(TestDataProcessor processor) {
        this.thread = new Thread(this);
        this.processor = processor;
    }

    public void run() {
        try {

            Stream<String> stream = Files.lines(Paths.get(Configuration.USB_DEVICE_URL));
            stream.forEach(processor::processData);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        thread.start();
    }
}
