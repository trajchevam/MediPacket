package dians.finki.ukim.mk.lab.service;

import dians.finki.ukim.mk.lab.model.Pharmacy;

import java.util.List;

public interface PharmacyService {

    List<Pharmacy> listAll();

    Pharmacy findById(Long id);


}
