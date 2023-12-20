package com.staff.staff.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @NotNull
    private Long id;
    @Min(value = 1)
    private int projectId;

    @NotNull(message = "This field can not be null")
    private LocalDateTime projectStartedAt;
    private LocalDateTime projectFinishedAt;
    private Long projectDuration;

    public Employee() {
    }

    public Employee(Long id, int projectId, LocalDateTime projectStartedAt, LocalDateTime projectFinishedAt, Long projectDuration) {
        this.id = id;
        this.projectId = projectId;
        this.projectStartedAt = projectStartedAt;
        this.projectFinishedAt = projectFinishedAt;
        this.projectDuration = projectDuration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDateTime getProjectStartedAt() {
        return projectStartedAt;
    }

    public void setProjectStartedAt(LocalDateTime projectStartedAt) {
        this.projectStartedAt = projectStartedAt;
    }

    public LocalDateTime getProjectFinishedAt() {
        return projectFinishedAt;
    }

    public void setProjectFinishedAt(LocalDateTime projectFinishedAt) {
        this.projectFinishedAt = projectFinishedAt;
    }

    public Long getProjectDuration() {
        return projectDuration;
    }

    public void setProjectDuration(Long projectDuration) {
        this.projectDuration = projectDuration;
    }
}
