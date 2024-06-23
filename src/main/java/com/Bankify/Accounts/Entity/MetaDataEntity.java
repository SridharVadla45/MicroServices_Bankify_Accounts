package com.Bankify.Accounts.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@MappedSuperclass
public class MetaDataEntity {

    @Column(updatable = false , insertable = true)
    private LocalDate createdAt;
    @Column(updatable = false , insertable = true)
    private String createdBy;
    @Column(insertable = false , updatable = true)
    private LocalDate updatedAt;
    @Column(insertable = false, updatable = true)
    private LocalDate updatedBy;

}
