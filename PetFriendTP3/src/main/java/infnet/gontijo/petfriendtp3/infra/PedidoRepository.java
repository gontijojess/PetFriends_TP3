package infnet.gontijo.petfriendtp3.infra;

import infnet.gontijo.petfriendtp3.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, String > {
}
