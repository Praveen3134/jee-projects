package org.training.bookstore.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("/userService")
public class UserService {

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getAddAuthorPage(@Context ServletContext context) {
	InputStream stream = context.getResourceAsStream("/WEB-INF/resources/AddAuthor.html");
	return Response.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_HTML).entity(stream).build();
    }

    @Path("/addAuthor")
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response addAuthor(MultipartFormDataInput input) {
	List<InputPart> image = input.getFormDataMap().get("image");
	List<String> authorData = input.getFormDataMap().entrySet().stream()
		.filter(entry -> !entry.getKey().equals("image")).map(entry -> {
		    String formData = null;
		    try {
			formData = entry.getKey() + ":" + entry.getValue().get(0).getBodyAsString();
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		    return formData;
		}).collect(Collectors.toList());
	try {
	    InputStream stream = image.get(0).getBody(InputStream.class, null);
	    byte[] imageData = IOUtils.toByteArray(stream);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
