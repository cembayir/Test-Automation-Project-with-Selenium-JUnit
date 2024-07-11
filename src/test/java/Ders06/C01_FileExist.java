package Ders06;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {
    @Test
    public void Test() {
        System.out.println(System.getProperty("user.dir")); // <-- C:\Users\Cem\IdeaProjects\JUnitFramework

        String anaDizin = System.getProperty("user.home");
        System.out.println(anaDizin); // <-- C:\Users\Cem

        String file = "C:/Users/Cem/Desktop/test-metin.txt";
        Assert.assertTrue(Files.exists(Paths.get(file)));
    }
}
