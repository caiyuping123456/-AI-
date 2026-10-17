package org.example.pojo;

import java.util.Objects;

/**
 * @author caiyuping
 * @date 2026/10/17 21:17
 * @description: 类别表
 */
public class Categories {
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories() {
    }

    private int id;

    public Categories(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private String name;
    private String description;

}
