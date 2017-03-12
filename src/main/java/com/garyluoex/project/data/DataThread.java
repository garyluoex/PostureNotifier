package com.garyluoex.project.data;

import com.garyluoex.project.config.Configuration;
import com.garyluoex.project.data.DataProcessor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by kaluo on 3/12/17.
 */
public class DataThread implements Runnable {
    private Thread thread;

    public DataThread(String name) {
        this.thread = new Thread(this);
    }

    public void run() {
        try {

            Stream<String> stream = Files.lines(Paths.get(Configuration.USB_DEVICE_URL));
            stream.map(DataProcessor::processData).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void start() {
        thread.start();
    }
}
