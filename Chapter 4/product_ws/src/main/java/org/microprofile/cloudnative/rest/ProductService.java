package org.microprofile.cloudnative.rest;

import java.io.Serializable;
import java.util.*;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/products")
@ApplicationScoped
public class ProductService implements Serializable {

    private List<Product> products;

    public ProductService(){
        products = new ArrayList<>();

        products.add(new Product(Integer.parseInt("1"), "product 1"));
        products.add(new Product(Integer.parseInt("2") , "product 2"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        // Return a list of products
        return products;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        // Creating a product
        System.out.println("Creating product");
        products.add(product);
        return Response.status(Response.Status.CREATED)
                .entity("New product created").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product product) {
        // Update an existing product
        Response response;
        System.out.println("Updating product");
        for (Product p : products) {
            if (product.getId().equals(p.getId())) {
                p.setName(product.getName());
                response = Response.status(Response.Status.NO_CONTENT)
                        .entity("An existing product updated").build();
                return response;
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Product with id->" + product.getId() + " does not exist")
                .build();
    }

    @DELETE
    @Path("products/{id}")
    public Response deleteProduct(@PathParam("id") Integer id) {
        // Delete a product
        Response response;
        System.out.println("Deleting product with id: " + id);
        for (int i=0; i < products.size(); i++) {
            if (id.equals(products.get(i).getId())) {
                products.remove(i);
                response = Response.status(Response.Status.NO_CONTENT)
                        .entity("A product deleted").build();
                return response;
            }
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Product with id->" + id + " does not exist")
                .build();
    }
}

