package montoescrito;

/*
 * luis.gonzalez@tsj.gob.ve
 * 02 / 08 / 2014
 * V 1.1
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Luis Gonzalez
 */
public class ValorOrdinal {

    // <editor-fold defaultstate="collapsed" desc="Valores Español">
    private static final BigInteger limiteFijos = BigInteger.valueOf(15l);
    private static final BigInteger cien = BigInteger.valueOf(100l);
    private static final BigInteger mil = BigInteger.valueOf(1000l);
    private static final BigInteger millon = BigInteger.valueOf(1000000l);
    private static final BigInteger billon = BigInteger.valueOf(1000000000000l);
    private static final BigInteger trillon = BigInteger.valueOf(1000000000000000000l);
    private static final String con = "CON";
    private static final String menos = "MENOS";
    private static final String ceroFijo = "Cero";
    private static final String unoFijo = "Primero";
    private static final String cienFijo = "Centésimo";
    private static final String unionDecena = " ";
    private static final String sufijoCien = " ";
    private static final String sufijoMil = " Milésimo ";
    private static final String sufijoMillon = " Millonésimo ";
    private static final String sufijoMillones = " Millonésimo ";
    private static final String sufijoBillon = " Billonésimo ";
    private static final String sufijoBillones = " Billonésimo ";
    private static final String sufijoTrillon = " Trillonésimo ";
    private static final String sufijoTrillones = " Trillonésimo ";
    private static final ArrayList<Data> dataList = new ArrayList<Data>(0);

    static {
        dataList.add(new Data(0, ""));
        dataList.add(new Data(1, "Primer"));
        dataList.add(new Data(2, "Segundo"));
        dataList.add(new Data(3, "Tercero"));
        dataList.add(new Data(4, "Cuarto"));
        dataList.add(new Data(5, "Quinto"));
        dataList.add(new Data(6, "Sexto"));
        dataList.add(new Data(7, "Séptimo"));
        dataList.add(new Data(8, "Octavo"));
        dataList.add(new Data(9, "Noveno"));
        dataList.add(new Data(10, "Décimo"));
        dataList.add(new Data(11, "Decimo Primero"));
        dataList.add(new Data(12, "Decimo Segundo"));
        dataList.add(new Data(13, "Decimo Tercero"));
        dataList.add(new Data(14, "Decimo Cuarto"));
        dataList.add(new Data(15, "Decimo Quinto"));
        dataList.add(new Data(20, "Vigésimo"));
        dataList.add(new Data(30, "Trigésimo"));
        dataList.add(new Data(40, "Cuatrigésimo"));
        dataList.add(new Data(50, "Quincuagésimo"));
        dataList.add(new Data(60, "Sexagésimo"));
        dataList.add(new Data(70, "Septuagésimo"));
        dataList.add(new Data(80, "Octagésimo"));
        dataList.add(new Data(90, "Nonágesimo"));
        dataList.add(new Data(100, "Centésimo"));
        dataList.add(new Data(200, "Ducentésimo"));
        dataList.add(new Data(300, "Tricentésimo"));
        dataList.add(new Data(400, "Cuadrigentésimo"));
        dataList.add(new Data(500, "Quingentésimo"));
        dataList.add(new Data(600, "Sexcentésimo"));
        dataList.add(new Data(700, "Septincentésimo"));
        dataList.add(new Data(800, "Octincentésimo"));
        dataList.add(new Data(900, "Nonincentésimo"));
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
        return escribir(monto, true, false);
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
     * @return el monto expresado en Español, redondeado y sin parte decimal
     */
    public static String escribir(Double monto) {
        return escribir(monto, true, false);
    }
    
    /**
     *
     * @param monto valor dado en Integer a escribir
     * @return el monto expresado en Español, redondeado y sin parte decimal
     */
    public static String escribir(Integer monto) {
        return escribir(monto.toString(), true, false);
    }
   
}
