package com.ajik.infrastrucure.db.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public  abstract class BaseEntity {

    @Column(name = "created_at", nullable = false, updatable = false) // 2
    private LocalDateTime createdAt;

    @Column(name = "updated_at") // 3
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at", updatable = false) // 4
    private LocalDateTime deletedAt;

    @PrePersist // 5
    protected void onPersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // 6
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // 논리적 삭제 처리 메서드
    public void softDelete() { // 7
        this.deletedAt = LocalDateTime.now();
    }

    // 삭제 여부 확인 메서드
    public boolean isDeleted() { // 8
        return this.deletedAt != null;
    }
}
