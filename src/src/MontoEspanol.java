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
 */
public class MontoEspanol {

    // <editor-fold defaultstate="collapsed" desc="Valores Español">
    private static final BigInteger limiteFijos = BigInteger.valueOf(15l);
    private static final BigInteger cien = BigInteger.valueOf(100l);
    private static final BigInteger mil = BigInteger.valueOf(1000l);
    private static final BigInteger millon = BigInteger.valueOf(1000000l);
    private static final BigInteger billon = BigInteger.valueOf(1000000000000l);
    private static final BigInteger trillon = BigInteger.valueOf(1000000000000000000l);
    private static final String con = "CON";
    private static final String menos = "MENOS";
    private static final String ceroFijo = "CERO";
    private static final String unoFijo = "UNO";
    private static final String cienFijo = "CIEN";
    private static final String unionDecena = " Y ";
    private static final String sufijoCien = " ";
    private static final String sufijoMil = " MIL ";
    private static final String sufijoMillon = " MILLON ";
    private static final String sufijoMillones = " MILLONES ";
    private static final String sufijoBillon = " BILLON ";
    private static final String sufijoBillones = " BILLONES ";
    private static final String sufijoTrillon = " TRILLON ";
    private static final String sufijoTrillones = " TRILLONES ";
    private static final ArrayList<Data> dataList = new ArrayList<Data>(0);

    static {
        dataList.add(new Data(0, ""));
        dataList.add(new Data(1, "UN"));
        dataList.add(new Data(2, "DOS"));
        dataList.add(new Data(3, "TRES"));
        dataList.add(new Data(4, "CUATRO"));
        dataList.add(new Data(5, "CINCO"));
        dataList.add(new Data(6, "SEIS"));
        dataList.add(new Data(7, "SIETE"));
        dataList.add(new Data(8, "OCHO"));
        dataList.add(new Data(9, "NUEVE"));
        dataList.add(new Data(10, "DIEZ"));
        dataList.add(new Data(11, "ONCE"));
        dataList.add(new Data(12, "DOCE"));
        dataList.add(new Data(13, "TRECE"));
        dataList.add(new Data(14, "CATORCE"));
        dataList.add(new Data(15, "QUINCE"));
        dataList.add(new Data(20, "VEINTE"));
        dataList.add(new Data(30, "TREINTA"));
        dataList.add(new Data(40, "CUARENTA"));
        dataList.add(new Data(50, "CINCUENTA"));
        dataList.add(new Data(60, "SESENTA"));
        dataList.add(new Data(70, "SETENTA"));
        dataList.add(new Data(80, "OCHENTA"));
        dataList.add(new Data(90, "NOVENTA"));
        dataList.add(new Data(100, "CIENTO"));
        dataList.add(new Data(200, "DOSCIENTOS"));
        dataList.add(new Data(300, "TRESCIENTOS"));
        dataList.add(new Data(400, "CUATROCIENTOS"));
        dataList.add(new Data(500, "QUINIENTOS"));
        dataList.add(new Data(600, "SEISCIENTOS"));
        dataList.add(new Data(700, "SETECIENTOS"));
        dataList.add(new Data(800, "OCHOCIENTOS"));
        dataList.add(new Data(900, "NOVECIENTOS"));
        Collections.sort(dataList);
    }
    // </editor-fold>

    private static String escribir(BigDecimal numero, boolean redondear, boolean escribirDecimal) {
        MontoEscrito.init(MontoEscrito.Idioma.Espanol, limiteFijos, cien, mil, millon, billon, trillon, con, menos, ceroFijo, unoFijo, cienFijo, unionDecena, sufijoCien, sufijoMil, sufijoMillon, sufijoMillones, sufijoBillon, sufijoBillones, sufijoTrillon, sufijoTrillones, dataList);
        return MontoEscrito.escribir(numero, redondear, escribirDecimal);
    }

    /**
     * Escribe el valor numerico de monto en Español
     *
     * @param monto valor dado en String a escribir
     * @param redondear si se quiere redondear a 2 decimales
     * @param escribirDecimal si se quiere escribir la parte decimal
     * @return el monto expresado en Español
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
     * Escribe el valor numerico de monto en Español, redondeado y con parte decimal
     *
     * @param monto valor dado en String a escribir
     * @return el monto expresado en Español, redondeado y con parte decimal
     */
    public static String escribir(String monto) {
        return escribir(monto, true, true);
    }

    /**
     * Escribe el valor numerico de monto en Español
     *
     * @param monto valor dado en Double a escribir
     * @param redondear si se quiere redondear a 2 decimales
     * @param escribirDecimal si se quiere escribir la parte decimal
     * @return el monto expresado en Español
     */
    public static String escribir(Double monto, boolean redondear, boolean escribirDecimal) {
        BigDecimal numero = new BigDecimal(monto);
        return escribir(numero, redondear, escribirDecimal);
    }

    /**
     *
     * @param monto valor dado en Double a escribir
     * @return el monto expresado en Español, redondeado y con parte decimal
     */
    public static String escribir(Double monto) {
        return escribir(monto, true, true);
    }
}
