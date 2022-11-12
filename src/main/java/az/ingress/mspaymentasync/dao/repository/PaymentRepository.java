package az.ingress.mspaymentasync.dao.repository;

import az.ingress.mspaymentasync.dao.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {
}
