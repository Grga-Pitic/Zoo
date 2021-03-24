package org.pet.main.emun;

public enum Action {
    FEED,
    CLEANUP,
    ;

    public String toUnderstandbleString() {
        switch (this) {
            case CLEANUP:
                return "clean up";
            case FEED:
                return "feed";
            default:
                return "unknown";
        }
    }
}
