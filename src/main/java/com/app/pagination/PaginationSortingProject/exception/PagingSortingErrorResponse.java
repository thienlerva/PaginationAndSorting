package com.app.pagination.PaginationSortingProject.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagingSortingErrorResponse {

    private int errorCode;
    private String message;

}
