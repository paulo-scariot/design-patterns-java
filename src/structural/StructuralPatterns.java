package structural;

import structural.Facade.BankingFacade;
import structural.adapter.LegacyPrinter;
import structural.adapter.ModernPrinter;
import structural.adapter.PrinterAdapter;
import structural.bridge.Implementer.BankAProcessor;
import structural.bridge.Implementer.BankBProcessor;
import structural.bridge.abstraction.CreditCardPayment;
import structural.bridge.abstraction.PayPalPayment;
import structural.bridge.abstraction.Payment;
import structural.composite.File;
import structural.composite.Folder;
import structural.decorator.*;
import structural.flyweight.FontFactory;
import structural.flyweight.FontStyle;
import structural.proxy.Image;
import structural.proxy.ProxyImage;

public class StructuralPatterns {
    public static void run() {
        // O Adapter permite a colaboração de objetos incompatíveis.
        System.out.println("\nAdapter");
        ModernPrinter modernPrinter = new ModernPrinter();
        modernPrinter.print();
        PrinterAdapter adapter = new PrinterAdapter(new LegacyPrinter());
        adapter.print();

        // O Bridge divide a lógica de negócio ou uma enorme classe em hierarquias de classe separadas que podem ser desenvolvidas independentemente.
        System.out.println("\nBridge");
        Payment creditCardPayment = new CreditCardPayment(new BankAProcessor());
        creditCardPayment.pay("100.00");
        Payment payPalPayment = new PayPalPayment(new BankBProcessor());
        payPalPayment.pay("200.00");

        // O Composite permite compor objetos em uma estrutura semelhante a uma árvore e trabalhar com eles como se fosse um objeto singular.
        System.out.println("\nComposite");
        File file1 = new File("document.txt");
        File file2 = new File("photo.jpg");
        File file3 = new File("video.mp4");
        Folder documentsFolder = new Folder("Documents");
        documentsFolder.addComponent(file1);
        Folder mediaFolder = new Folder("Media");
        mediaFolder.addComponent(file2);
        mediaFolder.addComponent(file3);
        Folder rootFolder = new Folder("Root");
        rootFolder.addComponent(documentsFolder);
        rootFolder.addComponent(mediaFolder);
        rootFolder.showDetails();

        // O Decorator permite adicionar novos comportamentos aos objetos dinamicamente, colocando-os dentro de objetos wrapper especiais.
        System.out.println("\nDecorator");
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("out/OutputDemo.txt")));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource("out/OutputDemo.txt");

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());

        // O Facade fornece uma interface simplificada (mas limitada) para um sistema complexo de classes, biblioteca, ou framework.
        System.out.println("\nFacade");
        BankingFacade bankingFacade = new BankingFacade();
        bankingFacade.withdrawMoney("ACC123", "1234", 500);
        bankingFacade.transferMoney("ACC123", "ACC456", "1234", 300);

        // O Flyweight permite que os programas suportem grandes quantidades de objetos, mantendo baixo o consumo de memória.
        System.out.println("\nFlyweight");
        FontStyle font1 = FontFactory.getFont("Arial", 12, "Black");
        FontStyle font2 = FontFactory.getFont("Arial", 12, "Black");
        font1.applyStyle("H");
        font2.applyStyle("c");

        // O Proxy fornece um objeto que atua como um substituto para um objeto de serviço real usado por um cliente.
        // Um proxy recebe solicitações do cliente, realiza alguma tarefa (controle de acesso, armazenamento em cache etc.) e passa a solicitação para um objeto de serviço.
        System.out.println("\nFlyweight");
        Image image = new ProxyImage("high_res_image.jpg");
        image.display();
        image.display();
    }
}
