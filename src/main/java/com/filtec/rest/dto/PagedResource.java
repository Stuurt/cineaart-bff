package com.filtec.rest.dto;

import java.util.List;

public class PagedResource<T> {
    private List<T> content;
    private Page page;

    // Getters and setters
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
