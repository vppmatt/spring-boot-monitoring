package com.multicode.payments.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;

import com.multicode.payments.data.CreditCardTransactionRepository;
import com.multicode.payments.domain.CreditCardTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BoostrapService {

    @Autowired
    CreditCardTransactionRepository repository;

    @PostConstruct
    public void initData() throws IOException {
        if (repository.count() == 0) {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("data.txt").getFile());
            Path path = Paths.get(file.toURI());
            Files.lines(path).forEach(line -> {
                String[] fields = line.replaceAll(" ","").split(",");
                CreditCardTransaction creditCardTransaction =
                        new CreditCardTransaction(
                                Integer.parseInt(fields[0].replace("(","")),
                                Double.parseDouble(fields[1]),
                                fields[2].replace("\"","").toLowerCase(),
                                fields[3].replace("\"",""),
                                LocalDate.parse(fields[4].replace("\"","")),
                                fields[5].replace("\"",""),
                                Integer.parseInt(fields[6]),
                                Double.parseDouble(fields[7]),
                                fields[8].replace("\"","").replace(")",""));
                repository.save(creditCardTransaction);
            });


        }
    }

}