package interfaaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import entidades.Persona;
import negocio.ControladorPersona;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ABMPersona extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ControladorPersona cp=new ControladorPersona();

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtApellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMPersona frame = new ABMPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABMPersona() {
		setTitle("ABM Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDni = new JLabel("DNI:");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblEmail = new JLabel("Email:");
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				buscar();
			}
		});
		
		JLabel lblTitulo = new JLabel("ABM Personas");
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				borrar();
			}
		});
		
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				guardar();
			}

			
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(lblTitulo)
					.addGap(168))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombre)
						.addComponent(lblEmail)
						.addComponent(lblDni))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(txtDni))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblApellido)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(135)
					.addComponent(btnBorrar)
					.addGap(18)
					.addComponent(btnGuardar)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitulo)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido)
						.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBorrar)
						.addComponent(btnGuardar))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void guardar() {
		if (validarCampos()){
			Persona p=new Persona();
			p.setDni(Integer.parseInt(txtDni.getText()));
			p.setNombre(txtNombre.getText());
			p.setApellido(txtApellido.getText());
			p.setEmail(txtEmail.getText());
			int bandera=validarDni();
			if (bandera==3){
				cp.guardarPersona(p);
				JOptionPane.showMessageDialog(null, "Guardado Exitosamente!","Aviso", JOptionPane.INFORMATION_MESSAGE);
				borrarCampos();
			}
			if (bandera==1) {
				cp.modificarPersona(p);
				JOptionPane.showMessageDialog(null, "Persona Modificada Exitosamente!");
				borrarCampos();
			}
		}
	}
	
	private void borrarCampos() {
		txtDni.setText("");
		txtNombre.setText("");
		txtEmail.setText("");
		txtApellido.setText("");
		
	}

	private boolean validarCampos() {
		if (txtDni.getText().length()==0 || txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtEmail.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Existen campos incompletos","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else 
			return true;
		
	}
	
	private int validarDni() {
		if(cp.buscarPersona(Integer.parseInt(txtDni.getText()))!=null){
			int dialogResult=JOptionPane.showConfirmDialog(null, "¿Desea modificar al usuario?");
			if(dialogResult == JOptionPane.YES_OPTION){ 
				return 1;
			}
			else
				return 2;
			
		}
		else
			return 3;
		
	}

	private void buscar() {
		ControladorPersona cp=new ControladorPersona();
		Persona p;
		p=cp.buscarPersona(Integer.parseInt(txtDni.getText()));
		if (p != null){
			txtNombre.setText(p.getNombre());
			txtApellido.setText(p.getApellido());
			txtEmail.setText(p.getEmail());
		}
		else
			JOptionPane.showMessageDialog(null, "No existe Persona","Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void borrar(){
		if(validarCampos()){
			Persona p;
			p=cp.buscarPersona(Integer.parseInt(txtDni.getText()));
			if(p!=null){
				cp.borrarPersona(p);
				borrarCampos();
				JOptionPane.showMessageDialog(null, "Persona borrada","Aviso",JOptionPane.DEFAULT_OPTION);
			}
			else
				JOptionPane.showMessageDialog(null, "No existe Persona para borrar","Error",JOptionPane.ERROR_MESSAGE);
		}		
	}	
	
}
