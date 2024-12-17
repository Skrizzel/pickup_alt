package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import jakarta.persistence.Entity;


@Entity
@Path("/address")
public class Address extends PanacheEntity {
    private String street;
    private String city;
    private String postalCode;
    private String country;
    private String houseNumber;

    public Address() {}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAddress(Address address) {
        if (address == null || address.street == null || address.city == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Street and city are required fields.\"}")
                    .build();
        }
        address.persist();
        return Response.ok(address).status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAddresses() {
        List<Address> addresses = Address.listAll();
        return Response.ok(addresses).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAddress(@PathParam("id") Long id) {
        Address address = Address.findById(id);
        if (address == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Address not found.\"}")
                    .build();
        }
        address.delete();
        return Response.ok("{\"message\": \"Address deleted successfully.\"}").build();
    }
}
