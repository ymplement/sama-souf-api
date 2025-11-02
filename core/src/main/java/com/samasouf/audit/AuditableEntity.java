package com.samasouf.audit;

import java.time.OffsetDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class AuditableEntity {

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_by_ip")
    private String createdByIp;

    @Column(name = "updated_by_ip")
    private String updatedByIp;

    @Column(name = "created_by_user_agent")
    private String createdByUserAgent;

    @Column(name = "updated_by_user_agent")
    private String updatedByUserAgent;
}
