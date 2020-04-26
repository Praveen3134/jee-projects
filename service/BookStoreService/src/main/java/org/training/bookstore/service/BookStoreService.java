package org.training.bookstore.service;

import java.io.InputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.training.bookstore.ejb.BookStore;
import org.training.example.models.Book;

@Path("/bookService")
public class BookStoreService {

    @EJB
    private BookStore store;

    @GET
    @Path("/bookStore")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookStore() {
	List<Book> items = store.getItems();
	JsonbConfig config = new JsonbConfig().withFormatting(true);

	Jsonb json = JsonbBuilder.create(config);
	String jsonData = json.toJson(items);

	return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).entity(jsonData).build();
    }

    @POST
    @Path("/addBook")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String addBookToStore(MultivaluedMap<String, String> bookData) {
	Book book = new Book();
	book.setName(bookData.get("name").get(0));
//	book.setAuthor(bookData.get("author").get(0));
	book.setDescription(bookData.get("description").get(0));
	book.setPrice(Float.parseFloat(bookData.get("price").get(0)));
	book.setLanguage(bookData.get("language").get(0));
	book.setLanguage(bookData.get("isbn").get(0));
	book.setLanguage(bookData.get("noOfPages").get(0));

	store.addBook(book);

	return Response.ok().build().toString();
    }

    @GET
    @Path("/home")
    public Response home(@Context ServletContext context) {
	InputStream stream = context.getResourceAsStream("/WEB-INF/resources/AddBooks.html");
	return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML).entity(stream).build();
    }
}
