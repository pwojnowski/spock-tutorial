package com.farenda.spock

import spock.lang.Shared
import spock.lang.Specification

class BeforeAfterSpecTest extends Specification {

    // Must be @Shared or static!
    def @Shared VeryCostlyObject heavy

    // Run before all the tests:
    def setupSpec() {
        println("Heavy init for all the tests...")
        heavy = new VeryCostlyObject()
        println("Initialization done!")
    }

    // Run after all the tests, even after failures:
    def cleanupSpec() {
        println("Cleanup after all tests!")
    }

    def 'should create a range of 5 elements'() {
        println('Inside the range test.')
        expect:
        (1..5).size() == 5
    }

    def 'should count items in list'() {
        println('(mis)counting items in a list test')
        expect:
        [1, 2, 3].size() == 4 // lets fail this one!
    }
}