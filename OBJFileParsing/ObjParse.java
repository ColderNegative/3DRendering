package OBJFileParsing;

public class ObjParse {
    public static void main(String[] args) {
        
        // print module name to terminal
        System.out.println("Module: Obj file parsing");
        String[] files = ObjImport.getObjFiles("Objects");
        String[] filesContents = ObjImport.fileContents(files[0]);
        int numVert = ObjImport.getFileMeta(files[0])[0];
        ObjParse.getVert(filesContents, numVert);

    }

    public static double[][] getVert(String[] fileContents, int vertcies) {

        double[][] vertArray = new double[vertcies][3];

        for (int i = 0; i < fileContents.length; i++) {
            String line = fileContents[i];
            if (line.length() > 1 ) {
                String firstTwoChar = "" + line.charAt(0) + line.charAt(1);
                int u = 0;
                if (firstTwoChar.equals("v ")) {
                    u++;
                    String coord = "";
                    for (int j = 2; i < line.length(); j++) {
                        coord += line.charAt(j);

                    }
                    vertArray[u][1] = coord;
                } 

            }        
        }

        return null;
    }

    
    
}
