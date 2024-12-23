import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type, timeStamp, amount;

    public Transaction(String type, String amount) {

        this.type = type;
        timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.amount = amount;
    }

    public String getType() {

        return type;
    }

    public String getTimeStamp() {

        return timeStamp;
    }

    public String getAmount() {

        return amount;
    }

    public void setTimeStamp(String time) {

        this.timeStamp = time;
    }
}