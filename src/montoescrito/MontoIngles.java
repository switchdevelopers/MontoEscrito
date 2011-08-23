package montoescrito;

/*
 * orlandobcrra@gmail.com
 * 10 / 04 / 2011
 * V 1.1
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author SCJP Orlando Becerra
 *
 */
public class MontoIngles {

    // <editor-fold defaultstate="collapsed" desc="Valores Ingles">
    private static final BigInteger limiteFijos = BigInteger.valueOf(19l);
    private static final BigInteger cien = BigInteger.valueOf(100l);
    private static final BigInteger mil = BigInteger.valueOf(1000l);
    private static final BigInteger millon = BigInteger.valueOf(1000000l);
    private static final BigInteger billon = BigInteger.valueOf(1000000000l);
    private static final BigInteger trillon = BigInteger.valueOf(1000000000000l);
    private static final String con = "WHIT";
    private static final String menos = "MINUS";
    private static final String ceroFijo = "ZERO";
    private static final String unoFijo = "ONE";
    private static final String cienFijo = "ONE HUNDRED";
    private static final String unionDecena = " ";
    private static final String sufijoCien = " HUNDRED ";
    private static final String sufijoMil = " THOUSAND ";
    private static final String sufijoMillon = " MILLON ";
    private static final String sufijoMillones = sufijoMillon;
    private static final String sufijoBillon = " BILLON ";
    private static final String sufijoBillones = sufijoBillon;
    private static final String sufijoTrillon = " TRILLON ";
    private static final String sufijoTrillones = sufijoTrillon;
    private static final ArrayList<Data> dataList = new ArrayList<Data>(0);

    static {
        dataList.add(new Data(0, ""));
        dataList.add(new Data(1, "ONE"));
        dataList.add(new Data(2, "TWO"));
        dataList.add(new Data(3, "THREE"));
        dataList.add(new Data(4, "FOUR"));
        dataList.add(new Data(5, "FIVE"));
        dataList.add(new Data(6, "SIX"));
        dataList.add(new Data(7, "SEVEN"));
        dataList.add(new Data(8, "EIGHT"));
        dataList.add(new Data(9, "NINE"));
        dataList.add(new Data(10, "TEN"));
        dataList.add(new Data(11, "ELEVEN"));
        dataList.add(new Data(12, "TWELVE"));
        dataList.add(new Data(13, "THIRTEEN"));
        dataList.add(new Data(14, "FOURTEEN"));
        dataList.add(new Data(15, "FIFTEEN"));
        dataList.add(new Data(16, "SIXTEEN"));
        dataList.add(new Data(17, "SEVENTEEN"));
        dataList.add(new Data(18, "EIGHTEEN"));
        dataList.add(new Data(19, "NINETEEN"));
        dataList.add(new Data(20, "TWENTY"));
        dataList.add(new Data(30, "THIRTY"));
        dataList.add(new Data(40, "FOURTY"));
        dataList.add(new Data(50, "FIFTY"));
        dataList.add(new Data(60, "SIXTY"));
        dataList.add(new Data(70, "SEVENTY"));
        dataList.add(new Data(80, "EIGHTY"));
        dataList.add(new Data(90, "NINETY"));
        dataList.add(new Data(100, "ONE"));
        dataList.add(new Data(200, "TWO"));
        dataList.add(new Data(300, "THREE"));
        dataList.add(new Data(400, "FOUR"));
        dataList.add(new Data(500, "FIVE"));
        dataList.add(new Data(600, "SIX"));
        dataList.add(new Data(700, "SEVEN"));
        dataList.add(new Data(800, "EIGHT"));
        dataList.add(new Data(900, "NINE"));
        Collections.sort(dataList);
    }
    // </editor-fold>

    private static String escribir(BigDecimal numero, boolean redondear, boolean escribirDecimal) {
        MontoEscrito.init(MontoEscrito.Idioma.Ingles, limiteFijos, cien, mil, millon, billon, trillon, con, menos, ceroFijo, unoFijo, cienFijo, unionDecena, sufijoCien, sufijoMil, sufijoMillon, sufijoMillones, sufijoBillon, sufijoBillones, sufijoTrillon, sufijoTrillones, dataList);
        return MontoEscrito.escribir(numero, redondear, escribirDecimal);
    }

    /**
     * Escribe el valor numerico de monto en Ingles
     *
     * @param monto valor dado en String a escribir
     * @param redondear si se quiere redondear a 2 decimales
     * @param escribirDecimal si se quiere escribir la parte decimal
     * @return el monto expresado en Ingles
     */
    public static String escribir(String monto, boolean redondear, boolean escribirDecimal) {
        BigDecimal numero = null;
        try {
            numero = new BigDecimal(monto);
        } catch (Exception e) {
            return "";
        }
        return escribir(numero, redondear, escribirDecimal);
    }

    /**
     * Escribe el valor numerico de monto en Ingles, redondeado y con parte decimal
     *
     * @param monto valor dado en String a escribir
     * @return el monto expresado en Ingles, redondeado y con parte decimal
     */
    public static String escribir(String monto) {
        return escribir(monto, true, true);
    }

    /**
     * Escribe el valor numerico de monto en Ingles
     *
     * @param monto valor dado en Double a escribir
     * @param redondear si se quiere redondear a 2 decimales
     * @param escribirDecimal si se quiere escribir la parte decimal
     * @return el monto expresado en Ingles
     */
    public static String escribir(Double monto, boolean redondear, boolean escribirDecimal) {
        BigDecimal numero = new BigDecimal(monto);
        return escribir(numero, redondear, escribirDecimal);
    }

    /**
     *
     * @param monto valor dado en Double a escribir
     * @return el monto expresado en Ingles, redondeado y con parte decimal
     */
    public static String escribir(Double monto) {
        return escribir(monto, true, true);
    } 
}
