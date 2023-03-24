import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Даниил\\Desktop\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.playtech.ee");

        WebElement internshipTab = driver.findElement(
                By.cssSelector("body > header:nth-child(2) > div:nth-child(1) > nav:nth-child(3) > a:nth-child(5)")
        );
        internshipTab.click();

        boolean isInternshipShown = driver.getPageSource().contains("Development QA Engineer (Intern)");

        if (isInternshipShown) {
            createAndWriteToFile("The Internship is shown on the page.");
        } else {
            createAndWriteToFile("The Internship is not shown on the page.");
        }
    }

    public static void createAndWriteToFile(String result){
        String filename = "result.txt";
        try {
            File myObj = new File(filename);
            myObj.createNewFile();
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(result);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Smth went wrong... :(");
            e.printStackTrace();
        }
    }
}