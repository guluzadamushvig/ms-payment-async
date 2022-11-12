package az.ingress.mspaymentasync.service;

import az.ingress.mspaymentasync.client.CardClient;
import az.ingress.mspaymentasync.dao.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import az.ingress.mspaymentasync.mapper.PaymentMapper;
import az.ingress.mspaymentasync.model.PaymentRequest;
import az.ingress.mspaymentasync.model.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.ingress.mspaymentasync.mapper.PaymentMapper.PaymentRequestToCardsDto;
import static az.ingress.mspaymentasync.mapper.PaymentMapper.PaymentRequestToPaymentEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;

    private  final CardClient cardClient;

    public List<PaymentResponse> getPayments(){
        log.info("ActionLog.SavePayment.Started");
        var payments = paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::PaymentEntityToPaymentResponse)
                .collect(Collectors.toList());
        log.info("ActionLog.SavePayment.Finished");
        return payments;
    }

    public void savePayment(PaymentRequest paymentRequest) {
        log.info("ActionLog.SavePayment.Started");
        paymentRepository.save(PaymentRequestToPaymentEntity(paymentRequest));
        log.info("ActionLog.CallMSCard.Started");
        cardClient.saveCardTransaction(PaymentRequestToCardsDto(paymentRequest));
        log.info("ActionLog.CallMSCard.Finished");
        log.info("ActionLog.SavePayment.Finished");
    }
}
