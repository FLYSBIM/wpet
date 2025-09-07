package com.findpet.wpet.common.dto;

import java.time.LocalDateTime;

public interface DescriptiveResponse {
    String getPath();
    String getMethod();
    String getMessage();
    Object getData();
    int getStatusCode();
    LocalDateTime getTimeStamp();
}
