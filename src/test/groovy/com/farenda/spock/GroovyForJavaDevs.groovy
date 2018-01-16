package com.farenda.spock

import javax.xml.parsers.DocumentBuilder as DocBuilder
import javax.xml.parsers.DocumentBuilderFactory as DocFactory

/**
 * Quick intro to Groovy for Java Developers.
 */
class GroovyForJavaDevs {

    public static void main(String[] args) {
        def points = [foo: 1, bar: 2]
        println(points?.baz)
//        usefulFunctions()
//        maps()
//        sets()
//        lists()
//        aliases()
//        casting()
//        optionalClass()
//        strings()
    }

    private static void usefulFunctions() {
        def words = ['Some', 'random', 'string', 'for', 'processing']

        // 'it' is default name of processed element:
        def sizes = words.collectEntries { [(it.toLowerCase()): it.size()] }
        println("sizes: ${sizes}")

        def shorts = words
                .findAll { it.size() <= 4 }
                .collect { word -> word.toLowerCase() }
                .sort()
        println('short words: ' + shorts)

        println('has proc? ' + words.any { it.contains('proc')})
        println('how many? ' + words.count { it.contains('proc')})
    }

    private static void maps() {
        def player = 'baz'
        // [string, quotes may be omitted, name from var]:
        def points = ['foo': 1, bar: 2, (player): 3]
        println(points)

        points.put('baz', 33)
        println(points)

        points['foo'] = 11
        println("foo has ${points.foo} ponits")
    }

    private static void sets() {
        Set numbers = (1..10)
        println("type: ${numbers.class.name}")
        println("set content: ${numbers}")

        def letters = ['a', 'b', 'c'] as Set
        println("type: ${letters.class.name}")
        println("set content: ${letters}")
    }

    private static void lists() {
        def numbers = [1, 2, 3]
        println(numbers)
        println("first: ${numbers.first()}")
        println("at 0: ${numbers[0]}")
        println("at 1: ${numbers[1]}")
        println("1st and 2nd: ${numbers[0, 1]}")
        println("from 1st to 3nd: ${numbers[0..2]}")

        numbers.add(4)
        println(numbers)

        numbers += 5
        println(numbers)

        numbers += [6, 7]
        println(numbers)

        numbers << 8 << 9
        println(numbers)

        // remove range of numbers:
        numbers -= (4..8)
        println(numbers)
    }

    private static void aliases() {
        def factory = DocFactory.newInstance()
        DocBuilder db = factory.newDocumentBuilder()
    }

    private static void casting() {
        def numbers = [1, 2, 3]
        println("Type: ${numbers.class.name}")

        def casted = numbers as Set
        println("Type: ${casted.class.name}")
    }

    private static void optionalClass() {
        println(String.class.name)
        println(String.name)
    }

    private static void strings() {
        // Simple string are within apostrophes '':
        def simpleString = 'String'
        println('Like in Java: ' + simpleString)

        // GString are within quotes "":
        println("GStrings can access vars: ${simpleString.toUpperCase()}")

        // Multiline are within triple ':
        def longString = '''Multiline
    line
string'''
        println(longString)
    }
}
