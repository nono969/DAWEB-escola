package br.edu.ifpb.escola.presentation.controller;

import br.edu.ifpb.escola.business.dto.DisciplinaDTO;
import br.edu.ifpb.escola.business.dto.EstudanteDTO;
import br.edu.ifpb.escola.business.service.*;
import br.edu.ifpb.escola.model.entity.Estudante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuPrincipalController {

    @Autowired private PrinterService printer;
    @Autowired private ReaderService reader;
    @Autowired private EstudanteService estudanteService;
    @Autowired private DisciplinaService disciplinaService;

    public void iniciar() {
        int opcao;
        do {
            printer.mostrarMenu();
            opcao = reader.lerInt("");
            switch (opcao) {
                case 1 -> {
                    DisciplinaDTO dto = reader.lerNovaDisciplina();
                    disciplinaService.cadastrar(dto);
                    reader.esperarEnter();
                }
                case 2 -> {
                    EstudanteDTO dto = reader.lerNovoEstudante();
                    estudanteService.cadastrar(dto);
                    reader.esperarEnter();
                }
                case 3 -> {
                    printer.subtitulo("MATRICULAR ESTUDANTE");
                    int mat = reader.lerMatriculaEstudante();
                    Estudante estudante = estudanteService.buscarModelo(mat);
                    if (estudante == null) {
                        reader.esperarEnter();
                        break;
                    }
                    int cod = reader.lerCodigoDisciplina();
                    disciplinaService.matricularEstudante(cod, estudante);
                    reader.esperarEnter();
                }
                case 4 -> {
                    printer.titulo("LISTA COMPLETA");
                    disciplinaService.exibirLista();
                    estudanteService.exibirLista();
                    reader.esperarEnter();
                }
                case 5 -> {
                    printer.subtitulo("EDITAR DISCIPLINA");
                    int cod = reader.lerCodigoDisciplina();
                    DisciplinaDTO dto = disciplinaService.buscar(cod);
                    if (dto == null) { reader.esperarEnter(); break; }
                    printer.imprimirDisciplina(dto);
                    DisciplinaDTO editado = reader.lerEdicaoDisciplina(cod, dto.getNome(), dto.getProfessor(), dto.getCargaHoraria());
                    disciplinaService.editar(editado);
                    reader.esperarEnter();
                }
                case 6 -> {
                    printer.subtitulo("EDITAR ESTUDANTE");
                    int mat = reader.lerMatriculaEstudante();
                    EstudanteDTO dto = estudanteService.buscar(mat);
                    if (dto == null) { reader.esperarEnter(); break; }
                    printer.imprimirEstudante(dto);
                    EstudanteDTO editado = reader.lerEdicaoEstudante(mat, dto.getNome(), dto.getIdade(), dto.getContato());
                    estudanteService.editar(editado);
                    reader.esperarEnter();
                }
                case 7 -> {
                    printer.subtitulo("BUSCAR DISCIPLINA");
                    int cod = reader.lerCodigoDisciplina();
                    disciplinaService.exibirDisciplinaComAlunos(cod);
                    reader.esperarEnter();
                }
                case 8 -> {
                    printer.subtitulo("BUSCAR ESTUDANTE");
                    int mat = reader.lerMatriculaEstudante();
                    estudanteService.exibirEstudante(mat);
                    reader.esperarEnter();
                }
                case 9 -> {
                    printer.titulo("ENCERRANDO");
                    printer.sucesso("Volte sempre!");
                }
                default -> {
                    printer.erro("Opção inválida!");
                    reader.esperarEnter();
                }
            }
        } while (opcao != 9);
        reader.fechar();
    }
}
