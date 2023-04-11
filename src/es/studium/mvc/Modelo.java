package es.studium.mvc;

public class Modelo
{
	public int sumar(int num1, int num2) {
		int resultado;
		resultado = num1 + num2;
		return resultado;
	}
	
	public int resta(int num1, int num2) {
		int resultado;
		resultado = num1 - num2;
		return resultado;
	}
	
	public int producto(int num1, int num2) {
		int resultado;
		resultado = num1 * num2;
		return resultado;
	}
	
	public double division(int num1, int num2) {
		double resultado;
		resultado = (double)num1 / (double)num2;
		return resultado;
	}
}
