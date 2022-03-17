package ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "ConversionEuroToDH")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*11.3;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") Long code){
          return new Compte(code,Math.random()*8000000,new Date(),true);
    }

    @WebMethod
    public List<Compte> listComptes(){
        List<Compte> comptes=
                Arrays.asList(new Compte(1l,Math.random()*8000000,new Date(),true),new Compte(2l,Math.random()*8000000,new Date(),true));
        return comptes;
    }

}
