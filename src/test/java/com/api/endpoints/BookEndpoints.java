package com.api.endpoints;

import static io.restassured.RestAssured.given;

import com.api.payload.BookPayload;
import com.api.routes.BookRoutes;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class BookEndpoints {

    public static Response createBook(BookPayload payload, String username, String password) {
        System.out.println("Payload Data: " + payload.getPayloadData());
        Response response =given()
                .header("Content-type", "application/json")
                .auth().preemptive().basic(username,password)
                .body(payload)
                .when()
                .post(BookRoutes.post_url);

        return response;
    }

    public static Response updateBook(BookPayload payload, String username, String password) {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(username, password)
                .body(payload)
                .when()
                .put(BookRoutes.update_url+ payload.getId());
        return response;
    }

    public static Response deleteBook(int bookId, String username, String password) {
        Response response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(username, password)
                .when()
                .delete(BookRoutes.delete_url + bookId);
        return response;
    }

    public static Response getAllBooks(String username, String password) {
        Response response =given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(username,password)
                .when()
                .get(BookRoutes.get_all_books);

        return response;
    }
}
