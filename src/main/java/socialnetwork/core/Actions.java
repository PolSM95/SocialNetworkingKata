package socialnetwork.core;

public enum Actions {
    FOLLOW(" follows "),
    POST(" -> "),
    WALL(" wall");

    private String value;

    public String getValue() {
        return value;
    }

    Actions(String value) {
        this.value = value;
    }
}