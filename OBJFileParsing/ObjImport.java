package OBJFileParsing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ObjImport {
    public static void main(String[] args) {

        System.out.println("Module: Obj file importing and parsing");
        ObjImport.fileData("Objects\\cube.obj", 8, 12);
    }

    static void fileData(String filename, int vert, int faces) {
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            double[][] objVerticies = new double[vert][3];
            String[][] objFaces = new String[faces][3];
            int j = 0;
            int u = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 0) {
                    
                    if (data.charAt(0) == 'v') {
                        
                        String coord = "";
                        u = 0;
                        if (data.charAt(2) == ' ') {
                            continue;
                        } else {
                            System.out.println(u + " " + j);
                            for (int i = 2; i < data.length(); i++) {
                                
                                if (data.charAt(i) != ' ') {
                                    if (i == data.length()-1) {
                                        coord += data.charAt(i);
                                        objVerticies[j][u] = Double.parseDouble(coord);
                                        coord = "";
                                    } else {
                                        coord += data.charAt(i);
                                    }
                                    
                                } else {
                                    objVerticies[j][u] = Double.parseDouble(coord);
                                    coord = "";
                                    u++;
                                }
                            }
                        
                        }
                        
                    } else if (data.charAt(0) == 'f') {
                        System.out.println(data);
                        
                        String coord = "";
                        u = 0;
                        
                        
                        if (data.charAt(2) == ' ') {
                            continue;
                        } else {
                            System.out.println(u + " " + j);
                            for (int i = 2; i < data.length(); i++) {
                                
                                if (data.charAt(i) != ' ') {
                                    if (i == data.length()-1) {
                                        coord += data.charAt(i);
                                        objFaces[j][u] = coord;
                                        System.out.println(coord);
                                        coord = "";
                                    } else {
                                        coord += data.charAt(i);
                                    }
                                    
                                } else {
                                    objFaces[j][u] = coord;
                                    System.out.println(coord);
                                    coord = "";
                                    u++;
                                }
                            
                            }
                            
                        }
                        
                        
                    }
                j++;
                }
            }
            myReader.close();
            System.out.println(Arrays.deepToString(objVerticies));
            System.out.println(Arrays.deepToString(objFaces));

            } catch (FileNotFoundException e) {
            System.out.println("An error occurred with file reading.");
            e.printStackTrace();
        }

    }

}

