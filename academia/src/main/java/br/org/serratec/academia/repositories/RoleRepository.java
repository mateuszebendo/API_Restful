package br.org.serratec.academia.repositories;

import br.org.serratec.academia.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
