package com.farenda.spock;

import java.util.List;

public class ProcessorFactory {

    private List<String> endpoints;

    enum Strategy {
        MULTICAST, ROUND_ROBIN, SELECTOR
    }

    public ProcessorFactory(List<String> endpoints) {
        this.endpoints = endpoints;
    }

    public Processor create(Strategy strategy) {
        switch(strategy) {
            case MULTICAST:
                return createMulticastProcessor(endpoints);
            case ROUND_ROBIN:
                return createRoundRobinProcessor(endpoints);
            case SELECTOR:
                return createSelectorProcessor(endpoints);
        }
        throw new IllegalArgumentException("Unknown strategy: " + strategy);
    }

    Processor createSelectorProcessor(List<String> endpoints) {
        return null;
    }

    Processor createRoundRobinProcessor(List<String> endpoints) {
        return null;
    }

    Processor createMulticastProcessor(List<String> endpoints) {
        return null;
    }
}
