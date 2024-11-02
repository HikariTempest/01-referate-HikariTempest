package at.htl.vehicle;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepository() {
        vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle getVehicleByLicensePlate(String licensePlate) {
        return vehicles.stream()
                .filter(v ->
                        v.getLicensePlate().equals(licensePlate)
                )
                .findFirst()
                .orElse(null);
    }

    public boolean addVehicle(Vehicle vehicle) {
        var listVehicle = getVehicleByLicensePlate(
                vehicle.getLicensePlate()
        );
        boolean result = false;

        if (listVehicle == null) {
            result = this.vehicles.add(vehicle);
        }

        return result;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        return this.vehicles.remove(vehicle);
    }

    public boolean updateVehicle(Vehicle vehicle) {
        boolean result = false;
        var index = vehicles.indexOf(
                getVehicleByLicensePlate(
                        vehicle.getLicensePlate()
                )
        );

        if (index != -1) {
            var updatedVehicle = this.vehicles.set(
                    index,
                    vehicle
            );

            result = updatedVehicle != null;
        }

        return result;
    }
}
