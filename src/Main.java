import java.util.Random;
import javax.swing.JOptionPane;
public class Main{
    public static void main(String[] args){
        Genera prueba = new Genera();
        Imprime prueba2 = new Imprime();
        Random rand = new Random();
        int muta = 0;
        
        String tama = JOptionPane.showInputDialog(null, "Tamaño de la poblacion inicial\n");
        int[] inicial = prueba.Genotipo(Integer.parseInt(tama));
        int[][] Parejas;
        
        String gene = JOptionPane.showInputDialog(null, "Numero de Generaciones\n");
        
        for(int j = 0; j < Integer.parseInt(gene); j++){
            Parejas = prueba.Genera_parejas(inicial);
            int[][] Decimal_Padre = {prueba.a_Decimal(Parejas[0]), prueba.a_Decimal(Parejas[1])};
          
            muta = (int)(rand.nextDouble() * Integer.parseInt(gene)+1);
            
            if(muta == j){
                Parejas = prueba.Mutacion(Parejas);
            }
            
            int[][] Aptitud_Padre = {prueba.Aptitud(Decimal_Padre[0]), prueba.Aptitud(Decimal_Padre[1])};
            String[][] String_Parejas = {prueba.a_String(Parejas[0]), prueba.a_String(Parejas[1])};
            
            int[] hijo1 = new int[String_Parejas[0].length];
            int[] hijo2 = new int[String_Parejas[1].length];
            String[] pareja1 = String_Parejas[0];
            String[] pareja2 = String_Parejas[1];
            int partir = 0;
            for(int i = 0; i < Integer.parseInt(tama)/2; i++){
                int[] hijo = prueba.Mezcla(pareja1[i], pareja2[i]);
                hijo1[i] = hijo[0];
                hijo2[i] = hijo[1];
                partir = hijo[2];
            }
            int[][] Mezcla = {hijo1, hijo2};
            int[][] Decimal_Hijo = {prueba.a_Decimal(Mezcla[0]), prueba.a_Decimal(Mezcla[1])};
            int[][] Aptitud_Hijo = {prueba.Aptitud(Decimal_Hijo[0]), prueba.Aptitud(Decimal_Hijo[1])};
            int[] Descendencia = prueba.Descendientes(Aptitud_Padre, Aptitud_Hijo);
            
            int PAA = Mezcla[0][0];
            int PAB = Mezcla[1][0];
            
            prueba2.GEN_FEN(j+1, prueba.a_Decimal(inicial), inicial);
            
            prueba2.detalle(Parejas[0][0], Parejas[1][0], Decimal_Padre[0][0], Decimal_Padre[1][0], 
                            PAA, PAB, Decimal_Hijo[0][0], Decimal_Hijo[1][0], partir, muta, j);
            
            
            
            inicial = Descendencia;
        }
    }
}