package VectorMaths;

import java.util.Arrays;

public class Matrix {
	public static void main(String[] args) {
		// all within main method is only called when this file is specifically ran and not when the module is called
		// display current working module
		System.out.println("Module: Matrix");
		
		// test arrays
		double[][] mat1 = {
				{1, 0, 1 }, 
				{1, 1, 0 }, 
				{0, 0, 1 }	
		};
		
		double[][] mat2 = {
				{1, 3, 1 }, 
				{0, 1, 0 }, 
				{2, 0, 3 }	
		};
		
		// print test multiplied matrix
		double[][] multimatrix = Matrix.matMul(mat1, mat2);
		System.out.print(Arrays.deepToString(multimatrix));
	}
	
	public static double[][] matMul(double[][] a, double[][] b) {
		// Initialization of final 2d array
		double[][] multiMatrix;
		int rows = a.length;
		int coloumns = b[0].length;
		multiMatrix = new double[rows][coloumns];
		
		// for loops for going through the final 2d array
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < coloumns; j++) {
				
				// variables for creating the element from the multiplied arrays
				double combined = 0;
				double[] listAdd = new double[a[0].length];
				int lengthElementArray = listAdd.length;
				
				// for loops for going through the elements of the initial arrays and multiplying 
				for (int u = 0; u < lengthElementArray; u++) {
					double multi = a[i][u] * b[u][j];
					listAdd[u] = multi;
				}
				
				// adds all the multiplied components for each element together
				for (double c: listAdd) {
					combined += c;
				}
				
				// appends the final element to its position in the final matrix
				multiMatrix[i][j] = combined;
				
			}
		}
		
		// returns the final matrix
		return multiMatrix;
	}
}
