package infnet.gontijo.petfriendtp3.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ItemPedido {
    @Id
    private String id;
    private String produtoId;
    private int quantidade;
    private double valor;
    private String estado;
}
