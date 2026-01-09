package co.com.davivienda.models;

import java.util.Objects;

public class Subnit {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Subnit subnit = (Subnit) o;
        return Objects.equals(id, subnit.id) && Objects.equals(name, subnit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Subnit{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
