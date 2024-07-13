package ru.job4j.dreamjob.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Candidate {
    public static final Map<String, String> COLUMN_MAPPING = Map.of(
            "id", "id",
            "name", "name",
            "description", "description",
            "creation_date", "creationDate",
            "city_id", "cityId",
            "file_id", "fileId"
    );

    private Integer id;
    private String name;
    private String description;
    private LocalDateTime creationDate = LocalDateTime.now();
    private Integer cityId;
    private Integer fileId;

    public Candidate() {
    }

    public Candidate(Integer id, String name, String description, Integer cityId, Integer fileId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.fileId = fileId;
        this.cityId = cityId;
    }

    public Candidate(Integer id, String name, String description,
                     LocalDateTime creationDate, Integer cityId, Integer fileId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.cityId = cityId;
        this.fileId = fileId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
