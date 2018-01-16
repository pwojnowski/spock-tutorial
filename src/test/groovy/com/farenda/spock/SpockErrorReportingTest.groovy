package com.farenda.spock

import spock.lang.Specification
import spock.lang.Unroll

// @Unroll can be on class level here too!
// It then acts on each test that doesn't have @Unroll already.
class SpockErrorReportingTest extends Specification {

    def 'should select max of two numbers'() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        9 | 9 | 9
    }

    // @Unroll with format inside test name:
    @Unroll
    def 'in feature: max of #a and #b should be #c'() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        9 | 9 | 9
    }

    // @Unroll with format as annotation's parameter:
    @Unroll('in unroll: max of #a and #b should be #c')
    def 'a b c'() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        9 | 9 | 8
    }

    @Unroll('the sum is: #theSum')
    def 'theSum test'() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        5 | 1 | 5
        9 | 9 | 8

        theSum = a + b + c
    }
}
