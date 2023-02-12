package dians.finki.ukim.mk.lab.service.impl;

import dians.finki.ukim.mk.lab.model.Pharmacy;
import dians.finki.ukim.mk.lab.repository.PharmacyRepository;
import dians.finki.ukim.mk.lab.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }


    @Override
    public List<Pharmacy> listAll() {
        return this.pharmacyRepository.findAll().stream().sorted((r1, r2)->
                r1.getId().compareTo(r2.getId())).collect(Collectors.toList());
    }

    @Override
    public Pharmacy findById(Long id) {
        return this.pharmacyRepository.findPharmacyById(id);
    }
}
