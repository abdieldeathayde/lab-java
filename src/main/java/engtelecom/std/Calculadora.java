package engtelecom.std;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "Calculadora")
public class Calculadora {

    @WebMethod(operationName = "somar")
    public int somar(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        int c = a + b;
        return c;
    }

    @WebMethod(operationName = "subtrair")
    public int subtrair(@WebParam(name = "a") int a, @WebParam(name = "b") int b) {
        int c = a - b;
        return c;
    }
}

public class Principal {

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

@Path("olamundo")
public class OlaMundo {
    @Context
    private UriInfo context;

    public OlaMundo() {
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String olaTexto() {
        return "Ola Mundo";
    }

    @GET
    @Produces("application/xml")
    public String olaXML() {
        return "<?xml version=\"1.0\"?>" + "<mensagem>Ola Mundo" + "</mensagem>";
    }

    @GET
    @Produces("application/json")
    public String olaJSON() {
        return "{ \"mensagem\": \"Ola Mundo\" }";
    }

    @Path("/{nome}")
    @GET
    @Produces("application/xml")
    public String olaOutroXML(@PathParam("nome") String n) {
        return "<?xml version=\"1.0\"?>" + "<mensagem>" + n + "</mensagem>";
    }

    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/xml")
    public String recebeParametroViaFORM(@FormParam("nome") String nome) {
        return "<?xml version=\"1.0\"?>" + "<mensagem>" + nome + "</mensagem>";
    }
}

public class Principal {
    public static void main(String[] args) {
        ClienteRest c = new ClienteRest();
        System.out.println(c.olaJSON());
        System.out.println(c.olaTexto());
        System.out.println(c.olaXML());
        System.out.println(c.olaOutroXML("STD"));
        c.close();
    }
}
