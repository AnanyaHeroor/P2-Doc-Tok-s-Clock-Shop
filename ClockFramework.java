/* 
Author: Sam Vinitsky

About: 
    - Displays a simplified, discrete clock
    - Uses the functions students write in Clock.java

How to use:
    - Run this program. A window should pop up with an image of a clock
    - If you don't see a window (or get an error):
        - Make sure you have written all of the functions required in Clock.java
        - Make sure they are named correctly, have the correct input/output types, and are "public static"
    - If you see the window, but not a clock, then try making the window bigger (drag the bottom-left corner)

Using the clock window:
    - Adjust the hours/minutes/seconds as desired
    - Short hand is hours, medium is minutes, long is seconds
*/      

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.IOException;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.Math;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ClockFramework{

    private JFrame mainFrame;
    private JLabel timeLabel;
    private int[] timeArray;
    private GraphicsPanel g;
    private JSpinner[] spinners = new JSpinner[3];
    private JButton switchModeButton;
    private JLabel modeLabel;
    private boolean discrete = true;

    public ClockFramework(){

        mainFrame = new JFrame("Clock");
        mainFrame.setSize(600,600);
        mainFrame.setLayout(new GridBagLayout());
        
        // when we close the window, stop the program
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
               System.exit(0);
            }        
        });

        this.addTimeDisplay();

        this.addSpinner(4, -1, 24, 1, 0, "Hours:");
        this.addSpinner(30, -1, 60, 1, 1, "Minutes:");
        this.addSpinner(24, -1, 60, 1, 2, "Seconds:");
    
        // this.addSwitchModeButton();
        // this.addModeLabel();

        this.addGraphics();



        mainFrame.setVisible(true);
    }

    public String getTimeLabel(){

        String hour = "" + timeArray[0];
        String minute = timeArray[1] < 10 ? "0" + timeArray[1] : "" + timeArray[1];
        String second = timeArray[2] < 10 ? "0" + timeArray[2] : "" + timeArray[2];

        return "Time: " + hour + ":" + minute + ":" + second;
    }

    public void addModeLabel(){
        modeLabel = new JLabel("In Discrete Mode");

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 2;
        c.gridy = 2;
        c.weightx = 0.5;
        c.weighty = 0;
        mainFrame.add(modeLabel, c);
    }

    public void addSwitchModeButton(){
        switchModeButton = new JButton("Switch to Continuous Mode");

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 2;
        c.gridy = 3;
        c.weightx = 0.5;
        c.weighty = 0;
        mainFrame.add(switchModeButton, c);

        switchModeButton.addActionListener(e -> {
            if (discrete){
                discrete = false;
                switchModeButton.setText("Switch to Discrete Mode  ");
                modeLabel.setText("In Continuous Mode");
            } else {
                discrete = true;
                switchModeButton.setText("Switch to Continuous Mode");
                modeLabel.setText("In Discrete Mode");
            }
        });
    }

    public void addTimeDisplay(){

        timeArray = new int[]{4,30,24};
        timeLabel = new JLabel(getTimeLabel());
        
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.5;
        c.weighty = 0;
        mainFrame.add(timeLabel, c);
    }

    public void addSpinner(int initial, int min, int max, double step, int index, String label){
        
        SpinnerModel spinnerModel = new SpinnerNumberModel(initial, min, max, step);
        spinners[index] = new JSpinner(spinnerModel);
        JSpinner spinner = spinners[index];

        spinner.addChangeListener(e -> {
            Object value = spinner.getValue();
            timeArray[index] = (int) Double.parseDouble(value.toString());
    

            if (timeArray[index] == 60) {
                timeArray[index - 1]++;
                timeArray[index] = 0;
                spinner.setValue(timeArray[index]);
                spinners[index-1].setValue(timeArray[index-1]);
            }

            if(timeArray[0] == 24){
                timeArray[0] = 0;
                spinner.setValue(timeArray[index]);
            }

            if (timeArray[index] == -1){
                if (index==0){
                    timeArray[index] = 23;
                    spinner.setValue(timeArray[index]);
                }
                else{
                    timeArray[index] = 59;
                    timeArray[index-1]--;
                    spinner.setValue(timeArray[index]);
                    spinners[index-1].setValue(timeArray[index-1]);
                }
            }

            timeLabel.setText(getTimeLabel());
            if (g!=null){
                g.repaint();
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 2 * index;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0;
        mainFrame.add(new JLabel(label), c);
        
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 2 * index + 1;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0;
        mainFrame.add(spinner, c);

    }

    public void addGraphics(){
        int size = 512;
        g = new GraphicsPanel(size);
        g.setPreferredSize(new Dimension(size ,size));

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.gridheight = GridBagConstraints.REMAINDER;
        c.gridwidth = GridBagConstraints.REMAINDER;

        mainFrame.add(g,c);
    }

    class GraphicsPanel extends JPanel{  

        int size;

        public GraphicsPanel(int size){
            super();
            this.size = size;
        }

        public double convertAngle(double angle){
            if (angle < 0 || angle > 360){
                angle=0;
            }

            angle = (angle - 90)/ 180.0 * Math.PI ;
            
            return angle;
        }

        public void paintComponent(Graphics g) {  

            super.paintComponent(g);

            int c = size / 2;

            int secondLength = size/2;
            int minuteLength = size/3;
            int hourLength = size/6;

            double[] angles = new double[3];

            angles[2] = (double) Clock.computeSecondHandAngle(timeArray[2]);
            angles[1] = (double) Clock.computeMinuteHandAngle(timeArray[1]);
            angles[0] = (double) Clock.computeHourHandAngle(timeArray[0]);

            double hourAngle = convertAngle(angles[0]);
            double minuteAngle = convertAngle(angles[1]);
            double secondAngle = convertAngle(angles[2]);             
    
            int secondLengthX = (int) (Math.cos(secondAngle) * secondLength);
            int secondLengthY = (int) (Math.sin(secondAngle) * secondLength);
            int minuteLengthX = (int) (Math.cos(minuteAngle) * minuteLength);
            int minuteLengthY = (int) (Math.sin(minuteAngle) * minuteLength);
            int hourLengthX = (int) (Math.cos(hourAngle) * hourLength);
            int hourLengthY = (int) (Math.sin(hourAngle) * hourLength);
    
            Image img = null;
            try {
                img = ImageIO.read(new File("clock.png"));
            } catch (IOException e) {
                System.out.println("Clock image not found!");
            }
    
            g.drawImage(img, 0, 0, null);
    
            g.translate(c,c);
    
            g.setColor(Color.red);
            g.drawLine(0, 0, secondLengthX, secondLengthY);
            g.setColor(Color.blue);
            g.drawLine(0, 0, minuteLengthX, minuteLengthY);
            g.setColor(Color.green);
            g.drawLine(0, 0, hourLengthX, hourLengthY);
    
        }
    }  

    public static void main(String[] args){
        
        ClockFramework clock = new ClockFramework();
    }
}