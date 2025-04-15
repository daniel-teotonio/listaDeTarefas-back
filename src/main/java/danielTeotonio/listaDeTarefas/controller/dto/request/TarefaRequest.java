package danielTeotonio.listaDeTarefas.controller.dto.request;

import lombok.Builder;

@Builder
public record TarefaRequest(
        String descricao,
        boolean concluida
) {
}
