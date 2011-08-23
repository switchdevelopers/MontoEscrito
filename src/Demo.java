
import montoescrito.MontoEspanol;
import montoescrito.MontoIngles;

/*
 * orlandobcrra@gmail.com
 * 10 / 04 / 2011
 * V 1.1
 */

/**
 *
 * @author Orlando Becerra
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("Español:");
        System.out.println(MontoEspanol.escribir("3331.456"));
        System.out.println(MontoEspanol.escribir(121.456));
        System.out.println("");
        System.out.println("Ingles:");
        System.out.println(MontoIngles.escribir("7.0"));
        System.out.println(MontoIngles.escribir("30.0"));
        System.out.println(MontoIngles.escribir("59.0"));
        System.out.println(MontoIngles.escribir("121.456"));
        System.out.println(MontoIngles.escribir("121.456", false, false));
        System.out.println(MontoIngles.escribir("111777.11", false, false));
        System.out.println(MontoIngles.escribir("1000000000"));
    }
}
