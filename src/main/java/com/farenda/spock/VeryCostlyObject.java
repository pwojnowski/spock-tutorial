package com.farenda.spock;

public class VeryCostlyObject {

    public VeryCostlyObject() {
        System.out.println("Instantiating very costly object...");
        System.out.println("...5 minutes later ;-)");
        System.out.println("Done!");
    }

    public void close() {
        System.out.println("Close method called!");
    }

    public void dispose() {
        System.out.println("Dispose method called!");
    }

    public void exceptional() {
        System.out.println("Exceptional method called!");
        throw new RuntimeException("Cannot close the resource.");
    }

    public void anotherExceptional() {
        System.out.println("Another exceptional method called!");
        throw new RuntimeException("Cannot close the resource.");
    }
}
