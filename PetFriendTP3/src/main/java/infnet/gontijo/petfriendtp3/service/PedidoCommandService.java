package infnet.gontijo.petfriendtp3.service;

import infnet.gontijo.petfriendtp3.domain.Pedido;
import java.util.concurrent.CompletableFuture;

public interface PedidoCommandService {
    public CompletableFuture<String> fazerPedido(Pedido pedido);

}
