package com.shark.epam;
import java.util.*;

public class Home_1_Matrix {
	private double[][] matrix;
	public int size;
	
	Home_1_Matrix(int n) {
		size = n;
		matrix = new double[size][size];
		RandomFill();
	}
	
	private void RandomFill() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				matrix[i][j] = Math.random()*2*size - size;
			}
		}
	}
	
	public void Show() {
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				System.out.format("%6.2f ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------------");
	}
	
	public void Transpon() {
		int k = 0;
		for (int i = 0; i < size; ++i) {
			for (int j = k; j < size; ++j) {
				double temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
			k++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		Home_1_Matrix matrix = new Home_1_Matrix(n);
		matrix.Show();
		matrix.Transpon();
		matrix.Show();
	}
}
