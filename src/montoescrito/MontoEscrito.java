package montoescrito;

/*
 * orlandobcrra@gmail.com
 * 10 / 04 / 2011
 * V 1.1
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author SCJP Orlando Becerra
 */
public class MontoEscrito {

    // <editor-fold defaultstate="collapsed" desc="Valores Idioma Dependientes">
    enum Idioma {

        Espanol, Ingles
    }
    private static Idioma idiomaActual;
    private static BigInteger limiteFijos;
    private static BigInteger cien;
    private static BigInteger mil;
    private static BigInteger millon;
    private static BigInteger billon;
    private static BigInteger trillon;
    private static String con;
    private static String menos;
    private static String ceroFijo;
    private static String unoFijo;
    private static String cienFijo;
    private static String unionDecena;
    private static String sufijoCien;
    private static String sufijoMil;
    private static String sufijoMillon;
    private static String sufijoMillones;
    private static String sufijoBillon;
    private static String sufijoBillones;
    private static String sufijoTrillon;
    private static String sufijoTrillones;
    private static ArrayList<Data> dataList;

    public static void init(Idioma idioma, BigInteger limiteFijos, BigInteger cien, BigInteger mil, BigInteger millon, BigInteger billon, BigInteger trillon, String con, String menos, String ceroFijo, String unoFijo, String cienFijo, String unionDecena, String sufijoCien, String sufijoMil, String sufijoMillon, String sufijoMillones, String sufijoBillon, String sufijoBillones, String sufijoTrillon, String sufijoTrillones, ArrayList<Data> dataList) {
        if (idiomaActual == null || idioma.compareTo(idiomaActual) != 0) {
            MontoEscrito.limiteFijos = limiteFijos;
            MontoEscrito.cien = cien;
            MontoEscrito.mil = mil;
            MontoEscrito.millon = millon;
            MontoEscrito.billon = billon;
            MontoEscrito.trillon = trillon;
            MontoEscrito.con = con;
            MontoEscrito.menos = menos;
            MontoEscrito.ceroFijo = ceroFijo;
            MontoEscrito.unoFijo = unoFijo;
            MontoEscrito.cienFijo = cienFijo;
            MontoEscrito.unionDecena = unionDecena;
            MontoEscrito.sufijoCien = sufijoCien;
            MontoEscrito.sufijoMil = sufijoMil;
            MontoEscrito.sufijoMillon = sufijoMillon;
            MontoEscrito.sufijoMillones = sufijoMillones;
            MontoEscrito.sufijoBillon = sufijoBillon;
            MontoEscrito.sufijoBillones = sufijoBillones;
            MontoEscrito.sufijoTrillon = sufijoTrillon;
            MontoEscrito.sufijoTrillones = sufijoTrillones;
            MontoEscrito.dataList = dataList;
        }
    }
    // </editor-fold>

    private MontoEscrito() {
    }

    /**
     * Buscar la traduccion fija en la lista de datos
     * 
     * @param tipo
     * @param numero
     * @return
     */
    private static String consulta(int numero) {
        int p = Collections.binarySearch(dataList, new Data(numero));
        return dataList.get(p).escrito;
    }

