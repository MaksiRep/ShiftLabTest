package ru.maksirep.shop_shift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maksirep.shop_shift.model.Technics;

import java.util.List;

@Repository
public interface TechnicsRepository extends JpaRepository <Technics, Integer> {

    Technics getBySerialID (Integer serialId);

    void deleteBySerialID (Integer serialId);

    List<Technics> findAllByOrderBySerialIDDesc ();
}
