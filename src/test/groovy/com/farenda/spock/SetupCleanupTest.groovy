package com.farenda.spock

import spock.lang.Specification

class SetupCleanupTest extends Specification {

    // Will be initialized each time in setup()
    def List<String> cities

    def setup() {
        println('Setting up test data...')
        cities = ['Braavos', 'Volantis', 'Pentos']
    }

    def cleanup() {
        println('Cleaning up after a test!')
    }

    // Creating objects at the top level works like setup() method
    // and is performed before each test feature.
    // Here we create a closure and execute it immediately
    // to return a list and assign:
    def list = { println('setting up a list...'); return [1, 2, 3] }()

    def 'should remove Volantis'() {
        expect:
        list == [1, 2 , 3]

        when:
        cities.remove('Volantis')

        then:
        cities == ['Braavos', 'Pentos']
    }

    def 'should add Meereen'() {
        when:
        cities << 'Meereen'

        then:
        cities == ['Braavos', 'Volantis', 'Pentos', 'Meereen']
    }
}