package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Equipo;

public class EquipoDao {

    Conexion conn;

    public EquipoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insertar(Equipo team) {
        String sql = "insert into equipos values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, team.getId());
            ps.setString(2, team.getNombrequipo());
            ps.setString(3, team.getNombrecapitan());
            ps.setInt(4, team.getNumintegrantes());
            ps.setString(5, team.getFechainscripcion());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Equipo> selectAll(){
        String sql = "select * from equipos";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Equipo team;
            List<Equipo> lista = new LinkedList<>();
            while (rs.next()){
                team = new Equipo(rs.getInt("id"));
                team.setNombrequipo(rs.getString("nombre_equipo"));
                team.setNombrecapitan(rs.getString("nombre_capitan"));
                team.setNumintegrantes(rs.getInt("num_integrantes"));
                team.setFechainscripcion(rs.getString("fecha_inscripcion"));
                lista.add(team);               
            }
            return lista;
        } catch (Exception e){
            return null;
        }
    }
}
