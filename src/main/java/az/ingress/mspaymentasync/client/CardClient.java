package az.ingress.mspaymentasync.client;

import az.ingress.mspaymentasync.model.client.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-cards",url = "http://localhost:8082")
public interface CardClient {
    @PostMapping("/v1/cards")
    @Async
    void saveCardTransaction(@RequestBody CardsDto cardsDto);
}
