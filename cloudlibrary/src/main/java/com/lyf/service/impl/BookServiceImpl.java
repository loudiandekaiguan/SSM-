package com.lyf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lyf.dao.BookDao;
import com.lyf.domain.Book;
import com.lyf.service.BookService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;
    @Override
    public PageResult selectNewBooks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Book> books = bookDao.selectNewBooks();
        return new PageResult(books.getTotal(), books.getResult());
    }
}
