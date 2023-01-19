package com.multicode.payments.actuator;

import com.multicode.payments.data.CreditCardTransactionRepository;
import io.micrometer.core.instrument.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class CustomMetrics {

    private Counter numberOfTransactionsAddedSinceApplicationStart;
    private Gauge numberOfTransactionsAddedInLast2Years;
    private Timer getAllRecordsTimer;

    @Autowired
    CreditCardTransactionRepository repository;

    @Autowired
    MeterRegistry meterRegistry;

    @PostConstruct
    public void setup() {
        numberOfTransactionsAddedSinceApplicationStart = meterRegistry.counter("transactions.sinceStart");
        numberOfTransactionsAddedInLast2Years =
                Gauge.builder("transactions.2years", () -> getNumberOfRecordsInLast2Years())
                        .register(meterRegistry);
        getAllRecordsTimer = Timer.builder("transactions.allrecstimer").register(meterRegistry);
        getAllRecordsTimer.record( () -> {
            repository.findAll();
        });
    }

    public void recordNewTransaction() {
        numberOfTransactionsAddedSinceApplicationStart.increment();
        getAllRecordsTimer.record( () -> {
            repository.findAll();
        });
    }

    public Integer getNumberOfRecordsInLast2Years() {
        LocalDate cutOff = LocalDate.now().minusYears(2);
        System.out.println(cutOff);
        System.out.println(repository.findAllByDateAfter(cutOff).size());
        return repository.findAllByDateAfter(cutOff).size();
    }

}
