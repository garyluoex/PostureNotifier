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
    public static final String DOT_ORANGE_URL = "src/main/resources/Orangedot.png";
    public static final String DOT_RED_URL = "src/main/resources/Reddot.png";




    // =============== Tuning UI configuration parameters ==============

    public static final int FRAME_HEIGHT = 300;
    public static final int FRAME_WIDTH = 300;

    public static final int HISTORY_FRAME_HEIGHT = 500;
    public static final int HISTORY_FRAME_WIDTH = 500;

    public static final int HISTORY_FRAME_START_X = FRAME_WIDTH+10;
    public static final int HISTORY_FRAME_START_Y = 0;

    public static final int DOT_HEIGHT = 30;
    public static final int DOT_WIDTH = 30;

    public static final int BUTTON_WIDTH = 200;
    public static final int BUTTON_HEIGHT = (int) (BUTTON_WIDTH*0.23);

    public static final double BUTTON_GAP_FACTOR = 3.5;

    // =============== Tuning Data Sensitivity configuration parameters ==============

    // Seated threshold, sum of forces to exceed to be considered seated
    public static final int SEATED_THRESHOLD = 50;

    // Vibration threshold, between 0 and 1
    public static final double VIBRATION_ACTIVATION_THRESHOLD = 0.95;

    // Dot's initial position
    public static final int DOT_CENTER_X = 0;
    public static final int DOT_CENTER_Y = 0;

    // Effective sensor count
    public static final int SENSOR_COUNT = 12;

    // Dot movement sensitivity, higher means more sensitive
    public static final double POSITION_FACTOR = 15;

    // Dot hue change sensitivity
    public static final double NORMALIZATION_FACTOR = 5;

    // Sensor position where the position indicates the sensor number
    public static final double[] SENSOR_POSITION_X = new double[] {20, 130, 20, 20, 130, 75, 170, 225, 280, 280, 170, 280};
    public static final double[] SENSOR_POSITION_Y = new double[] {280, 250, 190, 110, 150, 25, 150, 25, 110, 190, 250, 280};

    // Sensor force weight multiplying factor, number position in the list indicates sensor number
    public static final double[] SENSOR_FORCE_WEIGHT = new double[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    // Red dot warning after this amount of second passed
    public static final double RED_DOT_TIME = 10;

    // The time in second to wait between vibration
    public static final double DURATION_TIME = 3;

    // The time in second to wait between flashing based on DURATION_TIME/FLASH_TIME
    public static final double FLASH_TIME = 0.5;

    // Radius of the dot from the center to strat counting time for red dot warning
    public static final double RED_DOT_RADIUS_THRESHOLD = 4;
}
