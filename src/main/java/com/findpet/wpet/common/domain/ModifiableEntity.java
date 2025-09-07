package com.findpet.wpet.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class ModifiableEntity {

    @Column(name = "create_time", updatable = false, nullable = false)
    private LocalDateTime createTime;

    @Column(name = "modified_time", nullable = false)
    private LocalDateTime modifiedTime;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now= LocalDateTime.now();
        this.createTime = now;
        this.modifiedTime = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.modifiedTime= LocalDateTime.now();
    }
}
