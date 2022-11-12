package az.ingress.mspaymentasync.controller;

import lombok.RequiredArgsConstructor;
import az.ingress.mspaymentasync.model.PaymentRequest;
import az.ingress.mspaymentasync.model.PaymentResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import az.ingress.mspaymentasync.service.PaymentService;

import java.util.List;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/v1/payments")
    public class PaymentController {

        private final PaymentService paymentService;

        @PostMapping()
        @ResponseStatus(HttpStatus.CREATED)
        public void savePayment(@RequestBody PaymentRequest paymentRequest){
            paymentService.savePayment(paymentRequest);
        }

        @GetMapping
        public List<PaymentResponse> getPayments (){
            return paymentService.getPayments();
        }
    }

