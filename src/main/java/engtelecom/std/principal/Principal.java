package engtelecom.std.principal;

public class Principal {

    ClienteRest c = new ClienteRest();
    System.out.println(c.olaJSON());
    System.out.println(c.olaTexto());
    System.out.println(c.olaXML());
    System.out.println(c.olaOutroXML("STD"));
    c.close();


    public static void main(String[] args) {
        int i = somar(10, 2);
        int j = subtrair(10, 2);
        System.out.println("i: " + i + ", j: " + j);
    }

    private static int somar(int a, int b) {
        engtelecom.std.Calculadora_Service service = new engtelecom.std.Calculadora_Service();
        engtelecom.std.Calculadora port = service.getCalculadoraPort();
        return port.somar(a, b);
    }

    private static int subtrair(int a, int b) {
        engtelecom.std.Calculadora_Service service = new engtelecom.std.Calculadora_Service();
        engtelecom.std.Calculadora port = service.getCalculadoraPort();
        return port.subtrair(a, b);
    }
}

