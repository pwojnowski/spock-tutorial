package com.farenda.spock

import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.Requires
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths

//@Ignore, @IgnoreIf, @Requires can be on whole Spec too!
class IgnoringTestsInSpockTest extends Specification {

    // The reason is optional, but a good practice:
    @Ignore('Have to verify equation with BA')
    def 'should not execute no matter what'() {
        expect:
        Math.pow(2, 2) == 5
    }

    // @IgnoreIf( true is returned )
    @IgnoreIf({ System.getProperty('os.name').contains('windows') })
    def 'should not run on Windows'() {
        expect:
        Files.exists(Paths.get('/tmp'))
    }

    // using builtin "os" - info about operating system
    // see: spock.util.environment.OperatingSystem
    @IgnoreIf({ os.linux })
    def 'should not run on Linux - shorter version'() {
        expect:
        Files.exists(Paths.get('c://windows'))
    }

    // @Requires is oposite to @IgnoreIf, so runs when condition holds
    // see: spock.util.environment.OperatingSystem
    @Requires({ os.linux })
    def 'should run only on Linux - shorter version'() {
        expect:
        Files.exists(Paths.get('/tmp'))
    }

    // using builtin "sys" - a map of system properties
    // see: https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
    @IgnoreIf({ sys['user.name'] != 'Spock' })
    def 'should not run when user is not "Spock"'() {
        expect:
        Files.exists(Paths.get('/home/Spock'))
    }

    // using builtin "env" - a map of environment variables
    @IgnoreIf({ env.HOME != '/home/Spock' })
    def 'should not run when user home dir is different'() {
        expect:
        Files.exists(Paths.get('/home/Spock'))
    }

    // using builtin "jvm" - info about JVM
    // see: spock.util.environment.Jvm
    @IgnoreIf({ !jvm.java8Compatible })
    def 'should run only when JDK is compatible with Java 8'() {
        expect:
        System.properties['java.version'] == '1.8.0_66'
    }
}