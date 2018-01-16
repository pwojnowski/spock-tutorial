package com.farenda.spock

import spock.lang.Specification

class ThisIsSpockSpec extends Specification {

    def 'should find absolute value'() {
        println('This is a Spock Spec!')

        expect:
        Math.abs(-42) == 42
    }
}
