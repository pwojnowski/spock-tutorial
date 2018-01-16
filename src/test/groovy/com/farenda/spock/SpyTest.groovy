package com.farenda.spock

import spock.lang.Shared
import spock.lang.Specification

import static com.farenda.spock.ProcessorFactory.Strategy.*

class SpyTest extends Specification {

    @Shared def multicastProcessor = Mock(Processor)
    @Shared def roundRobinProcessor = Mock(Processor)
    @Shared def selectingProcessor = Mock(Processor)

    @Shared def endpoints = ['direct:x', 'direct:y']

    def factory = Spy(ProcessorFactory, constructorArgs: [endpoints]) {
        createMulticastProcessor(endpoints) >> multicastProcessor
    }

    def setup() {
        factory.createRoundRobinProcessor(endpoints) >> roundRobinProcessor
    }

    def 'should create selected processor'() {
        given:
        factory.createSelectorProcessor(endpoints) >> selectingProcessor

        when:
        def processor = factory.create(strategy)

        then:
        processor == expectedProcessor

        where:
        strategy    | expectedProcessor
        MULTICAST   | multicastProcessor
        ROUND_ROBIN | roundRobinProcessor
        SELECTOR    | selectingProcessor
    }

}