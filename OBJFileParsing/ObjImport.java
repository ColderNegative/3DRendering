package OBJFileParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ObjImport {
    private static String objFolder = "Objects\\";
    public static void main(String[] args) {

        System.out.println("Module: Obj file importing and parsing");
        ObjImport.fileContents("Objects\\cube.obj");
        ObjImport.getObjFiles(objFolder);
        ObjImport.getFileMeta("Objects\\cube.obj");
    }

    static void fileContents(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with file reading.");
            e.printStackTrace();
        }

    }

    static int[] getFileMeta(String fileName) {
         try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            int numVertex = 0;
            int numVertexNormals = 0;
            int numVertexTextures = 0;
            int numFaces = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                
                if (data.length() > 1) {
                    String firstTwoChar = "" + data.charAt(0) + data.charAt(1); 
                    switch (firstTwoChar) {
                    case "v " : numVertex++;
                        continue;
                    case "vt" : numVertexTextures++;
                        continue;
                    case "vn" : numVertexNormals++;
                        continue;
                    case "f " : numFaces++;
                    }
                } 
                
            }
            myReader.close();
            System.out.println(numVertex);
            System.out.println(numVertexTextures);
            System.out.println(numVertexNormals);  
            System.out.println(numFaces);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with file reading.");
            e.printStackTrace();
        }
        return null;
    }

    static File[] getObjFiles(String folderName) {
        File directory = new File(folderName);
        File[] contents = directory.listFiles();
        return contents;
    }

}

