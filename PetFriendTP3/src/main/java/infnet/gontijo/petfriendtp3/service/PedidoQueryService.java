package infnet.gontijo.petfriendtp3.service;

import infnet.gontijo.petfriendtp3.domain.Pedido;
import infnet.gontijo.petfriendtp3.service.impl.PedidoQueryServiceImpl;

import java.util.List;
import java.util.Optional;

public interface PedidoQueryService {
    List<Object> listarEventos(String id);

    Optional<Pedido> pedidoPorId(String id);
}
