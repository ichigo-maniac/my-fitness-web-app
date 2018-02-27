package com.my.fitness.enums;

/**
 * Weight unit enum class
 */
public enum WeightUnit {

    /**
     * Values
     */
    KILOGRAM("KILOGRAM"),
    GRAM("GRAM"),
    POUND("POUND"),
    OUNCE("OUNCE");

    /**
     * Enum value
     */
    private String value;

    /**
     * Constructor
     * @param value Enum value
     */
    WeightUnit(String value) {
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
