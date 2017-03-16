package com.garyluoex.project.processor;

import com.garyluoex.project.config.Configuration;
import com.garyluoex.project.processor.ParsingProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by kaluo on 3/12/17.
 */
public class DataProcessingThread implements Runnable {
    private final Thread thread;

    public DataProcessingThread() {
        this.thread = new Thread(this);
    }

    public void run() {
        try {
            Files.lines(Paths.get(Configuration.USB_DEVICE_URL))
                    .map(ParsingProcessor::processData)
                    .map(CentroidProcessor::processData)
                    .forEach(ResultProcessor::processData);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        thread.start();
    }
}
