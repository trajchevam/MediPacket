package dians.finki.ukim.mk.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Pharmacy {
    @Id
    private String num;

    private String name;

    private String location;

    private String workHours;

    public Pharmacy(String num, String name, String location, String workHours) {
        this.num = num;
        this.location = location;
        this.workHours = workHours;
    }
}
