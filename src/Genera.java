import java.util.Random;
public class Genera{

    public int[] Genotipo(int numero){
        Random rand = new Random();
        String binario = "";
        String x = "";
        int[] p_g = new int[numero];
        for(int i = 0; i < numero; i++){
            for(int j = 0; j < 8; j++){
                x = Integer.toString((int)(rand.nextDouble() * 2));
                binario = binario.concat(x);
            }
            p_g[i] = Integer.parseInt(binario);
            binario = "";
        }
        return p_g;
    }
    public int[][] Genera_parejas(int[] p_inicial){
        int tama = p_inicial.length/2;
        Random rand = new Random();
        int[] PA = new int[tama];
        int[] PB = new int[tama];
        int cont = 0;
        int x;
        int y;
        int[] indi = new int[p_inicial.length];
        String PAA = "";
        String PBB = "";
        for(int i = 0; i < indi.length; i++){
            indi[i] = i;
        }
        while(indi.length > 0){
            x = (int)(rand.nextDouble() * indi.length-1);
            y = (int)(rand.nextDouble() * indi.length-1);
            if(x == y){
                x = 0;
                y = 1;
            }
            if(x != y){
                PA[cont] = indi[x];
                PB[cont] = indi[y];
                PAA = PAA.concat(Integer.toString(PA[cont]));
                PAA = PAA.concat("\n");
                PBB = PBB.concat(Integer.toString(PB[cont]));
                PBB = PBB.concat("\n");
                cont++;
                indi[x] = -1;
                indi[y] = -1;
                int[] indi_aux;
                //int[] indi_aux = new int[indi.length-2];
                indi_aux = Quitar_usados(indi);
                //indi = new int[indi_aux.length];
                indi = indi_aux;
            }
        }
        //JOptionPane.showMessageDialog(null, "PA[] entrada Posicion Aleatoria= \n" + PAA + "\nPB[] entrada Posicion Aleatoria= \n" + PBB);
        int[] np1 = PadreA(PA, p_inicial);
        int[] np2 = PadreA(PB, p_inicial);
        
        String padre1 = "";
        for(int i = 0; i < np1.length; i++){
            padre1 = padre1.concat(Integer.toString(np1[i]));
            padre1 = padre1.concat("\n");
        }
        String padre2 = "";
        for(int i = 0; i < np2.length; i++){
            padre2 = padre2.concat(Integer.toString(np2[i]));
            padre2 = padre2.concat("\n");
        }
        //JOptionPane.showMessageDialog(null, "PA[] salida Binaria = \n" + padre1 + "\nPB[] salida Binaria = \n" + padre2);
        
        int[][] Salida = {np1, np2};
        return Salida;
    }
    public int[][] Mutacion(int[][] Entrada){
        Random rand = new Random();
        int y = (int)(rand.nextDouble() * 1);
        int[] Escogido;
        int[] SinEscoger;
        if(y == 0){
            Escogido = Entrada[0];
            SinEscoger = Entrada[1];
        }else{
            Escogido = Entrada[1];
            SinEscoger = Entrada[0];
        }
        int x = (int)(rand.nextDouble() * Escogido.length);
        int cambio = (int)(rand.nextDouble() * 8);
        Escogido[x] = Integer.parseInt(Integer.toString(cambio, 2));
       
        if(y == 0){
            int[][] Mutados = {Escogido, SinEscoger};
            return Mutados;
        }
        int[][] Mutados = {SinEscoger, Escogido};
        return Mutados;
    }
    public int[] a_Decimal(int[] arre){
        int Decimal;
        int[] arreglo = new int[arre.length];
        for(int i = 0; i < arreglo.length; i++){
            Decimal = Integer.parseInt(Integer.toString(arre[i]), 2);
            arreglo[i] = Decimal;
        }
        /*
        String salida = "";
        for(int i = 0; i < arreglo.length; i++){
            salida = salida.concat(Integer.toString(arreglo[i]));
            salida = salida.concat("\n");
        }
        JOptionPane.showMessageDialog(null, "Binario a Decimal = \n" + salida);
        */
        return arreglo;
    }
    public String[] a_String(int[] arre){
        //String a_imprimir = "";
        String[] Salida = new String[arre.length];
        for(int i = 0; i < arre.length; i++){
            Salida[i] = Integer.toString(arre[i]);
            //a_imprimir = a_imprimir.concat(Salida[i]);
            //a_imprimir = a_imprimir.concat("\n");
        }
        //JOptionPane.showMessageDialog(null, "Pareja a String = \n" + a_imprimir);
        return Salida;
    }
    public int[] Descendientes(int[][] Padres_Aptitud, int[][] Hijos_Aptitud){
        int[] padre1 = Padres_Aptitud[0];
        int[] padre2 = Padres_Aptitud[1];
        int[] hijo1 = Hijos_Aptitud[0];
        int[] hijo2 = Hijos_Aptitud[1];
        int[] des1 = new int[padre1.length];
        int[] des2 = new int[padre1.length];
        for(int i = 0; i < padre1.length; i++){
            if(padre1[i] >= hijo1[i]){
                des1[i] = padre1[i];
            }else{
                des1[i] = hijo1[i];
            }
        }
        for(int i = 0; i < padre2.length; i++){
            if(padre2[i] >= hijo2[i]){
                des2[i] = padre2[i];
            }else{
                des2[i] = hijo2[i];
            }
        }
        int[] Salida = new int[padre2.length*2];
        int con = 0;
        for(int i = 0; i < Salida.length; i=i+2){
            Salida[i] = des1[con];
            Salida[i+1] = des2[con];
            con++;
        }
        Salida = Raiz(Salida);
        return Salida;
    }
    public int[] Raiz(int[] arre_aptitud){
        int[] Salida = new int[arre_aptitud.length];
        int normal;
        String binario = "";
        int salida;
        for(int i = 0; i < Salida.length; i++){
            normal = (int)Math.sqrt(arre_aptitud[i]);
            binario = Integer.toBinaryString(normal);
            salida = Integer.parseInt(binario);
            Salida[i] = salida;
        }
        return Salida;
    }
    public int[] Mezcla(String padre1, String padre2){
        int[] son = new int[3];
        int aux;
        String cero;
        Random rand = new Random();
        aux = (int)(rand.nextDouble() * 8);
        if(aux == 0 || aux == 4){
            aux = 3;
        }
        if(padre1.length() < 8){
            cero = "";
            for(int i = 0; i < 8-padre1.length(); i++){
                cero = cero.concat("0");
            }
            padre1 = cero.concat(padre1);
        }
        if(padre2.length() < 8){
            cero = "";
            for(int i = 0; i < 8-padre2.length(); i++){
                cero = cero.concat("0");
            }
            padre2 = cero.concat(padre2);
        }
        String P1_parte1 = padre1.substring(0, aux);
        String P1_parte2 = padre1.substring(aux, padre1.length());
        String P2_parte1 = padre2.substring(0, aux);
        String P2_parte2 = padre2.substring(aux, padre2.length());
        String hijo1 = P1_parte1.concat(P2_parte2);
        String hijo2 = P2_parte1.concat(P1_parte2);
        son[0] = Integer.parseInt(hijo1);
        son[1] = Integer.parseInt(hijo2);
        son[2] = aux;
        /*
        JOptionPane.showMessageDialog(null, "PadreA = " + padre1 + "\nPadreB = " + padre2 + 
                "\nPartir --> " + aux +
                "\nHijoA = " + hijo1 + "\nHijoB = " + hijo2);
        */
        return son;
    }
    public int[] Aptitud(int[] arre){
        int[] Salida = new int[arre.length];
        for(int i = 0; i < Salida.length;i++){
            Salida[i] = arre[i]*arre[i];
        }
        String salida = "";
        for(int i = 0; i < Salida.length; i++){
            salida = salida.concat(Integer.toString(Salida[i]));
            salida = salida.concat("\n");
        }
        //JOptionPane.showMessageDialog(null, "Aptitud =\nAplicando f(x*x) -->\n" + salida);
        return Salida;
    }
    public int[] Quitar_usados(int[] arre){
        int[] nuevo_arre = new int[arre.length-2];
        int j = 0;
        for(int i = 0; i < arre.length; i++){
            if(arre[i] != -1){
                nuevo_arre[j] = arre[i];
                j++;
            }
        }
        return nuevo_arre;
    }
    public int[] PadreA(int[] indice, int[] padre1){
        int[] padreA = new int[padre1.length/2];
        for(int i = 0; i < padreA.length; i++){
            padreA[i] = padre1[indice[i]];
        }
        return padreA;
    }
    public int[] PadreB(int[] indice, int[] padre2){
        int[] padreB = new int[padre2.length/2];
        for(int i = 0; i < padreB.length; i++){
            padreB[i] = padre2[indice[i]];
        }
        return padreB;
    }
}