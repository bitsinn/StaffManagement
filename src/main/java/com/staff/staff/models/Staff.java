package com.staff.staff.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(value = 1, message = "Must be grater then 0")
    @NotNull(message = "This field can not be null")
    private Long employeeId;
    @Min(value = 1, message = "Must be grater then 0")
    @NotNull(message = "This field can not be null")
    private Long projectId;
    @NotNull(message = "This field can not be null")
    private LocalDateTime projectStartedAt;
    private LocalDateTime projectFinishedAt;
    private Long projectDuration;

    public Staff() {
    }

    public Staff(Long id, Long employeeId, Long projectId, LocalDateTime projectStartedAt, LocalDateTime projectFinishedAt, Long projectDuration) {
        this.id = id;
        this.employeeId = employeeId;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
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
