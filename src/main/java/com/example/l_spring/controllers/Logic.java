package com.example.l_spring.controllers;

import com.example.l_spring.entities.Result;
import org.springframework.stereotype.Component;

import static java.lang.Math.*;

@Component
public class Logic {

    public double tabulation(double x, double b) {
        double eps = 0.0001;
        double n = b * x;
        if (b * x - eps > 0.45) {
            return n + log(n);
        } else {
            return n - tan(n);
        }
    }

    public int calculateSteps(double x1, double x2, double step) {
        return (int) ((x2 - x1) / step) + 1;
    }

    public double[] xValuesArrayCreate(double x1, double x2, double step) {
        return new double[calculateSteps(x1, x2, step)];
    }

    public double[] yValuesArrayFill(double[] xValues, double a) {
        double[] yValues = new double[xValues.length];
        for (int i = 0; i < yValues.length; i++) {
            yValues[i] = tabulation(xValues[i], a);
        }
        return yValues;
    }

    public double[] xValuesArrayFill(double x1, double x2, double step) {
        double[] xValues = xValuesArrayCreate(x1, x2, step);
        for (int i = 0; i < xValues.length; i++) {

            xValues[i] = x1 + i * step;
        }
        return xValues;
    }

    public int getMinIndex(double[] yValues) {
        int minIndex = 0;
        for (int i = 0; i < yValues.length; i++) {
            if (yValues[i] < yValues[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public double getMinElement(double[] yValues) {
        int minNumber = getMinIndex(yValues);
        return yValues[minNumber];
    }

    public double getMinElementArgument(double[] yValues, double[] xValues) {
        int minNumber = getMinIndex(yValues);
        return xValues[minNumber];
    }

    public int getMaxIndex(double[] yValues) {
        int maxIndex = 0;
        for (int i = 0; i < yValues.length; i++) {
            if (yValues[i] > yValues[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public double getMaxElement(double[] yValues) {
        int maxNumber = getMaxIndex(yValues);
        return yValues[maxNumber];
    }

    public double getMaxElementArgument(double[] yValues, double[] xValues) {
        int maxNumber = getMaxIndex(yValues);
        return xValues[maxNumber];
    }

    public double getSum(double[] yValues) {
        double sum = 0;
        for (int i = 0; i < yValues.length; i++) {
            sum = sum + yValues[i];
        }
        return sum;
    }

    public double getAverage(double[] yValues) {
        double sum = getSum(yValues);
        double average;
        average = sum / yValues.length;
        return average;
    }

    public Result[] convertToResult(double[] yValues, double[] xValues) {

        Result[] result = new Result[yValues.length];

        for (int i = 0; i < yValues.length; i++) {

            result[i] = new Result(yValues[i], xValues[i]);
        }

        return result;

    }
}
