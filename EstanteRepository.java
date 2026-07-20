package br.edu.ifpb.escola.repository;

import br.edu.ifpb.escola.model.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EstanteRepository extends JpaRepository<Estudante, Long> {
    Optional<Estudante> findByMatricula(int matricula);
}
