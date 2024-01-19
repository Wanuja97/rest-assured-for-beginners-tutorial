package com.api.testcases;

import com.api.endpoints.BookEndpoints;
import com.api.payload.BookPayload;
import com.api.utils.StatusCodeHandler;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class BookTestCases {
    static ResourceBundle getCredentials() {
        ResourceBundle credentials = ResourceBundle.getBundle("config");
        return credentials;
    }

    String username = getCredentials().getString("admin");
    String password = getCredentials().getString("password");

    private BookPayload bookPayload;

    @Parameters({"title", "author"})
    public void payloadSetUp(String title, String author) {
        bookPayload = new BookPayload();
        bookPayload.setTitle(title);
        bookPayload.setAuthor(author);
    }

    @Parameters({"id","title","author"})
    public void payloadSetUp(int id,String title, String author) {
        bookPayload = new BookPayload();
        bookPayload.setId(id);
        bookPayload.setTitle(title);
        bookPayload.setAuthor(author);
    }

    @Test()
    public void testCreateBook() {
        payloadSetUp("Book 8", "Author 01");
        Response response = BookEndpoints.createBook(bookPayload, username, password);
        // Validate the response
        StatusCodeHandler.handleStatusCode(response,201);
        // Validate that the response contains a specific field
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("title"), "Title not found in the response");
    }

    @Test()
    public void testUpdateBook(){
        payloadSetUp(11,"Book 8fsdfd Updated", "Author 01");
        Response response = BookEndpoints.updateBook(bookPayload,username,password);
        // Validate the response
        StatusCodeHandler.handleStatusCode(response,200);
        // Additional assertions based on the response content, if needed
    }

    @Test()
    public void testDeleteBook(){
        int bookId = 12;
        Response response = BookEndpoints.deleteBook(bookId,username,password);
        // Validate the response
        StatusCodeHandler.handleStatusCode(response,200);
        // Additional assertions based on the response content, if needed
    }

    @Test()
    public void testGetAllBooks(){
        Response response = BookEndpoints.getAllBooks(username,password);
        // Validate the response
        StatusCodeHandler.handleStatusCode(response,200);
        // Additional assertions based on the response content, if needed
    }
}
