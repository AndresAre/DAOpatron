
package practicaso1.dao;

import interfaces.DAOPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import practicaso1.Persona;

/**
 *
 * @author Asus
 */
public class DAOPersonaImpl extends Conectar implements DAOPersona {

    @Override
    public void registrar(Persona per) throws Exception {
        try{
            this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("INSERT INTO Persona(Nombres,Apellidos,Correo,Edad,Direccion) VALUES(?,?,?,?,?)");
            st.setString(1, per.getNombres());
            st.setString(2, per.getApellidos());
            st.setString(3, per.getCorreo());
            st.setInt(4, per.getEdad());
            st.setString(5, per.getDireccion());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void modificar(Persona per) throws Exception {
        try{
            this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("UPDATE Persona set nombres=?, apellidos=?, correo=?, edad=?, direccion=?  WHERE id=? ");
            st.setInt(6, per.getId());
            st.setString(1, per.getNombres());
            st.setString(2, per.getApellidos());
            st.setString(3, per.getCorreo());
            st.setInt(4, per.getEdad());
            st.setString(5, per.getDireccion());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void eliminar(Persona per) throws Exception {
        try{
            this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("DELETE from Persona WHERE id= ? ");
            st.setInt(1, per.getId());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista = null;
        try{
            this.getConnection();
            PreparedStatement st = this.getConnection().prepareStatement("SELECT * FROM Persona");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Persona per= new Persona();
                per.setId(rs.getInt("id"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setCorreo(rs.getString("correo"));
                per.setEdad(rs.getInt("edad"));
                per.setDireccion(rs.getString("direccion"));
                lista.add(per); 
            }
            rs.close();
            st.close();
        }catch(Exception e){
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
    
    
}
