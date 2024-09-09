package infnet.gontijo.petfriendtp3.controller;

import infnet.gontijo.petfriendtp3.domain.Pedido;
import infnet.gontijo.petfriendtp3.service.PedidoCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value= "/pedidos")
public class PedidoCommandController {

    private final PedidoCommandService service;

    public PedidoCommandController(PedidoCommandService service) {
        this.service = service;
    }

    @PostMapping
    public CompletableFuture<String> realizarPedido(@RequestBody Pedido pedido) {
        return service.fazerPedido(pedido);
    }
}
