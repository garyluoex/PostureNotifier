package com.garyluoex.project.config;

/**
 * Created by kaluo on 3/12/17.
 */
public interface Configuration {

    // =============== Picture Resource Locators ==============

    public static final String USB_DEVICE_URL = "/dev/cu.usbmodem1421";

    public static final String BACKGROUND_CIRCLE_URL = "src/main/resources/Circles.jpg";
    public static final String CALIBRATE_BUTTON_GREY_URL = "src/main/resources/Calibrate_button.png";
    public static final String CALIBRATE_BUTTON_GREEN_URL = "src/main/resources/Calibrate_button_green.png";
    public static final String HISTORY_BUTTON_GREY_URL = "src/main/resources/History_button.png";
    public static final String HISOTRY_BUTTON_GREEN_URL = "src/main/resources/History_button_green.png";

    public static final String HISTORY_HOUR_URL = "src/main/resources/history/History_Hourly.png";
    public static final String HISTORY_DAY_URL = "src/main/resources/history/History_Daily.png";
    public static final String HISTORY_WEEK_URL = "src/main/resources/history/History_Weekly.png";
    public static final String HISTORY_MONTH_URL = "src/main/resources/history/History_Monthly.png";

    public static final String DOT_GREEN_URL = "src/main/resources/Greendot.png";
    public static final String DOT_RED_URL = "src/main/resources/Orangedot.png";


    // =============== Tuning configuration parameters ==============

    public static final int FRAME_HEIGHT = 300;
    public static final int FRAME_WIDTH = 300;

    public static final int HISTORY_FRAME_HEIGHT = 500;
    public static final int HISTORY_FRAME_WIDTH = 500;

    public static final int HISTORY_FRAME_START_X = FRAME_WIDTH+10;
    public static final int HISTORY_FRAME_START_Y = 0;

    public static final int DOT_HEIGHT = 20;
    public static final int DOT_WIDTH = 20;

    public static final int DOT_CENTER_X = 0;
    public static final int DOT_CENTER_Y = 1;

    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = (int) (BUTTON_WIDTH*0.23);

    public static final double BUTTON_GAP_FACTOR = 3.5;

    public static final int SENSOR_COUNT = 12;

    public static final double POSITION_FACTOR = 8;

    public static final double NORMALIZATION_FACTOR = 10;
}
