package az.ingress.mspaymentasync.dao.entity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
@Builder
public class PaymentEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name="date")
    private LocalDateTime createdAt;

    @Column(name = "cardholder")
    private String cardholder;

    @Column(name="card_number")
    private Long card_number;

}
