
import bo.UserInfoRequestBo;
import com.py.app.user.vo.MerchantInfoVo;
import com.py.app.user.vo.dto.ParsingMerchantInfoResponse;
import com.py.common.protocol.ParsingResponseWithCode;
import com.py.common.utils.GsonUtil;
import com.py.common.utils.RSAUtil;
import org.junit.Test;


/**
 * Created by jzl on 17/12/16.
 */
public class JzlTest {


    @Test
    public void test01() throws Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD0m+b18iP1oUledwwgvDE/pSHoSk8TdbQ/u5j6pUAa4E4GxwRx0GfautgNmVE5/64DcWDOr1rOm8u5MhaPkbR2xHE3WxstVzbSaUk2P41oURID1MIU2olrzLvgLxljeQTnGDnA0YAD3w5baebrUZaJW6zv5MLjrwGsFh9pGzayQQIDAQAB";
        UserInfoRequestBo requestBo = new UserInfoRequestBo();
        requestBo.setMerchantCode("M_PY_001");
        requestBo.setPhone("18292822257");

        String str = RSAUtil.encryptByPublicKey(GsonUtil.toJson(requestBo), publicKey);
        System.out.println("eny=" + str);
        //eny=joZtoWzAxgCfv32kdwsb1TBGLBzISkuCJK5%2BSMu32Taql5%2BA3IGAiaUY9KRiyHjNM2jyzWYoYzzp823NZHsIg90EHaolv2oz3RK9t%2Ft3MLVVEcMgflQF4ZMWp2qwWrMJfFmMCZOHLJMw8yUKEslVPXofkAviw2%2BZTumuRN8TfZ4%3D

    }

    @Test
    public void test02() {
        String json = "{\"crator\":\"李四\",\"gmtCreate\":\"2017-12-13 01:01:01\",\"gmtModify\":\"2017-12-15 16:34:28\",\"id\":1,\"modifier\":\"李四\",\"name\":\"普赢科技\",\"publicKey\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD0m+b18iP1oUledwwgvDE/pSHoSk8TdbQ/u5j6pUAa4E4GxwRx0GfautgNmVE5/64DcWDOr1rOm8u5MhaPkbR2xHE3WxstVzbSaUk2P41oURID1MIU2olrzLvgLxljeQTnGDnA0YAD3w5baebrUZaJW6zv5MLjrwGsFh9pGzayQQIDAQAB\",\"securityCode\":\"M_PY_001\",\"status\":\"1\"}";
        MerchantInfoVo bo = GsonUtil.GsonToBean(json, MerchantInfoVo.class);
        //MerchantInfoVo vo = GsonUtil.GsonToBean(GsonUtil.GsonToBean(json, ParsingResponseWithCode.class).getData(), MerchantInfoVo.class);
        System.out.println(bo.getPublicKey());
        String json2 = "{\"data\":{\"crator\":\"李四\",\"gmtCreate\":\"2017-12-13 01:01:01\",\"gmtModify\":\"2017-12-15 16:34:28\",\"id\":1,\"modifier\":\"李四\",\"name\":\"普赢科技\",\"publicKey\":\"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD0m+b18iP1oUledwwgvDE/pSHoSk8TdbQ/u5j6pUAa4E4GxwRx0GfautgNmVE5/64DcWDOr1rOm8u5MhaPkbR2xHE3WxstVzbSaUk2P41oURID1MIU2olrzLvgLxljeQTnGDnA0YAD3w5baebrUZaJW6zv5MLjrwGsFh9pGzayQQIDAQAB\",\"securityCode\":\"M_PY_001\",\"status\":\"1\"},\"msg\":\"请求成功\",\"code\":\"0000\"}";
        MerchantInfoVo vo2 = GsonUtil.GsonToBean(json2, ParsingMerchantInfoResponse.class).getData();
        System.out.println(vo2.getPublicKey());

    }

    @Test
    public void test03() throws Exception{
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPSb5vXyI/WhSV53DCC8MT+lIehKTxN1tD+7mPqlQBrgTgbHBHHQZ9q62A2ZUTn/rgNxYM6vWs6by7kyFo+RtHbEcTdbGy1XNtJpSTY/jWhREgPUwhTaiWvMu+AvGWN5BOcYOcDRgAPfDltp5utRlolbrO/kwuOvAawWH2kbNrJBAgMBAAECgYEArW3ECWkO+d7K6EE7xhHoURnBurLE8iUoEW/u/PchRmz2pXOBwThkCf8jpDCqGJchR6uhWamWlpp7jOjoeg5yhcfPvgL2DTi52MHMlvHhcj9P4ES/I7vJW30rytSWQvhweu7rX2cWgV05u8JgDJZL/0IwySGlDUQOqhYiz6tqoGECQQD8+UWQnTaWQGLR8VJBIM4Pum0r7k+92fKu73H6PlWSADR6p7QjHsz9O8WKsKFusL5D5UEycuiNyLg8usW11neNAkEA94kDe7qwAjtwQ+mZZ6moNj7ahVmUajJemiv8UF/pGIHA7qf/SnCM0b13zQ3a9UNEsgg2WML1DWOVYWpWCBxuhQJAd6MjxRq0wCY/Fe686dQr38BY9RfFWpICdb0D+EcWjO/P4doCFUHxzClCaS7TidfIg6+eP8+cL8GncAEck7yT2QJACtcPNf3o81ATDIZQV3/Qg/+gpjJUE4p9JhdDB2oL1SzpfAoTXfkr0YuQkYRH0HHPslQ1vRFcleeEhS2Y8uX72QJAWOKEpfmkc0IqXIZSEIr1kdvqYKDoZhqlQh/8yWS+UBrT961RXt5UOhzRkDDGXEham6prQ8kK9JwlmzbqeLw7/g==";
        String str = "8%2FQ%2FJA1xzNya5rBzPdvnCFWtLm1wl5Ka0tUjizI9pAU1T%2BkuGeghl48uymslYZoO8KZ63bR%2F%2B%2BomtVLJ10WpU2rQ1%2BK6awMLhWGDBSO9CTJW6SLIitnSBGDm8PqUP8lqRCCBOvntrITKCGYgbtn4l5mun%2BtN4AyhqgOwT91E1tRzXxQqVZrGtb1MOZQ%2Bq8D8uafTKEmb4JzzidWIsrIuH9tqoQMl3yqOL6xHRAAum7WVP8TOAVeDic31etzZnum%2BT0tKbjknBROCQwBcUDDALdaqX9VeKMzV11kEIFbpcMybu92Rzyww4lYORcaW3JzBwJQ3mHNeiJV68qQO3eTUFqwq3coXn2cexnRGEQWChVEuFpjhf92KmYtUiOgqpRUUOdnR6HTxQbqj1C2WA9KJzJ1CbTnc8nWqmx40YDPjGSoOjdWPPBcb0pHVvg4SoNFrgIybdtM1%2FLENnS9gHbpxslG6kh6OEhFu3G9q3vVExuGJY2irb4IJQxJDw78JKpTBtaxLVAZRaHI9BqQGd9wjPyYEJjN3AQUPAK1AcufBTklrOy7GOjQP5mLGuooDVMvRlIz9VhjdHipbmnmzlurzrhf7Yq%2F8d1V%2FONNiGs03P1to6w%2B4bmzJ5cxzgL7fdmZsg0tGIFixGQzUsOHT%2BRouhNK83AWGKH4FMcvbw3cjOpk0AoRt0eC6hax9MVH%2FvEL5jKgpLuFborlqn6Q34j3MQ7hbhUrTyu8DryJYz4lbOwGdr%2FJYLZSMFG2RFLiwhlRDPcQ9rQ4LOYQ1DjIpcoCjonwhQmuthDYXl7SAoCCYj1h4%2FL%2FuyXfuAijgDcg5lO4i%2BgwPXMXnIRMIcATelxBeYNp90E5z016Op4mTyy0tTtN1s5ernqHIK48uVlmuQc2V%2Bufzmz7kVJ7slLdTDevunhmoNwvM3kDNfGXt4jjbe3R%2FPBPmCc3uh5fyS4SMv3G2RucFq08yD0ZpsjtzgLicV4kDF%2FOsb2vah6Pbuz%2BnlpXVz4GYDW7HHXMLfuDxvvNIFxy7%2BBFDuH1Q%2FkRlWdWHNgZnf%2BqGhYxQmyc0Ph4228lgCd%2FUTstsKcOItUYo1TWQy3xn0jf79cH0YJF18A9elAWVDoqUqODmrD8XW1A5KBTUcF4uAvoM8XuJ6FYLMCuE4TfLA3PgetKsl8qfdgmyYeHtmT%2F4xKSs8VNwMcHQh%2Bh3yWKObvdo9xJklbz1rXJ7BT6FUUtruwHehiXtbMv3B3rrx7jFKWI4VJ5ty%2FxtMBbgCH9diP1ZowByfNQLUQK7ym7XvZDXkW4JZizxMGt%2FkDRIWe24WhtUEND%2BfoiuQrke7fvRGYtNko%2F5BKhR3nX69IvTZi1QXbJSAMjhfX7YDQ%3D%3D";
        String decy = RSAUtil.decrypt(str, privateKey, "UTF-8");
        System.out.println(decy);
    }
}
