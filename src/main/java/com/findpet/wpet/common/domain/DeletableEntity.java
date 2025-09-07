package com.findpet.wpet.common.domain;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

public class DeletableEntity extends ModifiableEntity{

    @CreatedDate
    @Column(name = "delete_time")
    private LocalDateTime deleteTime;

    private void checkDeletable(){
        if(deleteTime != null){
            throw new NotDeletableException();
        }
    }
}
