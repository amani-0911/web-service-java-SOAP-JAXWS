package cient;

import ws.BanqueService;
import ws.BanqueWS;
import ws.Compte;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class clientWS {
    public static void main(String[] args)   {


        BanqueService proxyWS=new BanqueWS().getBanqueServicePort();
        double res=proxyWS.conversionEuroToDH(10);
        System.out.println("Resultat="+res);
        Compte cp=proxyWS.getCompte(1L);
        System.out.println("------------getCompte----------------");
        System.out.println("code\tsolde\tdateCreation\tActive");
        LocalDate date=LocalDate.of(cp.getDateCreation().getYear(),cp.getDateCreation().getMonth(),cp.getDateCreation().getDay());
        System.out.println(cp.getCode()+"\t"+cp.getSolde()+"\t"+date +"\t"+cp.isActive());
        System.out.println("----------------------------------------");
        System.out.println("------------getAllConptes----------------");
        System.out.println("code\tsolde\tdateCreation\tActive");
        proxyWS.listComptes().forEach(c->{
            System.out.println(c.getCode()+"\t"+c.getSolde()+"\t"+c.getDateCreation() +"\t"+c.isActive());

        });

    }
}
