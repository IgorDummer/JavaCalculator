import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* Feito com base em https://www.youtube.com/watch?v=dfhmTyRTCSQ */

public class Calculadora implements ActionListener{

	private JFrame frame;
	private JTextField textfield;
	private JButton[] numberButtons = new JButton[10];
	private JButton addButton, subButton, mulButton, divButton, decButton, equButton, delButton, clrButton; /* Bot�es de opera��o */
	private JPanel panel;
	
	char operador;
	double num1 = 0, num2 = 0, result = 0;
	
	Calculadora(){
		/* Da nome para o frame */
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50); /* Posi��o da caixa de texto */
		/* Torna o campo de texto n�o edit�vel, apenas os bot�es inserem os n�meros */
		textfield.setEditable(false);
		
		/* Define os bot�es de opera��o */
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("Clear");
		
		/* Atribuindo a��o para os bot�es e adicionando na lista*/
		addButton.addActionListener(this);
		frame.add(addButton);
		
		subButton.addActionListener(this);
		frame.add(subButton);
		
		mulButton.addActionListener(this);
		frame.add(mulButton);
		
		divButton.addActionListener(this);
		frame.add(divButton);
		
		decButton.addActionListener(this);
		frame.add(decButton);
		
		equButton.addActionListener(this);
		frame.add(equButton);
		
		delButton.addActionListener(this);
		frame.add(delButton);
		
		clrButton.addActionListener(this);
		frame.add(clrButton);
		
		/* Definindo os bot�es numerados */
		for(int i=0; i<10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
		}
		
		delButton.setBounds(50,430,145,50);
		clrButton.setBounds(205,430,145,50);
		
		/* Painel que cria componentes */
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4, 10, 10)); /* Define o layout do painel */
		// panel.setBackground(Color.gray);
		
		/* Monta o esquema do painel de d�gitos e opera��es*/
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		
		frame.setVisible(true); /* Mostra o frame */
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operador = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operador = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operador = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operador = '/';
			textfield.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			if(operador == '+') {
				result = num1 + num2;
			}
			else if (operador == '-') {
				result = num1 - num2;
			}
			else if (operador == '*') {
				result = num1 * num2;
			}
			else if (operador == '/') {
				result = num1/num2;
			}
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
	}

}
