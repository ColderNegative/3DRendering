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

        for (int i = 0; i < fileContents.length; i++) {
            String line = fileContents[i];
            if (line.length() != 0 ) {
            if ( "" + line.charAt(0) + line.charAt(1) == "v ") {
                for (int j = 0; j < fileContents[i].length(); j++) {
                    System.out.println(line.charAt(j));
                
                }   

            }

            }
        }

        return null;
    }

    
    
}
