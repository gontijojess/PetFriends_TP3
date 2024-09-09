package infnet.gontijo.petfriendtp3.command;

public class CriarPedidoCommand extends BaseCommand<String> {

    public final String produto;
    public final int quantidade;
    public final double valor;

    public CriarPedidoCommand(String id, String produto, int quantidade, double valor){
        super(id);
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
