package com.farenda.spock

import spock.lang.Specification

class BasicMocksTest extends Specification {

    // Creating Mock is simple as that:
    def userService = Mock(UserService)

    // This will also work, but I prefer the former version:
    // def UserService anotherService = Mock()

    // In Groovy you can call setter like this:
    def restController = new UserController(userService: userService)

    def 'should not add existing users'() {
        given:
        // For any User passed as parameter return "true" from Mock
        // We don't specify how many times we expect it to be called,
        // because we don't care in this test:
        userService.exists(_ as User) >> true

        when:
        restController.addUser('Jon Snow')

        then:
        // "n * method()" means "expect _exactly_ n calls of method()"
        // Change 0 to some other value and see what is happens!
        0 * userService.add(_ as User)
    }

    def 'should add a new user'() {
        given:
        // The first call to "exists" will return "false",
        // all subsequent calls will return "true":
        userService.exists(_ as User) >>> [false, true]

        when:
        restController.addUser('Jon Snow')

        then:
        1 * userService.add(_ as User) >> {
            // This way we've got access to params in a closure:
            User user ->
            // Asserts are implicit only in "then" and "expect" blocks
            // so here we have to use it explicitly:
            assert user.name == 'Jon Snow'
        }

        when:
        restController.addUser('Ramsay Snow')

        then:
        0 * userService.add(_ as User)
    }
}