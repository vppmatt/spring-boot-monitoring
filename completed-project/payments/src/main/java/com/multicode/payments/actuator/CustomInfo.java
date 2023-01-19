package com.multicode.payments.actuator;

import com.multicode.payments.data.CreditCardTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.info.JavaInfo;
import org.springframework.stereotype.Component;

@Component
public class CustomInfo implements InfoContributor {

    @Autowired
    CreditCardTransactionRepository repository;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("Spring Boot version", SpringBootVersion.getVersion());
        builder.withDetail("Java version", new JavaInfo().getVersion());
        builder.withDetail("JVM version", new JavaInfo().getRuntime().getVersion());
        builder.withDetail("number of payments in db", repository.count());
    }
}
