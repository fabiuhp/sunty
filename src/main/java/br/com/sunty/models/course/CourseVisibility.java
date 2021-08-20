package br.com.sunty.models.course;

public enum CourseVisibility {
    PUBLICA("Pública"), PRIVADA("Privada");

    private final String displayName;

    CourseVisibility(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

