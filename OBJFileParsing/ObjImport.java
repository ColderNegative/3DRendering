// package for importing obj files
package OBJFileParsing;

// required imports
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// main importing class
public class ObjImport {
    // folder from where the objects will pulled from 
    private static String objFolder = "Objects\\";
    public static void main(String[] args) {

        // print module name to terminal
        System.out.println("Module: Obj file importing and parsing");

    }

    // Pulls all file contents and appends each line to a list
    static String[] fileContents(String filename) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            int[] contentsMeta = ObjImport.getFileMeta(filename);
            String[] contents = new String[contentsMeta[4]];
            int i = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                contents[i] = data;
                i++;
            }
            myReader.close();
            return contents;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with file reading.");
            e.printStackTrace();
            return null;
        }

    }

    // pulls the meta data from the file (vertcies, lines, textures, faces, normals)
    static int[] getFileMeta(String fileName) {
         try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            int[] metaData = new int[5];
            int numVertex = 0;
            int numVertexNormals = 0;
            int numVertexTextures = 0;
            int numFaces = 0;
            int numLines = 0;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                numLines++;
                
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
            metaData[0] = numVertex;
            metaData[1] = numVertexTextures;
            metaData[2] = numVertexNormals;
            metaData[3] = numFaces;
            metaData[4] = numLines;
            return metaData;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred with file reading.");
            e.printStackTrace();
            return null;
        }
    }

    // pulls a list of the file paths in the objects folder 
    static File[] getObjFiles(String folderName) {
        File directory = new File(folderName);
        File[] contents = directory.listFiles();
        return contents;
    }

}

