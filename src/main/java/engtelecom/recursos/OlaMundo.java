package engtelecom.recursos;

import jdk.jfr.ContentType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;
@GetMapping(value = "/olamundo")
@PathVariable(value = ("/olamundo"))

public class OlaMundo {

    @ContentType
    private URInfo context;

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


