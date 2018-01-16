package com.farenda.spock

import spock.lang.Specification

class StandardOutPrintTest extends Specification {

    def 'should tell nothing but the true'() {
        println('Inside the test!')
        expect:
        42 == 42
    }
}