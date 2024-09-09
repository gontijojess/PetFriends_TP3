package infnet.gontijo.petfriendtp3.controller;

import infnet.gontijo.petfriendtp3.domain.Pedido;
import infnet.gontijo.petfriendtp3.service.PedidoQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService service;

    public PedidoQueryController(PedidoQueryService service){
        this.service = service;
    }

    @GetMapping("/{id}/evento")
    public List<Object> listarEventos (@PathVariable(value="id") String id) {
        return service.listarEventos(id);
    }

    @GetMapping("/{id}")
    public Pedido pedidoPorId (@PathVariable(value="id") String id) {
        return service.pedidoPorId(id).get();
    }
}
