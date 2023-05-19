

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Verifica extends JFrame implements ActionListener{

	
	Font font1= new Font("Bodoni MT", Font.PLAIN, 26);
	Font font2= new Font("Algerian", Font.BOLD, 64);

	JFrame fr2;
	JLabel label0= new JLabel ("Inserisci un numero:");
	JLabel label1= new JLabel ("Cerca un numero:");
	JLabel label2= new JLabel ("");


	JLabel label= new JLabel ("");
	
	JButton ins= new JButton("INSERISCI");
	JButton rim= new JButton("RIMUOVI");
	JButton vis= new JButton("VISUALIZZA");
	JButton cer= new JButton("CERCA");
	
	JButton rimuovi= new JButton("RIMUOVI");
	JButton annulla= new JButton("ANNULLA");
	
	
	
	JTextArea numIns= new JTextArea(5,15);
	JTextArea numVis= new JTextArea(5,15);
	JTextArea numCer= new JTextArea(5,15);
	
	JScrollPane pane= new JScrollPane (numVis);
	
	ArrayList<Integer> arr= new ArrayList<Integer>();
	
	int k;
	
	public Verifica() {
		super("ARRAYLIST");
		
			setSize (700, 500);
			Container cont= this.getContentPane();
			setResizable(false);
			
			cont.add(label0);
			label0.setBounds(50, 40, 250, 60);
			label0.setFont(font1);
			
			cont.add(numIns);
			numIns.setBounds(310, 50, 70, 40);
			numIns.setFont(font1);
			
			cont.add(ins);
			ins.setBounds(440, 50, 200, 40);
			ins.setFont(font1);
			
			
			cont.add(rim);
			rim.setBounds(250, 150, 200, 50);
			rim.setFont(font1);
			
			
			cont.add(vis);
			vis.setBounds(250, 250, 200, 50);
			vis.setFont(font1);
			
			cont.add(pane);
			pane.setBounds(50, 320, 600, 120);
			numVis.setFont(font1);
			/*
			pane.setLineWrap(true);
			pane.setWrapStyleWord(true);
			*/
			
			ins.addActionListener(this);
			rim.addActionListener(this);
			vis.addActionListener(this);
			
			cont.add(label);
			setVisible(true);
			
			//FRAME 2
			fr2=new JFrame();
			fr2.setVisible(false);
			fr2.setSize (700, 500);
			fr2.setLocation(701, 0);
			
			fr2.add(label1);
			label1.setBounds(200, 130, 250, 60);
			label1.setFont(font1);
			
			fr2.add(numCer);
			numCer.setBounds(430, 130, 90, 60);
			numCer.setFont(font1);
			
			fr2.add(cer);
			cer.setBounds(260, 220, 170, 60);
			cer.setFont(font1);
			
			fr2.add(label2);
			label2.setBounds(40, 150, 600, 60);
			label2.setFont(font1);
			label2.setVisible(false);
			
			fr2.add(rimuovi);
			rimuovi.setBounds(80, 220, 250, 60);
			rimuovi.setFont(font1);
			rimuovi.setVisible(false);
			
			fr2.add(annulla);
			annulla.setBounds(350, 220, 250, 60);
			annulla.setFont(font1);
			annulla.setVisible(false);
			
			fr2.add(label);
			
			cer.addActionListener(this);
			rimuovi.addActionListener(this);
			annulla.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == ins) {
			arr.add(Integer.parseInt(numIns.getText()));
			numIns.setText("");
			
			for (int i = 0; i < arr.size() - 1; i++) {
	            for (int j = 0; j < arr.size() - 1 - i; j++) {
	                if (arr.get(j) > arr.get(j + 1)) {
	                    int t = arr.get(j);
	                    arr.set(j, arr.get(j + 1));
	                    arr.set(j + 1, t);
	                }
	            }
	        }
		}else if(e.getSource() == rim){
			fr2.setVisible(true);
			cer.setVisible(true);
			numCer.setVisible(true);
			label1.setVisible(true);
		}else if(e.getSource() == cer){
			numCer.setVisible(false);
			cer.setVisible(false);
			label1.setVisible(false);
			
			label2.setVisible(true);
			label2.setText("");
			/*
			String s="";
				for(int i=0; i<5; i++) {
					s=s+". ";
					label2.setText(s);
					
					try {
			            Thread.sleep(500);
			        } catch (InterruptedException time) {
			            time.printStackTrace();
			        }
				}
				*/
			boolean presente=false;
			for(int c=0; c<arr.size(); c++) {
				if(Integer.parseInt(numCer.getText())==arr.get(c)) {
					presente=true;		
					k=c;
					}
				}
			if(presente==true) {
				label2.setText("Il numero è presente nell'Array, sicuro di rimuoverlo?");
				rimuovi.setVisible(true);
				annulla.setVisible(true);
			}else {
				numCer.setVisible(false);
				cer.setVisible(false);
				label1.setVisible(false);
				label2.setText("Il numero non è presente nell'Array");
				try {
		            Thread.sleep(2500);
		        } catch (InterruptedException time) {
		            time.printStackTrace();
		        }
				fr2.setVisible(false);
			}
		
			

			
		}else if(e.getSource() == vis){
			String s="";
			for(int k=0; k<arr.size(); k++) {
				s=s+(arr.get(k)).toString()+"\n";
		}
			numVis.setText(s);
		}else if(e.getSource() == rimuovi){
			arr.remove(k);
			fr2.setVisible(false);
		}else if(e.getSource() == annulla){
			fr2.setVisible(false);
		}
	}

}
