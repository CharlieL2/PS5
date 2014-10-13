package calcgraphics;

import javax.swing.*;

import engine.Calc;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;


public class CalcGUI extends JPanel implements ActionListener {

	// values for the fields
	private double invest, years, rate, future;
	// labels for textfields
	private JLabel investLabel, yearsLabel, rateLabel, futureLabel;
	// strings for labels
	private static String investString = "Investment Amount", yearsString = "Years", rateString = "Annual Interest Rate", futureString = "Future Value";
	// the text fields for data entry
	private JFormattedTextField investField, yearsField, rateField,
			futureField;
	// formats
	private NumberFormat investFormat, yearsFormat, rateFormat, futureFormat;

	public CalcGUI() {
		super(new BorderLayout());
		setUpFormats();
		
		//create button
		JButton button = new JButton("Pika!");
		button.addActionListener(this);
		
		// create labels
		investLabel = new JLabel(investString);
		yearsLabel = new JLabel(yearsString);
		rateLabel = new JLabel(rateString);
		futureLabel = new JLabel(futureString);

		// Create the text fields and set them up.
		investField = new JFormattedTextField(investFormat);
		investField.setValue(new Double(invest));
		investField.setColumns(10);

		yearsField = new JFormattedTextField(yearsFormat);
		yearsField.setValue(new Double(years));
		yearsField.setColumns(10);

		rateField = new JFormattedTextField();
		rateField.setValue(new Double(rate));
		rateField.setColumns(10);

		futureField = new JFormattedTextField(futureFormat);
		futureField.setValue(new Double(future));
		futureField.setColumns(10);
		futureField.setEditable(false);

		// Tell accessibility tools about label/textfield pairs.
		investLabel.setLabelFor(investField);
		yearsLabel.setLabelFor(yearsField);
		rateLabel.setLabelFor(rateField);
		futureLabel.setLabelFor(futureField);
		
		//Lay out the labels in a panel.
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(investLabel);
        labelPane.add(yearsLabel);
        labelPane.add(rateLabel);
        labelPane.add(futureLabel);
        
        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(investField);
        fieldPane.add(yearsField);
        fieldPane.add(rateField);
        fieldPane.add(futureField);
        
        //add the button on
        JPanel buttonPane = new JPanel( new GridLayout(0,1));
        buttonPane.add(button);
        
        //Put the panels in this panel, labels on left,
        //text fields on right.
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
        add(buttonPane, BorderLayout.SOUTH);

	}

	public void actionPerformed(ActionEvent e) {
		invest = ((Number)investField.getValue()).doubleValue();
		years = ((Number)yearsField.getValue()).doubleValue();
		rate = ((Number)rateField.getValue()).doubleValue() / 100;
		double value = Calc.compute(invest, years, rate);
		futureField.setValue(new Double(value));
	}
	
	private void setUpFormats() {
        investFormat = NumberFormat.getNumberInstance();
 
        rateFormat = NumberFormat.getNumberInstance();
        rateFormat.setMinimumFractionDigits(3);
 
        futureFormat = NumberFormat.getCurrencyInstance();
    }
	
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Investment Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new CalcGUI());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
            UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

}
