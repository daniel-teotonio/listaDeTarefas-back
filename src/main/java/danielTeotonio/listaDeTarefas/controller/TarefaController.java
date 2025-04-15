package danielTeotonio.listaDeTarefas.controller;


import danielTeotonio.listaDeTarefas.controller.dto.request.TarefaRequest;
import danielTeotonio.listaDeTarefas.domain.Tarefa;
import danielTeotonio.listaDeTarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        System.out.println("Recebendo Tarefa: "+ id);

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarefa criar(@RequestBody TarefaRequest tarefa) {
        System.out.println("Recebendo Tarefa: " + tarefa);
        return service.criar(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody TarefaRequest request) {
        System.out.println("Recebendo Tarefa: "+ request);
        Tarefa tarefa = service.salvar(id, request);
        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        System.out.println("Recebendo Tarefa: "+id);
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

