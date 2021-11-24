package pl.coderslab.charity.utils.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {


    Page<Donation> findAllByReceived(Integer received, Pageable pageable);

    @Query(value = "select sum(quantity) from donation", nativeQuery = true)
    Integer SumOfBag();

    @Modifying
    @Transactional
    @Query(value = "update Donation b set b.received = 1 where b.id = ?1")
    void archiveDonation(Long id);

}
