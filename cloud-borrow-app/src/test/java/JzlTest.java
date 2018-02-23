import com.py.app.borrow.bo.GetBorrowInfoRequestBo;
import com.py.common.utils.GsonUtil;
import com.py.common.utils.RSAUtil;
import org.junit.Test;

/**
 * Created by jzl on 17/12/18.
 */
public class JzlTest {

    @Test
    public void test01() throws Exception {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD0m+b18iP1oUledwwgvDE/pSHoSk8TdbQ/u5j6pUAa4E4GxwRx0GfautgNmVE5/64DcWDOr1rOm8u5MhaPkbR2xHE3WxstVzbSaUk2P41oURID1MIU2olrzLvgLxljeQTnGDnA0YAD3w5baebrUZaJW6zv5MLjrwGsFh9pGzayQQIDAQAB";
        GetBorrowInfoRequestBo requestBo = new GetBorrowInfoRequestBo();
        requestBo.setMerchantCode("M_PY_001");
        requestBo.setPhone("17736481994");

        String str = RSAUtil.encryptByPublicKey(GsonUtil.toJson(requestBo), publicKey);
        System.out.println("eny=" + str);
    }
}
