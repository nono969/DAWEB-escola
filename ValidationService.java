package br.edu.ifpb.escola.business.service;

import br.edu.ifpb.escola.business.dto.DisciplinaDTO;
import br.edu.ifpb.escola.business.dto.EstudanteDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationService {

    public List<String> validarEstudante(EstudanteDTO dto) {
        List<String> erros = new ArrayList<>();
        if (dto == null) {
            erros.add("Estudante não pode ser nulo");
            return erros;
        }
        if (dto.getMatricula() <= 0) erros.add("Matrícula deve ser positiva");
        if (dto.getNome() == null || dto.getNome().trim().isEmpty())
            erros.add("Nome é obrigatório");
        else if (dto.getNome().trim().length() < 3)
            erros.add("Nome deve ter pelo menos 3 caracteres");
        if (dto.getIdade() < 6) erros.add("Idade mínima é 6 anos");
        else if (dto.getIdade() > 120) erros.add("Idade máxima é 120 anos");
        if (dto.getContato() == null || dto.getContato().trim().isEmpty())
            erros.add("Contato é obrigatório");
        return erros;
    }

    public List<String> validarDisciplina(DisciplinaDTO dto) {
        List<String> erros = new ArrayList<>();
        if (dto == null) {
            erros.add("Disciplina não pode ser nula");
            return erros;
        }
        if (dto.getCod() <= 0) erros.add("Código deve ser positivo");
        if (dto.getNome() == null || dto.getNome().trim().isEmpty())
            erros.add("Nome da disciplina é obrigatório");
        else if (dto.getNome().trim().length() < 3)
            erros.add("Nome deve ter pelo menos 3 caracteres");
        if (dto.getProfessor() == null || dto.getProfessor().trim().isEmpty())
            erros.add("Professor é obrigatório");
        else if (dto.getProfessor().trim().length() < 3)
            erros.add("Nome do professor deve ter pelo menos 3 caracteres");
        if (dto.getCargaHoraria() == null || dto.getCargaHoraria().trim().isEmpty())
            erros.add("Carga horária é obrigatória");
        return erros;
    }

    public boolean isEstudanteValido(EstudanteDTO dto, PrinterService printer) {
        List<String> erros = validarEstudante(dto);
        if (!erros.isEmpty()) {
            erros.forEach(printer::erro);
            return false;
        }
        return true;
    }

    public boolean isDisciplinaValida(DisciplinaDTO dto, PrinterService printer) {
        List<String> erros = validarDisciplina(dto);
        if (!erros.isEmpty()) {
            erros.forEach(printer::erro);
            return false;
        }
        return true;
    }
}
