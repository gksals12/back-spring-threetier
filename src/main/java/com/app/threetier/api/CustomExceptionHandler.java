package com.app.threetier.api;

import com.app.threetier.domain.dto.ApiResponseDTO;
import com.app.threetier.exception.*;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(MemberException.class)
    protected ResponseEntity<Object> memberExceptionHandler(MemberException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        if(e instanceof MemberExistEmailException){
            status = HttpStatus.CONFLICT;
        }else if(e instanceof MemberLoginException){
            status = HttpStatus.UNAUTHORIZED;
        }else if( e instanceof MemberModifyException){
            status = HttpStatus.FORBIDDEN;
        }else if( e instanceof MemberDeleteException){
            status = HttpStatus.NOT_FOUND;
        }else if( e instanceof  MemberPasswordException){
            status = HttpStatus.UNAUTHORIZED;
        }else if( e instanceof  MemberNotFoundException){
            status = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(status).body(ApiResponseDTO.of(e.getMessage()));
    }
}
