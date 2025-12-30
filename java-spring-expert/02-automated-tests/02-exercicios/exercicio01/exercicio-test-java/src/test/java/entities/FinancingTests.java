package entities;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.joaodev.entities.Financing;

import factory.FinancingFactory;

public class FinancingTests {

    @Test
    public void constructorShouldCreateObjectWhenValidData(){

        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
        
        Assertions.assertEquals(100000.0, f1.getTotalAmount());
        Assertions.assertEquals(2000.0, f1.getIncome());
        Assertions.assertEquals(80, f1.getMonths());
    }

    @Test
    public void constructorShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        Assertions.assertThrows(IllegalArgumentException.class, () ->{

           FinancingFactory.createFinancing(100000.0, 2000.0, 20);
        });
    }

    @Test
    public void setTotalAmountShouldUpdateValueWhenValidData(){

        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
        double amountUpdate = 90000.0;

        f1.setTotalAmount(amountUpdate);

        Assertions.assertEquals(amountUpdate, f1.getTotalAmount());
        Assertions.assertEquals(2000.0, f1.getIncome());
        Assertions.assertEquals(80, f1.getMonths());
    }

    @Test
    public void setTotalAmountShouldThrowIllegalArgumentExceptionWhenInvalidData(){
        
        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            f1.setTotalAmount(1000000.0);
        });

        Assertions.assertEquals(100000.0, f1.getTotalAmount());
    }

    @Test
    public void setIncomeShouldUpdateValueWhenValidData(){

        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
        double incomeUpdate = 3000.0;

        f1.setIncome(incomeUpdate);

        Assertions.assertEquals(100000.0, f1.getTotalAmount());
        Assertions.assertEquals(incomeUpdate, f1.getIncome());
        Assertions.assertEquals(80, f1.getMonths());
    }

    @Test
    public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            f1.setIncome(400.0);
        });

        Assertions.assertEquals(2000.0, f1.getIncome());
    }

    @Test
    public void setMonthsShouldUpdateValueWhenValidData(){

        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);
        int monthsUpdate = 90;

        f1.setMonths(monthsUpdate);

        Assertions.assertEquals(100000.0, f1.getTotalAmount());
        Assertions.assertEquals(2000.0, f1.getIncome());
        Assertions.assertEquals(monthsUpdate, f1.getMonths());
    }

    @Test
    public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData(){

        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            f1.setMonths(20);
        });

        Assertions.assertEquals(80, f1.getMonths());
    }
    
    @Test
    public void entryShouldCalculateCorrectlyWhenCalled(){

        double expected = 20000.0;
        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertEquals(expected, f1.entry());
    }

    @Test
    public void quotaShouldCalculateCorrectlyWhenCalled(){

        double expected = 1000.0;
        Financing f1 = FinancingFactory.createFinancing(100000.0, 2000.0, 80);

        Assertions.assertEquals(expected, f1.quota());
    }
}
