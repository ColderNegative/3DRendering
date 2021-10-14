package OBJFileParsing;

public class Objects {
    
    public double[][] verticies;
    public double[][][] faces;
    public double[][] normals;
    public double[][] textures;

    public Objects(double[][] v, double[][][] f, double[][] n, double[][] t) {
        verticies = v;
        faces = f;
        normals = n;
        textures = t;
    }
    
}
