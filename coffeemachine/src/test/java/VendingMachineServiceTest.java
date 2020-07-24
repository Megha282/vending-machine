import com.vendingmachine.beverages.BeverageType;
import com.vendingmachine.exceptions.OutOfStockException;
import com.vendingmachine.manager.BeverageManagerFactory;
import com.vendingmachine.service.VendingMachineService;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingMachineServiceTest {

    private static VendingMachineService vendingMachineService;

    @BeforeClass
    public static void initOutlets() {
        vendingMachineService = new VendingMachineService(5, new BeverageManagerFactory());
    }

    @Test
    public void testPrepareBeverage() {
        final Thread coffee = prepareBeverage(BeverageType.COFFEE);
        final Thread hotWater = prepareBeverage(BeverageType.HOT_WATER);
        final Thread hotMilk = prepareBeverage(BeverageType.HOT_MILK);
        final Thread elaichiTea = prepareBeverage(BeverageType.ELAICHI_TEA);
        final Thread gingerTea = prepareBeverage(BeverageType.GINGER_TEA);

        coffee.start();
        hotWater.start();
        hotMilk.start();
        elaichiTea.start();
        gingerTea.start();

        try {
            coffee.join();
            hotWater.join();
            hotMilk.join();
            elaichiTea.join();
            gingerTea.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private Thread prepareBeverage(final BeverageType beverageType) {
        final Runnable runnable = () -> {
            try {
                vendingMachineService.prepareBeverage(beverageType);
            } catch (final Exception ex) {
                if(ex instanceof OutOfStockException){
                    System.out.println(ex.getMessage() + " for "+ beverageType.name());

                }else{
                    System.out.println(ex.getMessage());

                }
            }
        };

        return new Thread(runnable);
    }

}
