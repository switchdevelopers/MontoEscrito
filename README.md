http://es.wikipedia.org/wiki/Nombres_de_los_números_en_español

http://simple.wikipedia.org/wiki/Names_of_numbers_in_English
=============
== Usage
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
		
== Out:
Español:
3331.46
TRES MIL TRESCIENTOS TREINTA Y UNO CON 46/100
121.46
CIENTO VEINTE Y UNO CON 46/100

Ingles:
7.0
SEVEN WHIT 00/100
30.0
THIRTY WHIT 00/100
59.0
FIFTY NINE WHIT 00/100
121.46
ONE HUNDRED TWENTY ONE WHIT 46/100
121.456
ONE HUNDRED TWENTY ONE
111777.11
ONE HUNDRED ELEVEN THOUSAND SEVEN HUNDRED SEVENTY SEVEN
1000000000
ONE BILLON WHIT 00/100