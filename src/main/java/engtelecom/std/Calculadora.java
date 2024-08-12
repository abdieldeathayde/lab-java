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




