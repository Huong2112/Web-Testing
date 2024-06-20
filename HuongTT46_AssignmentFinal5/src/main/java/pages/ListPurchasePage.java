package pages;

import core.BasePage;
import org.checkerframework.common.reflection.qual.ForName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Pattern;

public class ListPurchasePage extends BasePage {
    public ListPurchasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'alert alert-success')]")
    private WebElement messageAddPurchaseSuccessfully;


    @FindBy(xpath = "//table[@id='POData']/tbody/tr")
    private List<WebElement> listPurchase;
    @FindBy(xpath = "//table[@id='POData']/tbody/tr/td[position()=2]")
    private List<WebElement> datesText;

    @FindBy(xpath = "//table[@id='POData']/tbody/tr/td[position()=3]")
    private List<WebElement> referenceNos;


    public boolean verifyPurchaseNumber(int numberOfPurchase){
        System.out.println(listPurchase.size());
        return listPurchase.size() == numberOfPurchase;

    }



    public boolean verifyDateTimeFormat(String datePattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        boolean result = true;
        Pattern pattern = Pattern.compile(datePattern);
        for (WebElement dateText : datesText){
            String date = dateText.getText();
            if (!pattern.matcher(date).matches()){
                result = false;
                break;
            } else {
                try {
                    dateFormat.parse(date);
                } catch (ParseException e) {
                    return false;
                }
            }

        }
        return result;
    }


    public boolean verifyOderNoDesc(){
        boolean result = true;
        for (int i  = 0;  i < referenceNos.size() -1; i++){
           String s1 = referenceNos.get(i).getText();
           String s2 = referenceNos.get(i+1).getText();
           if (s1.compareTo(s2) < 0 ){
               result = false;
               break;
           }
        }
        return result;
    }

    public boolean verifyAddSuccessfully(String expMessage){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        String script = "var element = arguments[0];" +
                "var child = element.querySelector('.close');" +
                "if (child) child.remove();" +
                "return element.textContent.trim();";
        String text = (String) js.executeScript(script, messageAddPurchaseSuccessfully);

       return text.equals(expMessage.trim());
    }


}
