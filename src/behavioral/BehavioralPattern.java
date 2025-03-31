package behavioral;

import behavioral.chainofresponsibility.*;
import behavioral.command.*;
import behavioral.iterador.example1.LogEntry;
import behavioral.iterador.example1.SystemLog;
import behavioral.iterador.example2.Book;
import behavioral.iterador.example2.Bookstore;
import behavioral.iterador.example2.Library;
import behavioral.iterador.example3.TreeBFSIterator;
import behavioral.iterador.example3.TreeDFSIterator;
import behavioral.iterador.example3.TreeNode;
import behavioral.mediator.ChatMediator;
import behavioral.mediator.ChatMediatorImpl;
import behavioral.mediator.User;
import behavioral.mediator.UserImpl;
import behavioral.memento.Document;
import behavioral.memento.History;
import behavioral.observable.Editor;
import behavioral.observable.LogOpenListener;
import behavioral.observable.EmailNotificationListener;
import behavioral.state.*;
import behavioral.strategy.BitcoinPayment;
import behavioral.strategy.CreditCardPayment;
import behavioral.strategy.PayPalPayment;
import behavioral.strategy.PaymentContext;
import behavioral.template.CsvProcessor;
import behavioral.template.DataProcessor;
import behavioral.template.JsonProcessor;
import behavioral.template.XmlProcessor;
import behavioral.visitor.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BehavioralPattern {
    public static void main(String[] args) {
        System.out.println("\n####################  Behavioral Patterns  ####################");

        // O Chain of Responsibility permite passar a solicitação ao longo da cadeia de handlers em potencial até que um deles lide com a solicitação.
        System.out.println("Chain of Responsibility");
        Server server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");
        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistsMiddleware(server),
                new RoleCheckMiddleware()
        );
        server.setMiddleware(middleware);
        server.logIn("user@example.com", "user_pass");
        server.logIn("admin@example.com", "admin_pass");
        server.logIn("admin@example.com", "pass");

        // O Command converte solicitações ou operações simples em objetos.
        System.out.println("\nCommand");
        String orderId = "ORD12345";
        String customerEmail = "customer@example.com";
        OrderProcessor orderProcessor = new OrderProcessor(
                new ValidateOrderCommand(orderId),
                new ProcessPaymentCommand(orderId),
                new SendConfirmationEmailCommand(customerEmail),
                new ShipOrderCommand(orderId)
        );
        orderProcessor.processOrder();
        System.out.println("\nCustomer requested order cancellation...");
        orderProcessor.cancelOrder();

        // O Iterator permite a passagem sequencial através de uma estrutura de dados complexa sem expor seus detalhes internos.
        System.out.println("\nIterator");
        System.out.println("Example 1:");
        List<LogEntry> entries = new ArrayList<>();
        entries.add(new LogEntry("2023-10-27 10:00:00", "INFO", "Application started"));
        entries.add(new LogEntry("2023-10-27 10:05:00", "WARNING", "Low memory warning"));
        entries.add(new LogEntry("2023-10-27 10:10:00", "ERROR", "Database connection failed"));
        entries.add(new LogEntry("2023-10-27 10:11:00", "INFO", "Database connection reestablished"));

        SystemLog systemLog = new SystemLog(entries);
        Iterator<LogEntry> iterator = systemLog.createIterator();

        System.out.println("Log Analysis:");
        while (iterator.hasNext()) {
            LogEntry entry = iterator.next();
            System.out.println(entry);
        }

        System.out.println("\nExample 2:");
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        Library library = new Library(Arrays.asList(book1, book2, book3));
        Bookstore bookstore = new Bookstore(Arrays.asList(book1, book2, book3));

        System.out.println("Library Books (Forward Order):");
        behavioral.iterador.example2.Iterator<Book> libraryIterator = library.createIterator();
        while (libraryIterator.hasNext()) {
            System.out.println(libraryIterator.next());
        }

        System.out.println("\nBookstore Books (Reverse Order):");
        behavioral.iterador.example2.Iterator<Book> bookstoreIterator = bookstore.createIterator();
        while (bookstoreIterator.hasNext()) {
            System.out.println(bookstoreIterator.next());
        }

        System.out.println("\nExample 3:");
        TreeNode<String> root = new TreeNode<>("A");
        TreeNode<String> nodeB = new TreeNode<>("B");
        TreeNode<String> nodeC = new TreeNode<>("C");
        TreeNode<String> nodeD = new TreeNode<>("D");
        TreeNode<String> nodeE = new TreeNode<>("E");
        TreeNode<String> nodeF = new TreeNode<>("F");
        TreeNode<String> nodeG = new TreeNode<>("G");

        root.addChild(nodeB);
        root.addChild(nodeC);
        root.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeB.addChild(nodeF);
        nodeC.addChild(nodeG);

        System.out.println("DFS Traversal (Pre-Order):");
        Iterator<TreeNode<String>> dfsIterator = new TreeDFSIterator<>(root);
        while (dfsIterator.hasNext()) {
            System.out.print(dfsIterator.next().value + " ");
        }

        System.out.println("\n\nBFS Traversal (Level-Order):");
        Iterator<TreeNode<String>> bfsIterator = new TreeBFSIterator<>(root);
        while (bfsIterator.hasNext()) {
            System.out.print(bfsIterator.next().value + " ");
        }

        // O Mediator reduz o acoplamento entre os componentes de um programa, fazendo-os se comunicar indiretamente, por meio de um objeto mediador especial.
        System.out.println("\nMediator");
        ChatMediator chatMediator = new ChatMediatorImpl();
        User alice = new UserImpl("Alice");
        chatMediator.addUser(alice);
        chatMediator.addUser(new UserImpl("Bob"));
        chatMediator.addUser(new UserImpl("Charlie"));
        alice.send("Hello, everyone!");

        // O Memento permite tirar um “retrato” do estado de um objeto e restaurá-lo no futuro.
        System.out.println("\nMemento");
        Document document = new Document("Initial content\n");
        History history = new History();
        document.write("Additional content\n");
        history.addMemento(document.createMemento());
        document.write("More content\n");
        history.addMemento(document.createMemento());
        document.restoreFromMemento(history.getMemento(1));
        System.out.println(document.getContent());

        // O Observer permite que um objeto notifique outros objetos sobre alterações em seu estado.
        System.out.println("\nObserver");
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));
        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // O State permite que um objeto altere o comportamento quando seu estado interno for alterado.
        System.out.println("\nState");
        VendingMachineContext vendingMachine = new VendingMachineContext();
        vendingMachine.setState(new ReadyState());
        vendingMachine.request();
        vendingMachine.setState(new ProductSelectedState());
        vendingMachine.request();
        vendingMachine.setState(new PaymentPendingState());
        vendingMachine.request();
        vendingMachine.setState(new OutOfStockState());
        vendingMachine.request();

        // O Strategy transforma um conjunto de comportamentos em objetos e os torna intercambiáveis dentro do objeto de contexto original.
        System.out.println("\nStrategy");
        PaymentContext context = new PaymentContext();
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.processPayment(100.0);
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.processPayment(50.0);
        context.setPaymentStrategy(new BitcoinPayment("1A2B3C4D5E6F7G8H"));
        context.processPayment(200.0);

        // O Template Method permite definir o esqueleto de um algoritmo em uma classe base e permitir que as subclasses substituam as etapas sem alterar a estrutura geral do algoritmo.
        System.out.println("\nTemplate");
        DataProcessor csvProcessor = new CsvProcessor();
        csvProcessor.process();
        DataProcessor jsonProcessor = new JsonProcessor();
        jsonProcessor.process();
        DataProcessor xmlProcessor = new XmlProcessor();
        xmlProcessor.process();

        // O Visitor permite adicionar novos comportamentos à hierarquia de classes existente sem alterar nenhum código existente.
        System.out.println("\nVisitor");
        List<FileElement> files = Arrays.asList(
                new TextFile("document.txt", 100),
                new ImageFile("photo.jpg", 12),
                new VideoFile("movie.mp4", 300)
        );
        FileSizeCalculator sizeCalculator = new FileSizeCalculator();
        for (FileElement file : files) {
            file.accept(sizeCalculator);
        }
        System.out.println("Total File Size: " + sizeCalculator.getTotalSize() + "KB");
        FileMetadataExtractor metadataExtractor = new FileMetadataExtractor();
        for (FileElement file : files) {
            file.accept(metadataExtractor);
        }


    }
}
