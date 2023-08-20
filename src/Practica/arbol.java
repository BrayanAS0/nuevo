package Practica;


public class arbol {


	
    int numEmp;
    String nomEmp;
    float sueldo;
    arbol izq=null, der=null;    
    
 public arbol(int NumEmp, String NomEmp, float sueldo) {

     	this.numEmp = NumEmp;
        this.nomEmp = NomEmp;
        this.sueldo = sueldo;
      
    }

}

