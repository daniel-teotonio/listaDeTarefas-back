package danielTeotonio.listaDeTarefas.controller.dto.mapper;

import danielTeotonio.listaDeTarefas.controller.dto.request.TarefaRequest;
import danielTeotonio.listaDeTarefas.domain.Tarefa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {
    Tarefa toTarefa(TarefaRequest request);
}
