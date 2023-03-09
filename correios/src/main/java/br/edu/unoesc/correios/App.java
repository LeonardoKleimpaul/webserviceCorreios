package br.edu.unoesc.correios;

//import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import br.edu.unoesc.correios.servico.AtendeCliente;
import br.edu.unoesc.correios.servico.EnderecoERP;
import jakarta.xml.ws.Service;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World!");

        URL urlCoreios = new URL("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente?wsdl");

        QName qnameCorreios = new QName("http://cliente.bean.master.sigep.bsb.correios.com.br/",
                "AtendeClienteService");

        Service serviceCorreios = Service.create(urlCoreios, qnameCorreios);

        AtendeCliente correios = serviceCorreios.getPort(AtendeCliente.class);

        EnderecoERP endereco = correios.consultaCEP("89663000");

        System.out.println(endereco.getCidade());

    }
}
