/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

/**
 * A class for computing values along a logistic function
 * See the Desmos graph: https://www.desmos.com/calculator/mjfwqn4jif
 * @author Leo Wilson
 */
public class Sigmoid {
    private double a;
    private double c;
    private double d;
    private double h;
    private double k;

    /**
     * The listed defaults construct a reference sigmoid
     * Often, the values should be tuned to the specific application
     * 
     * The values are named based on their effect assuming all other constants are set to the default
     * If other values are changed from their defaults, a constant may not produce its exact expected behavior
     * For example, changing limit will cause the y-intercept from (0, center)
     * 
     * Note that exceeding the specified bounds may couse unexpected behavior and should be avoided
     * If a logistic function cannot be constructed w/o exceeding the specified bounds, this class should be ammended accordingly
     * @param center The value at zero (0.5, >=0)
     * @param damping The damping constant; higher = more gradual and thus wider (1, >=0)
     * @param limit Stretches the limit of the function vertically; higher = more vertical stretching (1, >=0)
     * @param invert Up or down (true = invert)
     * @param hshift Horizontal translation
     * @param vshift Vertical translation
     */
    public Sigmoid(double center, double damping, double limit, boolean invert, double hshift, double vshift) {
        c = center * 2; // (0, c/2)
        d = 1 / damping; // the inverse acts more intuitively
        a = (invert ? -1 : 1) * limit / 2;
        h = hshift;
        k = vshift;
    }

    /**
     * Calculates the function's value at x
     * See the Desmos graph for a proper representation
     */
    public double calculate(double x) {
        return (a * c / (1 + Math.pow(Math.E, -d * (x - h)))) + k;
    }
}
