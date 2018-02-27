package com.my.fitness.enums;

/**
 * Length unit enum class
 */
public enum LengthUnit {

    /**
     * Values
     */
    CENTIMETER("CENTIMETER"),
    METER("METER"),
    INCH("INCH"),
    FOOT("FOOT");

    /**
     * Enum value
     */
    private String value;

    /**
     * Constructor
     * @param value Enum value
     */
    LengthUnit(String value) {
        this.value = value;
    }

    /**
     * Get enum value
     * @return Enum value
     */
    public String getValue() {
        return value;
    }
}
