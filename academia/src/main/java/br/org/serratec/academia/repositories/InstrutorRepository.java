package br.org.serratec.academia.repositories;

import br.org.serratec.academia.entities.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrutorRepository extends JpaRepository<Instrutor, Integer> {
}
