package com.erp_demo.enums;

public enum MeasureUnit {
    SZTUKA("szt.");

    private final String measureUnit;

    MeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }
}
