package com.farenda.spock

import spock.lang.Specification

class WhereBlocksTest extends Specification {

    def 'should select max of two numbers'() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        9 | 9 | 9
    }

    def 'should sort list of numbers'() {
        given:
        def list = [a, b]

        when:
        def result = list.sort()

        then:
        result == expectedResult

        where:
        a | b | expectedResult
        5 | 1 | [1, 5]
        9 | 9 | [9, 9]
    }

    def 'should compute the maximum of two numbers'() {
        expect:
        Math.max(a, b) == c

        where:
        a << [1, 4]
        b << [2, 3]
        c << [2, 4]
    }
}
