package infnet.gontijo.petfriendtp3.service.impl;

import infnet.gontijo.petfriendtp3.command.CriarPedidoCommand;
import infnet.gontijo.petfriendtp3.domain.Pedido;
import infnet.gontijo.petfriendtp3.service.PedidoCommandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@Service
public class PedidoCommandServiceImpl implements PedidoCommandService {

    @Autowired
    private final CommandGateway commandGateway;

    public PedidoCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> fazerPedido(Pedido pedido){
        return commandGateway.send(new CriarPedidoCommand(
                UUID.randomUUID().toString(),
                pedido.getProduto(),
                pedido.getQuantidade(),
                pedido.getValor()));
    }
}