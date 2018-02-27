package com.my.fitness.dto;

import com.my.fitness.enums.LengthUnit;
import com.my.fitness.enums.WeightUnit;

/**
 * Account entity data transfer object
 */
public class AccountEntityDto extends EntityDto {
    /**
     * Name
     */
    private String name;

    /**
     * Length unit
     */
    private LengthUnit lengthUnit;

    /**
     * Weight unit
     */
    private WeightUnit weightUnit;

    /**
     * Get name
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     * @param name Name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get length unit
     * @return Length unit
     */
    public LengthUnit getLengthUnit() {
        return lengthUnit;
    }

    /**
     * Set length unit
     * @param lengthUnit Length unit
     */
    public void setLengthUnit(LengthUnit lengthUnit) {
        this.lengthUnit = lengthUnit;
    }

    /**
     * Get weight unit
     * @return Weight unit
     */
    public WeightUnit getWeightUnit() {
        return weightUnit;
    }

    /**
     * Set weight unit
     * @param weightUnit Weight unit
     */
    public void setWeightUnit(WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
