package Projection;

public class ProjectedObjects {

    private OBJFileParsing.Objects object;
    private int rotationX;
    private int rotationY;
    private int rotationZ;
    private double posX;
    private double posY;
    private double posZ; 
    public double[][][] projectedFaces;

    public static void main(String[] args) {

        //displays current working module
        System.out.println("Module: Project objects");

        OBJFileParsing.Objects[] objectArry = OBJFileParsing.ObjCompile.createObjectsArray("Objects");
        ProjectedObjects cube = new ProjectedObjects(objectArry[0]);
    }

    public ProjectedObjects(OBJFileParsing.Objects obj) {

        object = obj;
        rotationX = 0;
        rotationY = 0;
        rotationZ = 0;
        posX = 0;
        posY = 0;
        posZ = 0;

    }

    public void rotate(int rX, int rY, int rZ) {

        rotationX = rX;
        rotationY = rY;
        rotationZ = rZ;
        project();

    }
    
    public void place(double pX, double pY, double pZ) {

        posX = pX;
        posY = pY;
        posZ = pZ;
        project();

    }

    public void project() {
        // TODO: pull in the object extract verticies  

    }

    
}
