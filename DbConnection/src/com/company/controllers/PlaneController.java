package com.company.controllers;

import com.company.entities.Plane;
import com.company.repositories.interfaces.IPlaneRepository;

import java.util.List;

public class PlaneController {
    private final IPlaneRepository repo3;

    public PlaneController(IPlaneRepository repo3) {
        this.repo3 = repo3;
    }

    public String createPlane(int id, String name, int flight_num, String plane_company) {
        Plane plane = new Plane(id, name, flight_num, plane_company);
        /*creating plane*/

        boolean created = repo3.createPlane(plane);

        return (created ? "Plane was created!" : "Plane creation was failed!");
        /*If plane was created, then first statement will be shown, if no, second.*/
    }

    public String getPlane(int id) { /*getting plane by id he has*/
        Plane plane = repo3.getPlane(id);
        return (plane == null ? "Plane was not found!" : plane.toString());
        /*If Plane has no value, then it's not found, otherwise it will give values from toString*/
    }

    public String getAllPlanes() { /*getting all planes that organization can have*/
        List<Plane> planes = repo3.getAllPlanes();
        /*Plane array*/
        return planes.toString(); /*returning the planes*/
    }

}
