package com.portfoliocdc.cdc.Security.Repository;

import com.portfoliocdc.cdc.Security.Entity.Rol;
import com.portfoliocdc.cdc.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
