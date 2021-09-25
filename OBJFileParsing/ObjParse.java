package OBJFileParsing;

import java.util.Arrays;

public class ObjParse {
    public static void main(String[] args) {
        
        // print module name to terminal
        System.out.println("Module: Obj file parsing");

    }

    // gets the verticies from the obj file 
    public static double[][] getVert(String[] fileContents, int vertcies) {

        // initializes the vertices array where the verticies will be stored
        double[][] vertArray = new double[vertcies][3];


        int o = 0;
        //loops through each line of the file
        for (int i = 0; i < fileContents.length; i++) {
            String line = fileContents[i];
            // checks if the line is longer than 1 character to make sure it does not check empty lines
            if (line.length() > 1 ) {
                // creates a string from the two initial characters of each line
                String firstTwoChar = "" + line.charAt(0) + line.charAt(1);
                if (firstTwoChar.equals("v ")) {
                    // initializes the string in which the coord will be temperarly placed
                    String coord = "";
                    // u is the number of spaces
                    int u = 0;
                    for (int j = 2; j < line.length(); j++) {
                        coord += line.charAt(j);
                        // after a space is detected the coord is parsed into a double then inputed into the array, spaces are ignored in the parsing method
                        if (line.charAt(j) == ' ') {
                            vertArray[o][u] = Double.parseDouble(coord);
                            coord = "";
                            u++;
                        }
                        // the coord is parsed into a double then inputed into the array after the end is detected
                        if (j == line.length() - 1) {
                            vertArray[o][2] = Double.parseDouble(coord);
                            coord = "";
                            o++;
                        }

                    }
                } 

            }        
        }

        return vertArray;
    }

    // similar structure to other methods but pulls the vertices textures
    public static double[][] getVertTexture(String[] fileContents, int vertciesTextures) {

        double[][] vertArrayTexture = new double[vertciesTextures][2];
        int o = 0;

        for (int i = 0; i < fileContents.length; i++) {
            String line = fileContents[i];
            if (line.length() > 1 ) {
                String firstTwoChar = "" + line.charAt(0) + line.charAt(1);
                if (firstTwoChar.equals("vt")) {
                    String coord = "";
                    int u = 0;
                    for (int j = 3; j < line.length(); j++) {
                        coord += line.charAt(j);
                        if (line.charAt(j) == ' ') {
                            vertArrayTexture[o][u] = Double.parseDouble(coord);
                            coord = "";
                            u++;
                        }
                        if (j == line.length() - 1) {
                            vertArrayTexture[o][1] = Double.parseDouble(coord);
                            coord = "";
                            o++;
                        }

                    }
                } 

            }        
        }

        return vertArrayTexture;
    }

    // similar method structure but pulls vertices normals  
    public static double[][] getVertNormal(String[] fileContents, int vertciesNormals) {

        double[][] vertArrayNormal = new double[vertciesNormals][3];
        int o = 0;

        for (int i = 0; i < fileContents.length; i++) {
            String line = fileContents[i];
            if (line.length() > 1 ) {
                String firstTwoChar = "" + line.charAt(0) + line.charAt(1);
                if (firstTwoChar.equals("vn")) {
                    String coord = "";
                    int u = 0;
                    for (int j = 3; j < line.length(); j++) {
                        coord += line.charAt(j);
                        if (line.charAt(j) == ' ') {
                            vertArrayNormal[o][u] = Double.parseDouble(coord);
                            coord = "";
                            u++;
                        }
                        if (j == line.length() - 1) {
                            vertArrayNormal[o][2] = Double.parseDouble(coord);
                            coord = "";
                            o++;
                        }

                    }
                } 

            }        
        }

        return vertArrayNormal;
    }

    // similar structure but pulls faces, extra loop parses the interal contents of each face vertex
    public static double[][][] getFaces(String[] fileContents, int numFaces) {

        String[][] facesArray = new String[numFaces][3];
        int o = 0;

        for (int i = 0; i < fileContents.length; i++) {
            String line = fileContents[i];
            if (line.length() > 1 ) {
                String firstTwoChar = "" + line.charAt(0) + line.charAt(1);
                if (firstTwoChar.equals("f ")) {
                    String coord = "";
                    int u = 0;
                    for (int j = 2; j < line.length(); j++) {
                        if (line.charAt(j) == ' ') {
                            facesArray[o][u] = coord;
                            coord = "";
                            u++;
                        } else {
                            coord += line.charAt(j);
                        }
                        if (j == line.length()-1) {
                            facesArray[o][2] = coord;
                            coord = "";
                            o++;
                        }
                        
                    }
                } 

            }        
        }

        double[][][] finalFacesArray = new double[numFaces][3][3];

        for (int i = 0; i < facesArray.length; i++) {
            for (int j = 0; j < facesArray[0].length; j++) {
                String item = facesArray[i][j];
                int slashes = 0;
                for (int k = 0; k < item.length(); k++){
                    char charAt = item.charAt(k);
                    if (charAt == '/') {
                        slashes++;

                    } else {
                        finalFacesArray[i][j][slashes] = (double) charAt - '0';

                    }
                }
                
            }
        }

        return finalFacesArray;
    }
    
}
