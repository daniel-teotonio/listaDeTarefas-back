package danielTeotonio.listaDeTarefas.repository;

import danielTeotonio.listaDeTarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
