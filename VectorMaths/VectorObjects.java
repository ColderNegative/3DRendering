package VectorMaths;

import java.util.Arrays;
import java.lang.Math;

public class VectorObjects {
	
	public static void main(String[] args) {
		// displays current working module
		System.out.println("Module: Vector Objects");
		
		double[][] cube = VectorObjects.createCube(20, 10, 0, 1, 1, 0);
		System.out.println(Arrays.deepToString(cube));
	
		
	}
	
	public static double[][] createCube(double size, double orginOfset, double angleY, double angleX, double angleZ, double distance) {
		Vector[] points = new Vector[8];

		points[0] = new Vector(size - orginOfset, size - orginOfset, size - orginOfset);
		points[1] = new Vector(orginOfset - size, size - orginOfset, size - orginOfset);
		points[2] = new Vector(orginOfset - size, orginOfset - size, size - orginOfset);
		points[3] = new Vector(size - orginOfset, orginOfset - size, size - orginOfset);
		points[4] = new Vector(size - orginOfset, size - orginOfset, orginOfset - size);
		points[5] = new Vector(orginOfset - size, size - orginOfset, orginOfset - size);
		points[6] = new Vector(orginOfset - size, orginOfset - size, orginOfset - size);
		points[7] = new Vector(size - orginOfset, orginOfset - size, orginOfset - size);
		
		double[][][] tempAllPoints = new double[8][3][1];
		
		// x coordinates
		for (int i = 0; i < tempAllPoints.length; i++) {
			tempAllPoints[i][0][0] = points[i].x; 
		}
		// y coordinates
		for (int i = 0; i < tempAllPoints.length; i++) {
			tempAllPoints[i][1][0] = points[i].y; 
		}
		// z coordinates
		for (int i = 0; i < tempAllPoints.length; i++) {
			tempAllPoints[i][2][0] = points[i].z; 
		}
		
		// rotation matrices
		double[][] Rx = {
				{ 1, 0, 0 },
				{ 0, Math.cos(angleX), -Math.sin(angleX) },
				{ 0, Math.sin(angleX), Math.cos(angleX) }
		};
		
		double[][] Ry = {
				{ Math.cos(angleY), 0, Math.sin(angleY) },
				{ 0, 1, 0 },
				{ 0-Math.sin(angleY), 0, Math.cos(angleY) }
		};
		
		double[][] Rz = {
				{ Math.cos(angleZ), -Math.sin(angleZ), 0 },
				{ Math.sin(angleZ), Math.cos(angleZ), 0 },
				{ 0, 0, 1 }
		};
		
		double[][][] tempRotatedAllPoints = new double[8][3][1];
		
		for (int i = 0; i < tempRotatedAllPoints.length; i++) {
			double[][] rotatedX = Matrix.matMul(Rx, tempAllPoints[i]);
			double[][] rotatedY = Matrix.matMul(Ry, rotatedX);
			double[][] rotatedZ = Matrix.matMul(Rz, rotatedY);
			
			tempRotatedAllPoints[i] = rotatedZ;
		}
		
		
		// points are project in final array conversion
		double[][] finalAllPoints = new double[8][2];
		// x coordinate
		for (int i = 0; i < finalAllPoints.length; i++) {
			finalAllPoints[i][0] = tempRotatedAllPoints[i][0][0] * 10 + 500/2;
		}
		// y coordinate
		for (int i = 0; i < finalAllPoints.length; i++) {
			finalAllPoints[i][1] = tempRotatedAllPoints[i][1][0] * 10 + 500/2;
		}
		
		
		return finalAllPoints;
		
	}
}

class Vector {
	public double x;
	public double y;
	public double z;
	
	public Vector(double j, double i, double r) {
		x = j;
		y = i;
		z = r;
	}
}