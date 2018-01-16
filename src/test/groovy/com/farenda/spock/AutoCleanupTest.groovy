package com.farenda.spock

import spock.lang.AutoCleanup
import spock.lang.Specification

class AutoCleanupTest extends Specification {

    @AutoCleanup
    def resource = new VeryCostlyObject()

    @AutoCleanup('dispose')
    def anotherResource = new VeryCostlyObject()

    @AutoCleanup('exceptional')
    def faultyResource = new VeryCostlyObject()

    @AutoCleanup(value = 'anotherExceptional', quiet = true)
    def quiteResource = new VeryCostlyObject()

    def 'should close the resource'() {
        println 'Executing test'
        expect:
        Math.abs(-3) == 3
    }
}