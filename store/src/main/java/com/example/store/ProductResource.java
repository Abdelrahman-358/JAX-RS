package com.example.store;

import java.util.List;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

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
    public void addProduct(@QueryParam("name") String name, @QueryParam("price") String price) {
        if (name == null || price == null) {
            throw new BadRequestException("Name and price must be provided");
        }
        ProductRepository.addProduct(name, Double.parseDouble(price));
    }

    @PUT
    @Path("/update")
    public void updateProduct(@QueryParam("name") String name, @QueryParam("price") String price) {
        if (name == null || price == null) {
            throw new BadRequestException("Name and price must be provided");
        }
        ProductRepository.updateProduct(name, Double.parseDouble(price));
    }

    @DELETE
    @Path("/DeleteByName")
    public void deleteProductByName(@QueryParam("name") String name) {
        if (name == null) {
            throw new BadRequestException("Name must be provided");
        }
        ProductRepository.removeProductByName(name);
    }
}
