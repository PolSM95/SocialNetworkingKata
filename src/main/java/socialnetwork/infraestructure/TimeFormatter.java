package socialnetwork.infraestructure;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeFormatter {


    public String giveFormat(Date postCreationDate){
        Date actualTime = new Date();
        long amountTime = (actualTime.getTime() - postCreationDate.getTime());
        if(TimeUnit.MILLISECONDS.toDays(amountTime) > 0){
            if (TimeUnit.MILLISECONDS.toDays(amountTime) >= 30){
                if (TimeUnit.MILLISECONDS.toDays(amountTime) >= 365){
                    return " "+(TimeUnit.MILLISECONDS.toDays(amountTime)/365) +" years ago";
                }
                return " "+(TimeUnit.MILLISECONDS.toDays(amountTime)/30) +" months ago";
            }
            return " "+TimeUnit.MILLISECONDS.toDays(amountTime)+" days ago";
        }
        if(TimeUnit.MILLISECONDS.toHours(amountTime) > 0){
            return " "+TimeUnit.MILLISECONDS.toHours(amountTime)+" hours ago";
        }
        if(TimeUnit.MILLISECONDS.toMinutes(amountTime) > 0){
            return " "+TimeUnit.MILLISECONDS.toMinutes(amountTime)+" minutes ago";
        }
        return " "+TimeUnit.MILLISECONDS.toSeconds(amountTime)+" seconds ago";
    }
}
