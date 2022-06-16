package com.jaiden.farmingsim.items;

public enum SeedType {
    NONE(0, "none"),
    BARLEY(1, "barley"),
    CANOLA(2, "canola"),
    CARROTS(3, "carrot"),
    CORN(4, "corn"),
    COTTON(5, "cotton"),
    OAT(6, "oat"),
    POTATOES(7, "potato"),
    SOY(8, "soy"),
    SUNFLOWER(9, "sunflower"),
    WHEAT(10, "wheat");

    int index;
    String identifier;

    SeedType(int index, String identifier) {
        this.index = index;
        this.identifier = identifier;
    }

    public int getIndex() {
        return index;
    }

    public String getIdentifier() {
        return identifier;
    }
}
