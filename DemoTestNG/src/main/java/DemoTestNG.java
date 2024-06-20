import org.testng.annotations.Test;

public class DemoTestNG {
    @Test(priority = 1)
    public void Btest(){
        System.out.println("BTestNG");
    }
    @Test(priority = 2)
    public void Atest(){
        System.out.println("ATestNG");
    }
}
