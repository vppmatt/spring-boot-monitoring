package com.multicode.payments.data;

import com.multicode.payments.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.time.LocalDate;
import java.util.*;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer> {

    public List<CreditCardTransaction> findAllByOrderId(String orderId);
    public List<CreditCardTransaction> findAllByCountry(String country);

    List<CreditCardTransaction> findAllByDateAfter(LocalDate cutOff);
}
