// WeatherApp.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class WeatherApp extends JFrame {
    private JTextField locationField;
    private JComboBox<String> unitComboBox;
    private WeatherPanel weatherPanel;
    private HistoryManager historyManager;

    public WeatherApp() {
        setTitle("Weather Information App");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        historyManager = new HistoryManager();
        weatherPanel = new WeatherPanel();
        
        // Create input panel for location and unit selection
        JPanel inputPanel = new JPanel(new FlowLayout());
        JLabel locationLabel = new JLabel("Enter location:");
        locationField = new JTextField(15);
        inputPanel.add(locationLabel);
        inputPanel.add(locationField);
        
        JLabel unitLabel = new JLabel("Units:");
        String[] unitOptions = {"Metric", "Imperial"};
        unitComboBox = new JComboBox<>(unitOptions);
        inputPanel.add(unitLabel);
        inputPanel.add(unitComboBox);
        
        JButton getWeatherButton = new JButton("Get Weather");
        inputPanel.add(getWeatherButton);
        
        // Main layout with input panel at the top and weather panel in the center
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(weatherPanel, BorderLayout.CENTER);
        
        // Button listener for getting weather information
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String location = locationField.getText().trim();
                if (location.isEmpty()) {
                    JOptionPane.showMessageDialog(WeatherApp.this, "Please enter a location.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                boolean useMetric = unitComboBox.getSelectedItem().equals("Metric");
                try {
                    // Fetch weather data (dummy implementation for now)
                    WeatherData data = WeatherAPI.getWeather(location, useMetric);
                    
                    // Add location to history
                    historyManager.addEntry(location);
                    weatherPanel.updateHistory(historyManager.getHistory());
                    
                    // Load an icon based on condition (for demonstration, use a placeholder icon)
                    // In a real app, load icons from your resources directory.
                    ImageIcon icon = getWeatherIcon(data.getCondition());
                    
                    weatherPanel.updateWeatherInfo(data, icon);
                    setDynamicBackground();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(WeatherApp.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    /**
     * Simulate loading an icon based on the weather condition.
     * Replace this with actual logic to load icons from your resource folder.
     */
    private ImageIcon getWeatherIcon(String condition) {
        // For demonstration purposes, we use a simple colored square as an icon.
        // In practice, load a real image from a file (e.g., new ImageIcon("sunny.png"))
        int size = 50;
        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        if ("Sunny".equalsIgnoreCase(condition)) {
            g2d.setColor(Color.YELLOW);
        } else if ("Cloudy".equalsIgnoreCase(condition)) {
            g2d.setColor(Color.LIGHT_GRAY);
        } else if ("Rainy".equalsIgnoreCase(condition)) {
            g2d.setColor(Color.BLUE);
        } else {
            g2d.setColor(Color.GREEN);
        }
        g2d.fillRect(0, 0, size, size);
        g2d.dispose();
        return new ImageIcon(img);
    }
    
    /**
     * Sets a dynamic background based on the time of day.
     */
    private void setDynamicBackground() {
        int hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 12) {
            getContentPane().setBackground(new Color(255, 223, 186)); // morning
        } else if (hour >= 12 && hour < 18) {
            getContentPane().setBackground(new Color(186, 225, 255)); // afternoon
        } else {
            getContentPane().setBackground(new Color(150, 150, 180)); // evening/night
        }
    }
    
    public static void main(String[] args) {
        // Run the app on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WeatherApp().setVisible(true);
            }
        });
    }
}
