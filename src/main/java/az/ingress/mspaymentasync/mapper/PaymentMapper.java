package az.ingress.mspaymentasync.mapper;

import az.ingress.mspaymentasync.dao.entity.PaymentEntity;
import az.ingress.mspaymentasync.model.PaymentRequest;
import az.ingress.mspaymentasync.model.PaymentResponse;
import az.ingress.mspaymentasync.model.client.CardsDto;

import java.time.LocalDateTime;

public class PaymentMapper {
    public static PaymentResponse PaymentEntityToPaymentResponse
            (PaymentEntity paymentEntity){
        return PaymentResponse.builder()
                .amount(paymentEntity.getAmount())
                .description(paymentEntity.getDescription())
                .createdAt(paymentEntity.getCreatedAt())
                .build();
    }

    public static PaymentEntity PaymentRequestToPaymentEntity
            (PaymentRequest paymentRequest){
        return PaymentEntity.builder()
                .amount(paymentRequest.getAmount())
                .description(paymentRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .card_number(paymentRequest.getCard_number())
                .cardholder(paymentRequest.getCardholder())
                .build();
    }

    public static CardsDto PaymentRequestToCardsDto
            (PaymentRequest paymentRequest){
        return CardsDto.builder()
                .amount(paymentRequest.getAmount())
                .card_number(paymentRequest.getCard_number())
                .cardholder(paymentRequest.getCardholder())
                .last_transaction_date(LocalDateTime.now())
                .build();
    }
}
