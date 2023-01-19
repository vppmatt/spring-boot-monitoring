package com.multicode.payments.service;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MemoryProblemService {

    private List<UUID> uuids = new ArrayList<>();
    private Gauge uuidsSize;

    public MemoryProblemService(MeterRegistry registry) {
        this.uuidsSize = Gauge
                .builder("uuidsSize", () -> uuids.size())
                .register(registry);
    }

    public Integer size() {
        return uuids.size();
    }

    @Scheduled(fixedRate = 500)
    private void generateUUIDs() {
        uuids.add(UUID.randomUUID());
    }
}
