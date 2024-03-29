package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        try{
            URL url = new URL("http://t.weather.itboy.net/api/weather/city/101230201");
            InputStreamReader isReader =  new InputStreamReader(url.openStream(),"UTF-8");//“UTF- 8”万国码，可以显示中文，这是为了防止乱码
            BufferedReader br = new BufferedReader(isReader);//采用缓冲式读入
            String str;
            while((str = br.readLine()) != null){
                String regex="\\p{Punct}+";
                String digit[]=str.split(regex);
                String Weather = '\n'+"城市:"+digit[22]+digit[18]+
                        '\n'+"时间:"+digit[49]+"年"+digit[50]+"月"+digit[51]+"日"+digit[53]+
                        '\n'+"温度:"+digit[47]+"~"+digit[45]+
                        '\n'+"天气:"+digit[67]+" "+digit[63]+digit[65]+
                        '\n'+digit[69];
                System.out.println(Weather);
//                System.out.println('\n'+"城市:"+digit[22]+digit[18]);
//                System.out.println('\n'+"时间:"+digit[49]+"年"+digit[50]+"月"+digit[51]+"日"+digit[53]);
//                System.out.println('\n'+"温度:"+digit[47]+"~"+digit[45]);
//                System.out.println('\n'+"天气:"+digit[67]+" "+digit[63]+digit[65]);
//                System.out.println('\n'+digit[69]);
            }
            br.close();//网上资源使用结束后，数据流及时关闭
            isReader.close();
        }
        catch(Exception exp){
            System.out.println(exp);
        }
    }
}
