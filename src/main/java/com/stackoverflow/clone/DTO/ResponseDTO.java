package com.stackoverflow.clone.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO<T> {

    Collection<T> results;

    T result;

    ErrorDTO error;

    String responseStatus;
}
