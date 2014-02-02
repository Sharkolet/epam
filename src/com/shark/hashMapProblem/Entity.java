package com.shark.hashMapProblem;

public class Entity {
    private String value;

    public Entity() {
    }

    public Entity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return value.equals(entity.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
