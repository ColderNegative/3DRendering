## Object file importing
- currently very convoluted 
- add automation to calculating number of faces and verticies
- loop through each line and check for if there is a solo 'v' or 'f' character
- have a method that pulls vertex data
- hava method that pulls face data
- join 2d arrays into 3d array which can be pulled into the vector objects file
- in the vector objects file the data will put into object arrays 
- the object arrays will then be put through the matrix file where rotation and projection will be solved 
- the data will then be converted to an array of 2d points 
- another array will indicate the connections for the faces which are triangles 

## update 2: 11 September 
- all object files can be placed in a folder which will be indexed by the getObjFiles method
- getfilemeta method pulls the number of faces, vertecies, normals, and textures from the file
