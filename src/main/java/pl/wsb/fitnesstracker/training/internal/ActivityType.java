package pl.wsb.fitnesstracker.training.internal;

/**
 * The enum Activity type.
 */
public enum ActivityType {

    /**
     * Running activity type.
     */
    RUNNING("Running"),
    /**
     * Cycling activity type.
     */
    CYCLING("Cycling"),
    /**
     * Walking activity type.
     */
    WALKING("Walking"),
    /**
     * Swimming activity type.
     */
    SWIMMING("Swimming"),
    /**
     * Tennis activity type.
     */
    TENNIS("Tenis");

    private final String displayName;

    ActivityType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

}
