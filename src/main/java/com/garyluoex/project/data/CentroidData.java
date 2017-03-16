package com.garyluoex.project.data;

/**
 * Created by kaluo on 3/15/17.
 */
public class CentroidData {
    private final double xCentroid;
    private final double yCentroid;

    public CentroidData(double xCentroid, double yCentroid) {
        this.xCentroid = xCentroid;
        this.yCentroid = yCentroid;
    }

    public double getX() {
        return xCentroid;
    }

    public double getY() {
        return yCentroid;
    }

}
