package socialnetwork.core;

import socialnetwork.infraestructure.Console;

public class Post {
    private String postMessage;
    private String name;

    public Post(String postMessage, String name) {
        this.postMessage = postMessage;
        this.name = name;
    }

    public void print(Console console) {
        console.printLine(postMessage);
    }
    public void printWallFormat(Console console) {
        console.printLine(name+" - "+postMessage);
    }
}
