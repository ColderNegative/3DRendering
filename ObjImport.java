import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
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
            double[][] objFaces = new double[faces][3];
            int j = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                if (data.length() > 0) {
                    if (data.charAt(0) == 'v') {
                        
                        String coord = "";
                        int u = 0;
                        if (data.charAt(2) == ' ') {
                            break;
                        } else {
                            for (int i = 2; i < data.length(); i++) {
                                
                                if (data.charAt(i) != ' ') {
                                    if (i == data.length()-1) {
                                        coord += data.charAt(i);
                                        objVerticies[j][u] = Double.parseDouble(coord);
                                        System.out.println(coord);
                                        coord = "";
                                    } else {
                                        coord += data.charAt(i);
                                    }
                                    
                                } else if (i == data.length()-1) {
                                    
                                } else {
                                    objVerticies[j][u] = Double.parseDouble(coord);
                                    System.out.println(coord);
                                    coord = "";
                                    u++;
                                }
                            }
                            
                        }
                        j++;
                    }
                }
                
            }
            myReader.close();
            System.out.println(Arrays.deepToString(objVerticies));
            } catch (FileNotFoundException e) {
            System.out.println("An error occurred with file reading.");
            e.printStackTrace();
        }

    }

}

