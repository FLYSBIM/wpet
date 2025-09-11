package com.findpet.wpet.pet.presentation;

import com.findpet.wpet.common.dto.ResponseData;
import com.findpet.wpet.common.dto.ResponseDto;
import com.findpet.wpet.common.dto.ResponseDtoStatusCode;
import com.findpet.wpet.pet.application.PetNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class PetControllerAdvice {

    @ExceptionHandler({PetNotFoundException.class})
    public ResponseEntity handlingSelectException(final PetNotFoundException e, final HttpServletRequest request) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(ResponseDtoStatusCode.NOT_FOUND)
                .body(ResponseDto.builder()
                        .path(request.getRequestURI())
                        .method(request.getMethod())
                        .message(e.getMessage())
                        .data(ResponseData.builder()
                                .insert("requestNo",e.getPetId())
                                .build())
                        .statusCode(ResponseDtoStatusCode.NOT_FOUND)
                        .build());
    }


}
