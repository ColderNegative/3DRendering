import java.util.Arrays;
import java.util.Objects;
import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		Vector[] points = new Vector[8];
		
		points[0] = new Vector(10, -10, 10);
		points[1] = new Vector(10, -10, 10);
		points[2] = new Vector(-10, 10, 10);
		points[3] = new Vector(-10, 10, 10);
		points[4] = new Vector(10, -10, -10);
		points[5] = new Vector(10, -10, -10);
		points[6] = new Vector(-10, 10, -10);
		points[7] = new Vector(-10, 10, -10);
		
		for (Vector i: points) {
			System.out.println(Objects.toString(i.x) + " " + Objects.toString(i.y) + " " + Objects.toString(i.z));
		}
		
		double[][] matpoints = Vector.vecToMatrx(points[0]);
		System.out.print(Arrays.deepToString(matpoints));
		
		new Window();

	}
}

class Vector {
	public double x;
	public double y;
	public double z;
	
	public Vector(double i, double j, double u) {
		x = i;
		y = j;
		z = u;
	}
	
	static double[][] vecToMatrx(Vector i) {
		double[][] vecMatrix = {
				{i.x},
				{i.y},
				{i.z}
		};
		return vecMatrix;
		
	}
}

