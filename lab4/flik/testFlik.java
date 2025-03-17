package flik;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
public class testFlik {
    @Test
    public void test(){
        int a=5,b=5;
        Assert.assertTrue(Flik.isSameNumber(a,b));
    }
}
