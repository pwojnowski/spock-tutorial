package com.farenda.spock

import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.See
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Title('This test will test documenting features of Spock Framework')
@Narrative('''
As a Developer using Spock Framework for testing,
I want to be see Specifications documented,
so that my Business Analyst understand what is this all about.
''')
class DocumentingSpecTest extends Specification {

    // this one is System Under Test:
    @Subject controller = new UserController()

    @See('http://farenda.com/spock-framework-tutorial')
    def 'should have controller'() {
        expect:
        controller != null

        and: 'comments can be put here'
        controller.userService == null
    }

    @Issue('http://issues.farenda.com/PROJ-42')
    def 'should fix known math issue'() {
        expect:
        2 + 2 == 4
    }
}