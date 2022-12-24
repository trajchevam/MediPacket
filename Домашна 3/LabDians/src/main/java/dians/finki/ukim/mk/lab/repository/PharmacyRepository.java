package dians.finki.ukim.mk.lab.repository;

import dians.finki.ukim.mk.lab.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
    List<Pharmacy> findAll();

    Pharmacy findPharmacyById(Long id);

    Pharmacy findPharmacyByName(String name);

}
