package infnet.gontijo.petfriendtp3.event;

import infnet.gontijo.petfriendtp3.domain.Estado;

public class PedidoAguardandoPagamento extends BaseEvent<String> {

    public final Estado estado;

    public PedidoAguardandoPagamento(String id, Estado estado) {
        super(id);
        this.estado = estado;
    }
}
