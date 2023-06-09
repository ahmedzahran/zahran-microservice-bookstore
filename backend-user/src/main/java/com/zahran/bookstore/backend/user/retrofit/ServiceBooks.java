package com.zahran.bookstore.backend.user.retrofit;


import com.zahran.bookstore.backend.user.dto.BookDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceBooks {
    

    @GET("/books/{bookId}")
    Call<BookDto> getBook(@Path("bookId") long bookId);
}
