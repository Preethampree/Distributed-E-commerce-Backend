package com.example.E_User_Service.Repository;

import com.example.E_User_Service.Entity.Usere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Repositoryu extends JpaRepository<Usere,Long> {

    Optional<Usere> findByEmail(String email);
}
