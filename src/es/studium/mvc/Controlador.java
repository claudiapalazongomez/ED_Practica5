package es.studium.mvc;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo;
	Vista vista;
	
	public Controlador(Modelo m, Vista v)
	{
		modelo = m;
		vista = v;
		v.boton0.addActionListener(this);
		v.boton1.addActionListener(this);
		v.boton2.addActionListener(this);
		v.boton10.addActionListener(this);
		v.boton3.addActionListener(this);
		v.boton4.addActionListener(this);
		v.boton5.addActionListener(this);
		v.boton11.addActionListener(this);
		v.boton6.addActionListener(this);
		v.boton7.addActionListener(this);
		v.boton8.addActionListener(this);
		v.boton12.addActionListener(this);
		v.boton9.addActionListener(this);
		v.boton15.addActionListener(this);
		v.boton14.addActionListener(this);
		v.boton13.addActionListener(this);
		v.ventana.addWindowListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String botonPulsado = ((Button) e.getSource()).getLabel();
		if (botonPulsado.equals("C"))
		{
			vista.pantalla.setText("0");
			vista.operador1 = 0;
			vista.operador2 = 0;
			vista.nuevoNumeroEnPantalla = true;
		} else if (botonPulsado.equals("="))
		{
			vista.operador2 = Integer.parseInt(vista.pantalla.getText());
			if (vista.operacion != null)
			{
				if (vista.operacion.equals("+"))
				{
					vista.pantalla.setText(modelo.sumar(vista.operador1, vista.operador2) + "");
				} else if (vista.operacion.equals("-"))
				{
					vista.pantalla.setText(modelo.resta(vista.operador1, vista.operador2) + "");
				} else if (vista.operacion.equals("*"))
				{
					vista.pantalla.setText(modelo.producto(vista.operador1, vista.operador2) + "");
				} else if (vista.operacion.equals("/"))
				{
					vista.pantalla.setText(modelo.division(vista.operador1, vista.operador2) + "");
				}
			}
			vista.nuevoNumeroEnPantalla = true;
			vista.operacion = null;
		} else if (botonPulsado.equals("+") || botonPulsado.equals("-") || botonPulsado.equals("*")
				|| botonPulsado.equals("/"))
		{
			vista.operacion = botonPulsado;
			vista.operador1 = Integer.parseInt(vista.pantalla.getText());
			vista.nuevoNumeroEnPantalla = true;
		} else
		{
			if (vista.nuevoNumeroEnPantalla == true)
			{
				vista.pantalla.setText(botonPulsado);
				vista.nuevoNumeroEnPantalla = false;
			} else
			{
				vista.pantalla.setText(vista.pantalla.getText() + botonPulsado);
				if ((vista.pantalla.getText().length() > 1) && (vista.pantalla.getText().charAt(0) == '0'))
				{
					vista.pantalla.setText(vista.pantalla.getText().substring(1));
				}
			}
		}
	}

	@Override
	public void windowClosing(WindowEvent arg0)
	{
		System.exit(0);
	}
	@Override
	public void windowActivated(WindowEvent arg0)
	{}
	@Override
	public void windowClosed(WindowEvent arg0)
	{}
	@Override
	public void windowDeactivated(WindowEvent arg0)
	{}
	@Override
	public void windowDeiconified(WindowEvent arg0)
	{}
	@Override
	public void windowIconified(WindowEvent arg0)
	{}
	@Override
	public void windowOpened(WindowEvent arg0)
	{}
}
