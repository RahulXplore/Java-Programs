import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightSimulator extends JFrame implements ActionListener {
    
    // UI Components
    private JLabel messageLabel;
    private JRadioButton redButton;
    private JRadioButton yellowButton;
    private JRadioButton greenButton;

    public TrafficLightSimulator() {
        // Set up the main frame
        setTitle("Traffic Light Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize the message label (initially empty as requested)
        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 32));
        
        // Add the label to the center of the window
        add(messageLabel, BorderLayout.CENTER);

        // Initialize radio buttons
        redButton = new JRadioButton("Red");
        yellowButton = new JRadioButton("Yellow");
        greenButton = new JRadioButton("Green");

        // Group the radio buttons so only one can be selected at a time
        ButtonGroup lightGroup = new ButtonGroup();
        lightGroup.add(redButton);
        lightGroup.add(yellowButton);
        lightGroup.add(greenButton);

        // Add action listeners to handle button clicks
        redButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);

        // Create a panel to hold the buttons at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(redButton);
        buttonPanel.add(yellowButton);
        buttonPanel.add(greenButton);

        // Add the button panel to the bottom (South) of the window
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the label text and color based on which button was clicked
        if (e.getSource() == redButton) {
            messageLabel.setText("STOP");
            messageLabel.setForeground(Color.RED);
        } else if (e.getSource() == yellowButton) {
            messageLabel.setText("READY");
            // Standard yellow can be hard to read on a gray background, 
            // but Color.YELLOW is used to match the prompt's intent.
            messageLabel.setForeground(Color.YELLOW); 
        } else if (e.getSource() == greenButton) {
            messageLabel.setText("GO");
            messageLabel.setForeground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        // Ensure GUI creation is done on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            TrafficLightSimulator simulator = new TrafficLightSimulator();
            // Center the window on the screen
            simulator.setLocationRelativeTo(null); 
            simulator.setVisible(true);
        });
    }
}
