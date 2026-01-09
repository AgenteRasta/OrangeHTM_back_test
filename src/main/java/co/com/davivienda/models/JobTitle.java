package co.com.davivienda.models;

import java.util.Objects;

public class JobTitle {

    private String id;
    private String title;
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        JobTitle jobTitle = (JobTitle) o;
        return Objects.equals(id, jobTitle.id) && Objects.equals(title, jobTitle.title) && Objects.equals(isDelete, jobTitle.isDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isDelete);
    }

    @Override
    public String toString() {
        return "JobTitle{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }
}
