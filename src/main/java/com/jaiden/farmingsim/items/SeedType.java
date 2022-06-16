package com.jaiden.farmingsim.items;

public enum SeedType {
    BARLEY(1),
    CANOLA(2),
    CARROTS(3),
    CORN(4),
    COTTON(5),
    OAT(6),
    POTATOES(7),
    SOY(8),
    SUNFLOWER(9),
    WHEAT(10);

    int id;

    SeedType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
