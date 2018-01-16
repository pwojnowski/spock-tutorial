package com.farenda.spock

import spock.lang.Specification

class MockThrowExceptionTest extends Specification {

    // an interface with two methods: exists(user), add(user)
    def userService = Mock(UserService)

    // a controller to test, that will use mock of the service:
    def controller = new UserController(userService: userService)

    def 'should throw exception for invalid username'() {
        given:
        def username = 'Joffrey Baratheon'

        userService.exists(_ as User) >> false
        userService.add(_ as User) >> { User user ->
            throw new IllegalArgumentException(user.name)
        }

        when:
        controller.addUser(username)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == username
    }
}