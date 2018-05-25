package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.GroupTourist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTouristRepository extends JpaRepository<GroupTourist,Integer> {

}
