package ua.ciklum.stkn.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import static org.hibernate.internal.util.StringHelper.isBlank;

@MappedSuperclass
public class AuditableEntity extends PanacheEntity {
    @CreationTimestamp
    protected LocalDateTime created;

    @UpdateTimestamp
    protected LocalDateTime updated;

    protected String createdBy;

    @PrePersist
    void setCreateByDefault() {
        if (isBlank(createdBy)) createdBy = "system";
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public String getCreatedBy() {
        return createdBy;
    }
}