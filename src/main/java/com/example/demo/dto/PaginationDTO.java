package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈亦铖
 */
@Data
public class PaginationDTO {
    private List<QuestionDTO> question;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;

    public void setPagination(Integer totalPage, Integer page, Integer size) {
        this.totalPage=totalPage;
        this.page = page;
        if (page == 1) {
            showPrevious = false;
        }
        if (page == totalPage) {
            showNext = false;
        }
        if (pages.contains(1)) {
            showFirstPage = false;
        }
        if (pages.contains(totalPage)) {
            showEndPage = false;
        }
        pages.add(page);
        for (int i = 0; i <= 3; i++) {
            if (page - i > 0) {
                pages.add(0, page - i);
            }
            if (page + i <= totalPage) {
                pages.add(page + i);
            }
        }

    }
}
