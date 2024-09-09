package infnet.gontijo.petfriendtp3.service.impl;
import infnet.gontijo.petfriendtp3.domain.Pedido;
import infnet.gontijo.petfriendtp3.infra.PedidoRepository;
import infnet.gontijo.petfriendtp3.service.PedidoQueryService;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoQueryServiceImpl implements PedidoQueryService {

    private final EventStore eventStore;
    private final PedidoRepository pedidoRepository;

    public PedidoQueryServiceImpl (EventStore eventStore, PedidoRepository pedidoRepository) {
        this.eventStore = eventStore;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Object> listarEventos(String id) {
        List<Object> listaEventos = eventStore.readEvents(id, 0)
                .asStream()
                .map(record -> record.getPayload()).collect(Collectors.toList());
        return listaEventos;
    }

    @Override
    public Optional<Pedido> pedidoPorId(String id) {
        return pedidoRepository.findById(id);
    }
}
