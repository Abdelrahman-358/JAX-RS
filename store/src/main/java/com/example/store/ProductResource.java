package com.example.store;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/products")
public class ProductResource {

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return ProductRepository.getProducts();
    }

    @POST
    @Path("/add")
    public Response addProduct(@QueryParam("name") String name, @QueryParam("price") String price) {
        if (name == null || price == null) {
            throw new BadRequestException("Name and price must be provided");
        }
        ProductRepository.addProduct(name, Double.parseDouble(price));
        URI location = UriBuilder.fromResource(ProductResource.class).path("/list").build();
        return Response.created(location).build();
    }

    @PUT
    @Path("/update")
    public Response updateProduct(@QueryParam("name") String name, @QueryParam("price") String price) {
        if (name == null || price == null) {
            throw new BadRequestException("Name and price must be provided");
        }
        ProductRepository.updateProduct(name, Double.parseDouble(price));
        return Response.ok().build();
    }

    @Path("/DeleteByName")
    public Response deleteProductByName(@QueryParam("name") String name) {
        if (name == null) {
            throw new BadRequestException("Name must be provided");
        }
        boolean removed = ProductRepository.removeProductByName(name);

        if (removed) {
            return Response.ok().build();
        }else  {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
