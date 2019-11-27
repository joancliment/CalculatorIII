import java.util.ArrayList;
import java.util.List;

public class Calc {

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public static boolean ComprobarDecyPunt(String cadena) {

        boolean Resultado = false;
        boolean NegativoOk = false;
        int NumPuntos = 0;
        int NumSigNeg = 0;
        int k=0;

        for (int j = 0; k < cadena.length(); j++) {
            k = j + 1;

            if (cadena.substring(j, k).contains(".")) {
                NumPuntos++;
            }

            if (cadena.substring(j, k).contains("-")) {
                if (j==0) {
                    NegativoOk = true;
                }
                NumSigNeg++;
            }

        }

        Resultado = true;

        if (NumPuntos > 1) {
            Resultado = false;
        } else {
            if (NegativoOk) {
                if (NumSigNeg > 1) {
                    Resultado = false;
                }
            }
        }
        return Resultado;
    }

    public static String NumberExit(List<String> NumN1) {


        boolean hay_decimales = false;
        double NumberSal1 = 0;
        int NumberSal2 = 0;

        String Salida1 = "";


        hay_decimales = false;
        NumberSal1 = 0.0;
        NumberSal2 = 0;

        for (int i = 0; (i <= NumN1.size() - 1); i++) {
            if ((NumN1.get(i).contains("."))) {
                hay_decimales = true;
                NumberSal1 = Double.valueOf(NumN1.get(i)) + NumberSal1;
            } else {
                NumberSal2 = Integer.valueOf(NumN1.get(i)) + NumberSal2;
            }

        }


        if (hay_decimales) {

            NumberSal1 = NumberSal1 + NumberSal2;
            Salida1 = String.valueOf(NumberSal1);
        } else {
            Salida1 = String.valueOf(NumberSal2);
        }

        return Salida1;

    }


    public String AddStrings(String numberEnt) {

        /*   String NumN []; */

        List<String> NumN;
        NumN = new ArrayList<String>();

        // int Ext = 1;
        // int t = 0;

        int x = 0;
        int y = 0;
        int z = 0;
        int yok = 0;
        int zok = 0;
        int long1 = 0;
        int zAct = 1;
        int zAnt = 2;

        boolean hay_numero = false;
        String SalidaN = "";

        // String[] lista1 = numberEnt.split("\\.");


        boolean empty;
        if (numberEnt.isEmpty()) empty = true;
        else empty = false;

        if (empty) {
            return "";
        } else {
            long1 = (numberEnt.length());

            x = 0;

            while (x < long1) {
                hay_numero = false;
                y = x;
                yok = x;
                zok = x;

                while (y < long1 && zAct < zAnt) {

                    z = y + 1;

                    if (isNumeric((numberEnt.substring(y, z))) == true) {
                        hay_numero = true;
                        zok = z;
                        y++;
                    } else {
                        if (((numberEnt.substring(y, z)).contains(".") == true) || ((numberEnt.substring(y, z)).contains("-") == true)) {
                            zok = z;
                            y++;
                        } else {
                            zAct = zAnt + 1;
                        }

                    }

                }

                if (hay_numero) {
                    hay_numero = ComprobarDecyPunt(numberEnt.substring(yok, zok));
                }


                if (hay_numero == true)  {
                    NumN.add(numberEnt.substring(yok, zok));
                    zAnt = zAct + 1;
                    x = z;

                } else {
                    zAnt = zAct + 1;
                    x = z;
                }
            }

            SalidaN = NumberExit(NumN);

            return SalidaN;

        }

    }

}
