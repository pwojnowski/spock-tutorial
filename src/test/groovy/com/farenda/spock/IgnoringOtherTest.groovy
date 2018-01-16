package com.farenda.spock

import spock.lang.IgnoreRest
import spock.lang.Specification

class IgnoringOtherTest extends Specification {

    def 'this one will not run'() {
        expect:
        Math.abs(-1) == -1
    }

    @IgnoreRest
    def 'this one will run'() {
        expect:
        Math.sin(0) == 0
    }

    def 'this one will be ignored too'() {
        expect:
        Math.pow(2, 2) == 3
    }
}