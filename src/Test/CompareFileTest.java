package Test;

import Project_LA2.Configuration;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompareFileTest {

    @Test
    public void test01() throws IOException {

        String path1 = Configuration.idOutput;
        String path2 = "/Users/wujiaqi/Desktop/phase2_output.txt";
        boolean flag = false;
        FileReader fr1 = new FileReader(path1);
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader(path2);
        BufferedReader br2 = new BufferedReader(fr2);
        String str1;
        String str2;
        int t=0;
        int num = 0;
        while(num<824450){
            str1 = br1.readLine();
            str2 = br2.readLine();
            System.out.print(str1.length());
            System.out.print(str2.length());
            /*if(!str1.substring(0,18).equals(str2.substring(0,18))){
                flag = true;
                t++;
            }*/
            if(!str1.equals(str2)){
                flag = true;
                t++;
            }
            num++;
        }
        System.out.println(t);
        br2.close();
        fr2.close();
        br1.close();
        fr1.close();

        Assert.assertEquals(flag,false);
    }
}
