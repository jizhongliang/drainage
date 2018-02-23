import com.py.app.account.bo.GetAccountInfoRequestBo;
import com.py.common.utils.GsonUtil;
import com.py.common.utils.RSAUtil;
import org.junit.Test;

/**
 * Created by jzl on 17/12/18.
 */
public class JzlTest {

    @Test
    public void test01() throws Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD0m+b18iP1oUledwwgvDE/pSHoSk8TdbQ/u5j6pUAa4E4GxwRx0GfautgNmVE5/64DcWDOr1rOm8u5MhaPkbR2xHE3WxstVzbSaUk2P41oURID1MIU2olrzLvgLxljeQTnGDnA0YAD3w5baebrUZaJW6zv5MLjrwGsFh9pGzayQQIDAQAB";
        GetAccountInfoRequestBo requestBo = new GetAccountInfoRequestBo();
        requestBo.setMerchantCode("M_PY_001");
        requestBo.setPhone("17736481994");

        String str = RSAUtil.encryptByPublicKey(GsonUtil.toJson(requestBo), publicKey);
        System.out.println("eny=" + str);
        //eny=qxXzDFZ0RxlPYif2czTzRXu0k%2B2ILGKyCrliYYKqCE%2FtWsMq7dWu1p3rZ%2BKwTPrg9gP1Qu0TbZMZ9aQspkIjEndqGwdJy5%2BV0Jr9nWXGqrbeDHVveddVupcOyQQMd5pX9cpeFQKAWegG9uhJfU1Il642Kufi2jBiWbDU6asx0rY%3D



    }
}
