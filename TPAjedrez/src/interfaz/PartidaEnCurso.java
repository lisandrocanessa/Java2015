package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

import entidades.Ficha;
import entidades.Partida;

import javax.swing.JTextArea;

import negocio.ControladorPartida;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class PartidaEnCurso extends JFrame {

	private JPanel contentPane;
	private Partida partida;
	private JTextArea txtJugadorUno;
	private JTextArea txtJugadorDos;
	private JLabel lblJugadorUno;
	private JLabel lblJugadorDos;
	private JLabel lblJugadorTurno;
	private JComboBox cmbFicha;
	private JTextField txtPosX;
	private JTextField txtPosY;
	
	
	/**
	 * Launch the application.
	 */
	
	
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PartidaEnCurso frame = new PartidaEnCurso();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PartidaEnCurso(Partida p) {
		setResizable(false);
		setTitle("PARTIDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblJugadorUno = new JLabel("JUGADOR UNO");
		lblJugadorUno.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblJugadorUno.setBounds(69, 23, 114, 29);
		contentPane.add(lblJugadorUno);
		
		JLabel lblVs = new JLabel("VS.");
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblVs.setBounds(260, 27, 24, 21);
		contentPane.add(lblVs);
		
		lblJugadorDos = new JLabel("JUGADOR DOS");
		lblJugadorDos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblJugadorDos.setBounds(373, 30, 124, 14);
		contentPane.add(lblJugadorDos);
		
		JScrollPane scrTablero = new JScrollPane();
		scrTablero.setBounds(28, 63, 204, 217);
		contentPane.add(scrTablero);
		
		txtJugadorUno = new JTextArea();
		txtJugadorUno.setEnabled(false);
		txtJugadorUno.setRows(16);
		txtJugadorUno.setLineWrap(true);
		scrTablero.setViewportView(txtJugadorUno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 63, 204, 217);
		contentPane.add(scrollPane);
		
		txtJugadorDos = new JTextArea();
		txtJugadorDos.setEnabled(false);
		txtJugadorDos.setRows(16);
		scrollPane.setViewportView(txtJugadorDos);
		
		JLabel lblTurnoDe = new JLabel("Turno de:");
		lblTurnoDe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTurnoDe.setBounds(193, 305, 60, 14);
		contentPane.add(lblTurnoDe);
		
		lblJugadorTurno = new JLabel("JUGADORTURNO");
		lblJugadorTurno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJugadorTurno.setBounds(263, 305, 104, 14);
		contentPane.add(lblJugadorTurno);
		
		cmbFicha = new JComboBox();
		cmbFicha.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
			}
		});
		cmbFicha.setBounds(118, 337, 114, 20);
		contentPane.add(cmbFicha);
		
		JLabel lblFicha = new JLabel("Ficha:");
		lblFicha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFicha.setBounds(70, 339, 38, 14);
		contentPane.add(lblFicha);
		
		JButton btnRealizarMovimiento = new JButton("REALIZAR MOVIMIENTO");
		btnRealizarMovimiento.addActionListener(new ActionListener() {
			//evento que actualiza la posicion de la pieza si fue movida correctamente
			public void actionPerformed(ActionEvent arg0) {
				if(!txtPosX.getText().equals("") && !txtPosY.getText().equals("")){
					ControladorPartida cp = new ControladorPartida();
					Ficha f = null;
					//busco ficha con el metodo dame ficha mandandole el texto del comboBox
					if(p.getTurno()==1){
					//f=cp.dameFicha(cmbFicha.getSelectedItem().toString(),p.getNroPartida(),p.getJ1().getDni());
						for (int i = 0; i < p.getTablero().size(); i++) {
							if(p.getTablero().get(i).getNombre()==cmbFicha.getSelectedItem().toString() &&
								p.getTablero().get(i).getDni()==p.getJ1().getDni()){
								f=p.getTablero().get(i);
							}
						}
					}
					else{
						//f=cp.dameFicha(cmbFicha.getSelectedItem().toString(),p.getNroPartida(),p.getJ2().getDni());
						for (int i = 0; i < p.getTablero().size(); i++) {
							if(p.getTablero().get(i).getNombre()==cmbFicha.getSelectedItem().toString() &&
								p.getTablero().get(i).getDni()==p.getJ2().getDni()){
								f=partida.getTablero().get(i);
							}
						}
						
					}
					//valido que el movimiento fuese posible y si lo es invoco a realizar movimiento
					if(f.validarMovimiento(Integer.parseInt(txtPosX.getText()), Integer.parseInt(txtPosY.getText()))){
						//cp.realizarMovimiento(f, Integer.parseInt(txtPosX.getText()), Integer.parseInt(txtPosY.getText()));
						f.setPosX(Integer.parseInt(txtPosX.getText()));
						f.setPosY(Integer.parseInt(txtPosY.getText()));
						JOptionPane.showMessageDialog(null, "El movimiento ha sido efectuado correctamente");
						cambiarTurno();
						listarPiezas();
					}
					else
						JOptionPane.showMessageDialog(null, "La pieza no puede moverse a ese sitio");
				}
					else
						JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos");
				
			
			}

			//metodo que cambia el turno de la partida, falta actualizar en la DB
			private void cambiarTurno() {
				// TODO Auto-generated method stub
				if(p.getTurno()==1)
					p.setTurno(2);
				else
					p.setTurno(1);
			}
			
		});
		btnRealizarMovimiento.setBounds(179, 382, 204, 29);
		contentPane.add(btnRealizarMovimiento);
		
		ArrayList<Integer> ejes=new ArrayList<>();
		for (int i = 1; i < 9; i++) {
			ejes.add(i);
		}
		
		JLabel lblX = new JLabel("Fila:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblX.setBounds(329, 339, 38, 14);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("Columna:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblY.setBounds(414, 332, 67, 29);
		contentPane.add(lblY);
		
		txtPosX = new JTextField();
		txtPosX.setBounds(471, 337, 46, 20);
		contentPane.add(txtPosX);
		txtPosX.setColumns(10);
		
		txtPosY = new JTextField();
		txtPosY.setBounds(359, 337, 45, 20);
		contentPane.add(txtPosY);
		txtPosY.setColumns(10);
		this.partida = p;
		iniciarPartida();
		
	}

	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	// inicializa el tablero
	public void iniciarPartida() {
		// TODO Auto-generated method stub
		this.lblJugadorUno.setText(Integer.toString(this.getPartida().getJ1().getDni()));
		this.lblJugadorDos.setText(Integer.toString(this.getPartida().getJ2().getDni()));
		listarPiezas();
	}

	@SuppressWarnings("unchecked")
	//metodo que actualiza el form de la partida
	private void listarPiezas(){
		ControladorPartida cp=new ControladorPartida();
		ArrayList<String> piezasCombo=new ArrayList<>();
		txtJugadorUno.setText(null);
		txtJugadorDos.setText(null);
		txtPosX.setText(null);
		txtPosY.setText(null);
		for (Ficha f : this.partida.getTablero()){
			if (f.getDni()==this.partida.getJ1().getDni()){
				this.txtJugadorUno.append("  "+f.getNombre() + "     (" + f.getPosX() + ",   " + f.getPosY() + ")"+f.isEstado()+"\n");
			}
			else if (f.getDni()==this.partida.getJ2().getDni()) {
				this.txtJugadorDos.append("  "+f.getNombre() + "     (" + f.getPosX() + ",   " + f.getPosY() + ")"+f.isEstado()+"\n");
			}
		}
		//if que detecta a que jugador le toca y busca las piezas no comidas para el mismo

		if (this.partida.getTurno()==1){
			this.lblJugadorTurno.setText(Integer.toString(this.partida.getJ1().getDni()));
			for (int i = 0; i < partida.getTablero().size(); i++) {
				if(partida.getTablero().get(i).getDni()==partida.getJ1().getDni() && partida.getTablero().get(i).isEstado())
					piezasCombo.add(partida.getTablero().get(i).getNombre().toString());
			}
		}
		else {
			this.lblJugadorTurno.setText(Integer.toString(this.partida.getJ2().getDni()));
			for (int i = 0; i < partida.getTablero().size(); i++) {
				if(partida.getTablero().get(i).getDni()==partida.getJ2().getDni() && partida.getTablero().get(i).isEstado())
					piezasCombo.add(partida.getTablero().get(i).getNombre().toString());
			}
		}		

		//se llena el comboBox una vez que se buscaron las piezas no comidas
		@SuppressWarnings("rawtypes")
		DefaultComboBoxModel mdlCombo= new DefaultComboBoxModel();
		cmbFicha.setModel(mdlCombo);
		for (int i = 0; i < piezasCombo.size(); i++) {
			mdlCombo.addElement(piezasCombo.get(i));
		}
	}
}
