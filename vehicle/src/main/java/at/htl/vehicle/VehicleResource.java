package at.htl.vehicle;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/vehicle")
@Produces(MediaType.APPLICATION_JSON)
public class VehicleResource {

    @Inject
    VehicleRepository vehicleRepository;

    @GET
    public List<Vehicle> getVehicles() {
        return vehicleRepository.getVehicles();
    }

    @GET
    @Path("/{licensePlate}")
    public Response getVehicles(@PathParam("licensePlate") String licensePlate) {
        var vehicle = vehicleRepository.getVehicleByLicensePlate(
                licensePlate
        );

        Response.ResponseBuilder response;

        if (vehicle != null) {
            response = Response.ok(vehicle);
        } else {
            response = Response.status(
                    Response.Status.NOT_FOUND
            );
        }

        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addVehicle(Vehicle vehicle) {
        Response.ResponseBuilder response;

        if (vehicleRepository.addVehicle(vehicle)) {
            response = Response.ok(vehicle);
        } else {
            response = Response.status(
                    Response.Status.BAD_REQUEST
            );
        }

        return response.build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteVehicle(Vehicle vehicle) {
        vehicleRepository.removeVehicle(vehicle);
        return Response.ok(vehicle).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateVehicle(Vehicle vehicle) {
        Response.ResponseBuilder response;

        if (vehicleRepository.updateVehicle(vehicle)) {
            response = Response.ok(vehicle);
        } else {
            response = Response.status(
                    Response.Status.NOT_FOUND
            );
        }

        return response.build();
    }
}
