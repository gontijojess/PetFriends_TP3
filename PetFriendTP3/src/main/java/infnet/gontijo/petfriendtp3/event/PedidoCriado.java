package infnet.gontijo.petfriendtp3.event;


public class PedidoCriado extends BaseEvent<String> {

    public final String produto;
    public final int quantidade;
    public final double valor;

    public PedidoCriado(String id, String produto, int quantidade, double valor) {
        super(id);
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
