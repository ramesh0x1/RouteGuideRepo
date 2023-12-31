package routeGuide.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import routeGuide.Enum.UserRole;
import routeGuide.entities.Carrier;
import routeGuide.entities.Load;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Integer> {


    @Query(value = "SELECT * FROM carriers WHERE code = :carrierCode", nativeQuery = true)
    Carrier findByCode(@Param("carrierCode") String carrierCode);

    List<Carrier> findByUserName(String userName);

    Carrier findByContactEmail(String contactEmail);

    List<Carrier> findByRole(UserRole userRole);
}
