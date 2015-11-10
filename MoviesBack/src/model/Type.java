package model;

public enum Type {

	MOVIE ("movie"),
	SERIE ("serie");
	
	private final String text;

    private Type(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
