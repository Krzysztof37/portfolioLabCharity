package pl.coderslab.charity.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query(value = "select sum(quantity) from donation", nativeQuery = true)
    Integer SumOfBag();



}
