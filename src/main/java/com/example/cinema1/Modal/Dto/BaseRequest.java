package com.example.cinema1.Modal.Dto;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Data
public class BaseRequest {

    protected int pageNumber;
    protected int pageSize;
    protected String sortField;
    protected String sortType;

    public static void verify(BaseRequest request){
        if (request.getPageNumber() == 0){
            request.setPageNumber(1);
        }
        if (request.getPageSize() == 0){
            request.setPageSize(5);
        }
        if (request.getSortField()==null || "".equals(request.getSortField())){
            request.setSortField("id");
        }
        if (request.getSortType()==null || "".equals(request.getSortType())){
            request.setSortType("DESC");
        }
    }

    public static PageRequest buildPageRequest(BaseRequest request){
        PageRequest pageRequest = null;
        if ("DESC".equals(request.getSortType())){
            pageRequest = PageRequest.of(request.getPageNumber() - 1, request.getPageSize(),
                    Sort.by(request.getSortField()).descending());
        } else {
            pageRequest = PageRequest.of(request.getPageNumber() - 1, request.getPageSize(),
                    Sort.by(request.getSortField()).ascending());
        }
        return pageRequest;
    }

}
