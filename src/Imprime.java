
import javax.swing.JOptionPane;

public class Imprime{
    public String print(int[] Generacion){
        String Salida = "";
        //int j = 0;
        for(int i = 0; i < Generacion.length; i++){
            Salida = Salida.concat(Integer.toString(Generacion[i]));
            //Salida = Salida.concat("-");
            //if(j == 10){
                Salida = Salida.concat("\n                              ");
                //j = -1;
           // }
            //j++;            
        }
        return Salida;
    }
    public String printBinary(int[] Binario){
        String Salida = "";
        for(int i = 0; i < Binario.length; i++){
            Salida = Salida.concat(completa(Binario[i]));
                Salida = Salida.concat("\n                                             ");
        }
        return Salida;
    }
    public void GEN_FEN(int j, int[] Decimal, int[] Binario){
        System.out.print("                              FENOTIPO" + "\n                              Elementos de la Generacion " +
        j + "\n                              "  + print(Decimal));
        
        System.out.print("               GENOTIPO" + "\n                                             Elementos de la Generacion " +
        j + "\n                                             " + printBinary(Binario));
    }
    
    public void detalle(int PadreA, int PadreB, int Decimal_PA, int Decimal_PB, int HijoA, int HijoB, int Decimal_HA, int Decimal_HB, int partir, int muta, int gene){

        String PadreAA = completa(PadreA);
        String PadreBB = completa(PadreB);
        String HijoAA = completa(HijoA);
        String HijoBB = completa(HijoB);
        
        System.out.print("\n" + "----------->DETALLES<----------\n" +
                "MUTACION\n" + "Generacion == Muta ---> Mutacion\n" +
                "Generacion = " + gene + " --- " + "Muta = " + muta +
                "\nPADRES\n" +
                    "PadreA----\n" +
                                        "Binario  - " + PadreAA +
                                        "\nDecimal - " + Decimal_PA +
                    "\nPadreB----\n" + 
                                         "Binario  - " + PadreBB +
                                        "\nDecimal - " + Decimal_PB +
                    "\nMEZCLA\n" + 
                         "Partir en la Posicion = " + (partir-1) +
                    
                         "\nA\n" +
                                 PadreAA.substring(0, partir) + " + " +
                                         PadreBB.substring(partir, 8) +
                          "\nB\n" +
                                 PadreBB.substring(0, partir) + " + " +
                                         PadreAA.substring(partir, 8) +
                    
                    "\nHIJOS\n"  +
                    "HijoA----\n" +
                                        "Binario  - " + HijoAA +
                                        "\nDecimal - " + Decimal_HA +
                    "\nHijoB----\n" + 
                                         "Binario  - " + HijoBB +
                                        "\nDecimal - " + Decimal_HB + 
                "\n#####################################################\n");
        
    }
    public int[] join(int[][] Decimal_Elemento){
        int[] aux1 = Decimal_Elemento[0];
        int[] aux2 = Decimal_Elemento[1];
        int[] Salida = new int[aux1.length*2];
        int cont = 0;
        for(int i = 0; i < Salida.length; i= i+2){
            Salida[i] = aux1[cont];
            Salida[i+1] = aux2[cont];
        }
        return Salida;
    }
    public String completa(int incompleto){
        String salida = Integer.toString(incompleto);
        String cero = "";
        for(int i = salida.length(); i < 8; i++){
            cero = cero.concat("0");
        }
        salida = cero.concat(salida);
    return salida;
    }
}