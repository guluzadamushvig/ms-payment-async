package az.ingress.mspaymentasync.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentRequest {
    private BigDecimal amount;
    private String description;
    private Long card_number;
    private String cardholder;
}
