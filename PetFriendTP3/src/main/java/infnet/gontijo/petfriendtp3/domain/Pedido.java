package infnet.gontijo.petfriendtp3.domain;

import infnet.gontijo.petfriendtp3.command.CriarPedidoCommand;
import infnet.gontijo.petfriendtp3.event.PedidoAguardandoPagamento;
import infnet.gontijo.petfriendtp3.event.PedidoCriado;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Entity
public class Pedido {

    @AggregateIdentifier
    @Id
    private String id;
    private String produto;
    private int quantidade;
    private double valor;
    private String estado;

    public Pedido(){}

    @CommandHandler
    public Pedido(CriarPedidoCommand comando){
        AggregateLifecycle.apply(new PedidoCriado(comando.id, comando.produto, comando.quantidade, comando.valor));
    }

    @EventSourcingHandler
    protected void on(PedidoCriado evento) {
        this.id = evento.id;
        this.produto = evento.produto;;
        this.quantidade = evento.quantidade;
        this.valor = evento.valor;
        this.estado = String.valueOf(Estado.CRIADO);

        AggregateLifecycle.apply(new PedidoAguardandoPagamento(this.id, Estado.AGUARDANDO));
    }

    @EventSourcingHandler
    protected void on(PedidoAguardandoPagamento evento) {
        this.estado = String.valueOf(evento.estado);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
