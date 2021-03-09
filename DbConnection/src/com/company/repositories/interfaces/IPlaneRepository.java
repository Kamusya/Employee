package com.company.repositories.interfaces;

import com.company.entities.Plane;

import java.util.List;

public interface IPlaneRepository { /*I means Interface*/
    boolean createPlane(Plane plane);
    Plane getPlane(int id);
    List<Plane> getAllPlanes();
    String getNameById(int id) ;
}