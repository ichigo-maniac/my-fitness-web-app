package com.my.fitness.enums;

/**
 * Social network type enum
 */
public enum SocialNetworkType {

    /**
     * Values
     */
    FACEBOOK("FACEBOOK"),
    VK_COM("VK_COM"),
    TWITTER("TWITTER"),
    GOOGLE("GOOGLE");

    /**
     * Value
     */
    private String value;

    /**
     * Constructor
     * @param value Value
     */
    SocialNetworkType(String value) {
        this.value = value;
    }

    /**
     * Get value
     * @return Value
     */
    public String getValue() {
        return this.value;
    }


}
