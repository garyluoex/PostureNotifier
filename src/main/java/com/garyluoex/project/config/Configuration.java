package com.garyluoex.project.config;

/**
 * Created by kaluo on 3/12/17.
 */
public interface Configuration {

    public static final String USB_DEVICE_URL = "/dev/cu.usbmodem1411";

    public static final String BACKGROUND_CIRCLE_URL = "src/main/resources/Circles.jpg";
    public static final String CALIBRATE_BUTTON_URL = "src/main/resources/Calibrate_button.png";
    public static final String HISTORY_BUTTON_URL = "src/main/resources/History_button.png";

    public static final String DOT_GREEN_URL = "src/main/resources/Greendot.png";
    public static final String DOT_RED_URL = "src/main/resources/Orangedot.png";


    public static final int FRAME_HEIGHT = 270;
    public static final int FRAME_WIDTH = 700;

    public static final int DOT_HEIGHT = 30;
    public static final int DOT_WIDTH = 30;

    public static final int CIRCLE_HEIGHT = 250;
    public static final int CIRCLE_WIDTH = 250;

    public static final int CIRCLE_CENTER_X = -8;
    public static final int CIRCLE_CENTER_Y = 1;

    public static final int BUTTON_HEIGHT = 100;
    public static final int BUTTON_WIDTH = 100;

    public static final int SENSOR_COUNT = 12;

    public static final double POSITION_FACTOR = 8;
    
    public static final double NORMALIZATION_FACTOR = 10;
}
