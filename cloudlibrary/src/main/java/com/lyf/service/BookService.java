package com.lyf.service;

import entity.PageResult;

public interface BookService {
    PageResult selectNewBooks(Integer pageNum, Integer pageSize);
}