    /**
     * Metodo principal que traduce la parte entera del numero
     *
     * @param numero parte entera del numero
     * @param banderaEscribirUno solo en Español. para saber si se escribe uno o un. Emj: 121 = ciento veinte y UNO ; 1200 = UN mil docientos
     *
     * @return el monto escrito de la parte entera
     */
    private static String escribir(BigInteger numero, boolean banderaEscribirUno) {
        if (numero.compareTo(limiteFijos) <= 0) {                               // 1 - (15 / 19)
            return (unoFijo != null && banderaEscribirUno && numero.compareTo(BigInteger.ONE) == 0) // UNO / UN
                    ? unoFijo
                    : consulta(numero.intValue());
        } else if (numero.compareTo(cien) < 0) {                                // 16 - 99
            int decena = (numero.intValue() - (numero.intValue() % 10));
            return consulta(decena) + unionDecena + escribir(numero.mod(BigInteger.TEN), banderaEscribirUno);
        } else if (numero.compareTo(mil) < 0) {                                 // 100 - 999 = CIENTOS
            if (cienFijo != null && numero.compareTo(cien) == 0) {
                return cienFijo;
            }
            int centena = (numero.intValue() - (numero.intValue() % 100));
            return consulta(centena) + sufijoCien + escribir(numero.mod(cien), banderaEscribirUno);
        } else if (numero.compareTo(millon) < 0) {                              // 1.000 - 999.999 = MILES
            return escribir(numero.divide(mil), false) + sufijoMil + escribir(numero.mod(mil), banderaEscribirUno);
        } else if (numero.compareTo(billon) < 0) {                              // 1.000.000 - 999.999.999.999 = HASTA 999 MIL MILLONES
            String s = (numero.divide(millon).compareTo(BigInteger.ONE) == 0) ? sufijoMillon : sufijoMillones;
            return escribir(numero.divide(millon), false) + s + escribir(numero.mod(millon), banderaEscribirUno);
        } else if (numero.compareTo(trillon) < 0) {
            String s = (numero.divide(billon).compareTo(BigInteger.ONE) == 0) ? sufijoBillon : sufijoBillones;
            return escribir(numero.divide(billon), false) + s + escribir(numero.mod(billon), banderaEscribirUno);
        } else {
            String s = (numero.divide(trillon).compareTo(BigInteger.ONE) == 0) ? sufijoTrillon : sufijoTrillones;
            return escribir(numero.divide(trillon), false) + s + escribir(numero.mod(trillon), banderaEscribirUno);
        }
    }

    /**
     * Traduccion de el numero
     *
     * @param numero numero completo
     * @param escribirDecimal escribir la parte decimal?
     * @return el monto escrito
     */
    private static String escribir(BigDecimal numero, boolean escribirDecimal) {
        BigInteger parteEntera = numero.toBigInteger();
        String enteroTexto = "";
        if (parteEntera.compareTo(BigInteger.ZERO) == 0) {
            enteroTexto = ceroFijo;
        } else {
            if (parteEntera.compareTo(BigInteger.ZERO) < 0) {
                enteroTexto = menos + " ";
                parteEntera = parteEntera.negate();
            }
            enteroTexto += escribir(parteEntera, true);
        }
        enteroTexto = enteroTexto.trim();

        String decimalTexto = "";

        if (escribirDecimal) {
            decimalTexto = " " + con + " ";
            String string = numero.toPlainString();
            int desde = string.indexOf('.') + 1;
            if (desde == 0) {
                decimalTexto += "00/100";
            } else {
                int hasta = desde + 2;
                String ceroDerecha = "";
                if (hasta > string.length()) {   // Ejm: 1.3 = 1.30
                    hasta = string.length();
                    ceroDerecha = "0";
                }
                decimalTexto += string.substring(desde, hasta) + ceroDerecha + "/100";
            }
        }
        return enteroTexto + decimalTexto;
    }

    /**
     * Traduccion del numero
     *
     * @param numero numero completo
     * @param redondear verdadero si quiere redendoar a 2 digitos decimales. Ejm: 1.456 = 1.46
     * @param escribirDecimal verdadero si quiere escribir la parte decimal del numero
     * @return monto escrito
     */
    static String escribir(BigDecimal numero, boolean redondear, boolean escribirDecimal) {
        byte cantDecimales = 4;
        if (redondear) {
            cantDecimales = 2;
        }
        String numeroTexto = numero.toPlainString();
        if (numeroTexto.indexOf('.') != -1) {
            int digitosEnteros = numeroTexto.substring(0, numeroTexto.indexOf('.')).length();
            numero = numero.round(new MathContext(digitosEnteros + cantDecimales));
        }
        System.out.println(numero.toPlainString());
        return escribir(numero, escribirDecimal);
    }
}

/**
 *
 * @author orlandobcrra
 */
class Data implements Comparable<Data> {

    public Integer numero;
    public String escrito;

    public Data(Integer numero) {
        this.numero = numero;
        this.escrito = null;
    }

    public Data(Integer numero, String escrito) {
        this.numero = numero;
        this.escrito = escrito;
    }

    /**
     * Para poder aplicar busqueda binaria,
     * los elemento de una coleccion tienen que estar ordenados.
     * see Collections.binarySearch()
     * 
     * @param o
     * @return
     */
    public int compareTo(Data o) {
        return numero.compareTo(o.numero);
    }
}
