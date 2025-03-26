// HistoryManager.java
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryManager {
    private List<String> history;
    private SimpleDateFormat formatter;

    public HistoryManager() {
        history = new ArrayList<>();
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void addEntry(String location) {
        String timestamp = formatter.format(new Date());
        history.add(timestamp + " - " + location);
    }

    public List<String> getHistory() {
        return history;
    }
}
