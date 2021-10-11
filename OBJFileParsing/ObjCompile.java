package OBJFileParsing;

public class ObjCompile {
    
    public static void main(String[] args) {

        // print to terminal module name 
        System.out.println("Module: Obj File Compiling ");
        
    }


    // add obj object, add get obj method which allows the calling of objs with their names, 
    public static Object[] createObjectArray(String folderName) {
        String[] objFiles = ObjImport.getObjFiles(folderName);
        Object[] finalArray = new Object[objFiles.length];        

        for (int i = 0; i < finalArray.length; i++) {

            // pulls all the required data
            String fileName = objFiles[i];
            int[] meta = ObjImport.getFileMeta(fileName);
            String[] contents = ObjImport.getFileContents(fileName);
            
            // Assembles all the required data
            //  1 vertices, 2 vertex textures, 3 vertex normals, 3 faces
            double[][] vertices = ObjParse.getVert(contents, meta[0]);
            double[][] vertexTextures = ObjParse.getVertTexture(contents, meta[1]);
            double[][] vertexNormals = ObjParse.getVertNormal(contents, meta[2]);
            double[][][] faces = ObjParse.getFaces(contents, meta[3]);
            
            // create the object and append to Object[]
            finalArray[i] = new Object(vertices, faces, vertexNormals, vertexTextures);

        }

        return finalArray;
    }


}

class Object {
    public double[][] verticies;
    public double[][][] faces;
    public double[][] normals;
    public double[][] textures;

    public Object(double[][] v, double[][][] f, double[][] n, double[][] t) {
        verticies = v;
        faces = f;
        normals = n;
        textures = t;
    }
    
}

