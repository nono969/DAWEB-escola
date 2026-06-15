package br.edu.ifpb.escola.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpb.escola.model.entity.Disciplina;


public interface EstanteRepository  extends JpaRepository<Disciplina, Long> {

}
