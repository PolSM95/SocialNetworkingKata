package socialnetwork.core;

import socialnetwork.infraestructure.Console;
import socialnetwork.infraestructure.TimeFormatter;

import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Post implements Comparable{
    private String postMessage;
    private String name;
    private TimeFormatter timeFormatter;
    private Date creationDate;

    public Post(String postMessage, String name, TimeFormatter timeFormatter) {
        this.postMessage = postMessage;
        this.name = name;
        this.timeFormatter = timeFormatter;
        this.creationDate = new Date();
    }

    public void printPost(Console console) {
        console.printLine(postMessage + timeFormatter.giveFormat(creationDate));
    }
    public void printPostWall(Console console) {
        console.printLine(name + " - " + postMessage + timeFormatter.giveFormat(creationDate));
    }

    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public int compareTo(Object post) {
        return ((Post) post).getCreationDate().compareTo(getCreationDate());
    }
}
