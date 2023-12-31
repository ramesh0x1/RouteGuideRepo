package routeGuide.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import routeGuide.DTO.UpdateCarrierDTO;
import routeGuide.Enum.UserRole;

@Data
@Entity
@Table(name="carriers")
@NoArgsConstructor
@AllArgsConstructor
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    @Column(unique = true)
    private String code;

    private String contactEmail;


    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;


    public Carrier(UpdateCarrierDTO updateCarrierDTO) {
        if(updateCarrierDTO.getCarrierName()==null) {
            this.userName = updateCarrierDTO.getCarrierName();
        }
        if(updateCarrierDTO.getCarrierCode()==null) {
            this.code = updateCarrierDTO.getCarrierCode();
        }
        if(updateCarrierDTO.getContactEmail()==null) {
            this.contactEmail = updateCarrierDTO.getContactEmail();
        }
    }


}
