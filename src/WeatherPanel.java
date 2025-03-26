// WeatherPanel.java
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WeatherPanel extends JPanel {
    private JTextArea weatherDisplay;
    private JTextArea historyDisplay;
    private JLabel iconLabel;
    
    public WeatherPanel() {
        setLayout(new BorderLayout());
        
        // Weather information display
        weatherDisplay = new JTextArea(8, 30);
        weatherDisplay.setEditable(false);
        weatherDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane weatherScroll = new JScrollPane(weatherDisplay);
        
        // History display
        historyDisplay = new JTextArea(5, 30);
        historyDisplay.setEditable(false);
        historyDisplay.setFont(new Font("Arial", Font.PLAIN, 12));
        JScrollPane historyScroll = new JScrollPane(historyDisplay);
        
        // Icon for weather condition
        iconLabel = new JLabel();
        iconLabel.setPreferredSize(new Dimension(100, 100));
        
        // Organize displays
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(iconLabel, BorderLayout.WEST);
        topPanel.add(weatherScroll, BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.CENTER);
        add(historyScroll, BorderLayout.SOUTH);
    }
    
    public void updateWeatherInfo(WeatherData data, ImageIcon icon) {
        weatherDisplay.setText(data.toString());
        if (icon != null) {
            iconLabel.setIcon(icon);
        }
    }
    
    public void updateHistory(List<String> history) {
        StringBuilder sb = new StringBuilder();
        for (String entry : history) {
            sb.append(entry).append("\n");
        }
        historyDisplay.setText(sb.toString());
    }
}