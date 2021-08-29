package controlador;

import conexion.Conexion;
import dao.EquipoDao;
import java.util.List;
import java.util.Scanner;
import modelo.Equipo;

public class EquipoController {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Equipo team = new Equipo(0);
        Conexion conn = new Conexion();
        EquipoDao teamd = new EquipoDao(conn);

        System.out.println("*** INSCRIBA SU EQUIPO AL TORNEO DE FUTBOL SALA: --LOS CAMPEONES-- ***");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("| INGRESE EL NOMBRE DEL EQUIPO: |");
        team.setNombrequipo(scn.next());
        System.out.println("-------------------------------------");
        System.out.println("| INGRESE EL NOMBRE DEL CAPITÁN DEL EQUIPO: |");
        team.setNombrecapitan(scn.next());
        System.out.println("----------------------------------------------------------");
        System.out.println("| INGRESE EL NUMERO DE INTEGRANTES DEL EQUIPO MINIMO 6 Y MAXIMO 16 |");
        team.setNumintegrantes(scn.nextInt());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("| INGRESE LA FECHA DE INSCRIPCION DEL EQUIPO |");
        System.out.println("| DEBE DE INGRESAR LA FECHA SEPARADA POR GUIONES EN EL FORMATO AÑO-MES-DIA |");
        team.setFechainscripcion(scn.next());

        boolean respuesta = teamd.insertar(team);

        if (respuesta) {
            System.out.println("SU REGISTRO FUE GUARDADO CON ÉXITO");
        } else {
            System.out.println("ERROR AL GUARDAR");
        }
        
        List<Equipo> list = teamd.selectAll();
        for (Equipo team2: list) {
            System.out.println(" *** EL ID DEL USUARIO ES: " + team2.getId());
            System.out.println(" *** EL NOMBRE DEL EQUIPO ES: " + team2.getNombrequipo());
            System.out.println(" *** EL NOMBRE DEL CAPITAN DEL EQUIPO ES: " + team2.getNombrecapitan());
            System.out.println(" *** EL NUMERO DE INTEGRANTES DEL EQUIPO ES: " + team2.getNumintegrantes());
            System.out.println(" *** LA FECHA DE LA INSCRIPCION DEL EQUIPO ES: " + team2.getFechainscripcion());
            System.out.println("-----------------------------------------------------------------------------");
        }
    }
}
