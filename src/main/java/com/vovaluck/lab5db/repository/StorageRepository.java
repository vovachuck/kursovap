package com.vovaluck.lab5db.repository;


import com.vovaluck.lab5db.model.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<Storage,Integer> {

}
