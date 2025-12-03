package com.api.fareupdater.updater.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ResultEntity {
    @Id
    @Column(name = "Result")
    private int result;
}
