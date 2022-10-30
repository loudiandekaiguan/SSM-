package com.lyf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageResult<Book> selectNewBooks(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<Book> page = bookDao.selectNewBooks();
        System.out.println(page);
        return new PageResult<>(page.getTotal(), page.getResult());
    }
}
