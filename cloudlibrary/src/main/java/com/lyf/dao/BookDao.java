package com.lyf.dao;

import com.github.pagehelper.Page;
import com.lyf.domain.Book;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface BookDao {
    @Results(
            value = {
                    @Result(id = true,column = "book_id",property = "id"),
                    @Result(column = "book_name",property = "name"),
                    @Result(column = "book_isbn",property = "isbn"),
                    @Result(column = "book_press",property = "press"),
                    @Result(column = "book_author",property = "author"),
                    @Result(column = "book_pagination",property = "pagination"),
                    @Result(column = "book_price",property = "price"),
                    @Result(column = "book_uploadtime",property = "uploadTime"),
                    @Result(column = "book_status",property = "status"),
                    @Result(column = "book_borrower",property = "borrower"),
                    @Result(column = "book_borrowtime",property = "borrowTime"),
                    @Result(column = "book_returntime",property = "returnTime")
            }
    )
    @Select("select * from book where book_status != '3' order by book_uploadtime desc")
    Page<Book> selectNewBooks();
}
