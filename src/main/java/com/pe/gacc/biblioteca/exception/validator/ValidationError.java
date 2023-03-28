package com.pe.gacc.biblioteca.exception.validator;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError extends SubError{

    private String object;
    private String field;
    private Object rejectValue;
    private String message;

    public ValidationError(String object, String message){
        this.object = object;
        this.message = message;
    }

}
