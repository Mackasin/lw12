package com.example.l_spring.entities;

public record Result(double x, double y) {
    @Override
    public double x() {
        return x;
    }

    @Override
    public double y() {
        return y;
    }
}
