package cptu.egp.event.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "alumni", schema = "csekuaa")
public class Alumni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumni_id", nullable = false)
    private Integer id;

    @Size(max = 10)
    @NotNull
    @Column(name = "roll", nullable = false, length = 10)
    private String roll;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 100)
    @Column(name = "nick", length = 100)
    private String nick;

    @Column(name = "birth_date")
    private Instant birthDate;

    @Size(max = 10)
    @Column(name = "blood_group", length = 10)
    private String bloodGroup;

    @Size(max = 255)
    @Column(name = "photo")
    private String photo;

    @Size(max = 200)
    @Column(name = "present_address", length = 200)
    private String presentAddress;

    @Size(max = 200)
    @Column(name = "permanent_address", length = 200)
    private String permanentAddress;

    @Size(max = 45)
    @Column(name = "phone", length = 45)
    private String phone;

    @Size(max = 100)
    @NotNull
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Size(max = 100)
    @Column(name = "profession", length = 100)
    private String profession;

    @Size(max = 100)
    @Column(name = "designation", length = 100)
    private String designation;

    @Size(max = 50)
    @Column(name = "company", length = 50)
    private String company;

    @Size(max = 200)
    @Column(name = "company_address", length = 200)
    private String companyAddress;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "creation_time")
    private Instant creationTime;

    @Column(name = "modified_time")
    private Instant modifiedTime;

    @Column(name = "approval_date")
    private LocalDate approvalDate;

    @Column(name = "membership_type")
    private Integer membershipType;

}