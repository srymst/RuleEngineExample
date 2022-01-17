import Model.Product;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class Main {
    public static final void main(String[] args) {
        KieContainer kc = KieServices.Factory.get().getKieClasspathContainer();
        System.out.println(kc.verify().getMessages().toString());
        execute( kc );
    }

    public static void execute( KieContainer kc ) {
        KieSession ksession = kc.newKieSession("ShoppingKS");

        Product productA = new Product();
        productA.setID("A");
        productA.setCount(1);
        productA.setPrice(50);

        ksession.insert( productA );

        Product productB = new Product();
        productB.setID("B");
        productB.setCount(1);
        productB.setPrice(30);

        ksession.insert( productB );

        Product productC = new Product();
        productC.setID("C");
        productC.setCount(1);
        productC.setPrice(20);

        ksession.insert( productC );


        //FactHandle productPurchaseHandle = ksession.insert( new Product() );

        ksession.fireAllRules();

        //ksession.delete( productPurchaseHandle );
        System.out.println( "All rules fired." );
        ksession.fireAllRules();
    }

}
