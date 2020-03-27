package socialnetwork.core;

import socialnetwork.infraestructure.Console;

public class Post {
    private String postMessage;

    public Post(String postMessage) {
        this.postMessage = postMessage;
    }

    public void print(Console console) {
        console.printLine(postMessage);
    }
}
