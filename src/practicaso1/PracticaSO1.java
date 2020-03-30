/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaso1;

import interfaces.DAOPersona;
import practicaso1.dao.DAOPersonaImpl;

/**
 *
 * @author Asus
 */
public class PracticaSO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Persona per= new Persona();
    per.setNombres("Alfredo");
    per.setApellidos("Gutierrez");
    per.setCorreo("Correoooo@gmail.com");
    per.setDireccion("Direccionazo");
    per.setEdad(100);
    
    try{
        DAOPersona dao = new DAOPersonaImpl();
        //dao.registrar(per);
        //dao.eliminar(per);
        //dao.actualizar(per);
        
       //Me funcionaron todos menos el de listar.
        for(Persona p:dao.listar()){
            System.out.println(p.getNombres()+"|"+p.getApellidos()+"|"+p.getCorreo()+"|"+p.getEdad()+"|"+p.getDireccion());
        }
    }catch(Exception e){
        System.out.println(e.getMessage());
    }
    
    }
    
}
