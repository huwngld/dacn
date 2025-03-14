package dacn.demo.Service.Admin.Convert;
import java.util.*;

import org.apache.commons.codec.digest.HmacUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ConvertData {

    public static String checksumKey = "3a7b4b73373ad9e1d41ae2898ac43b5326b18de2ce648ee1d1893912b9c4528b";
//
//    public static String transaction = "{'amount':2,'cancelUrl':'https://your-cancel-url.com','description':'2','orderCode':125,'returnUrl':'https://your-success-url.com'}";

//    public  static String transaction = "{'amount':50000,'cancelUrl':'https://your-cancel-url.com','description':'nhanh','orderCode':331,'returnUrl':'https://your-success-url.com'}"

    public static String isValidData(String transaction) {
        try {
            JSONObject jsonObject = new JSONObject(transaction);
            Iterator<String> sortedIt = sortedIterator(jsonObject.keys(), (a, b) -> a.compareTo(b));

            StringBuilder transactionStr = new StringBuilder();
            while (sortedIt.hasNext()) {
                String key = sortedIt.next();
                String value = jsonObject.get(key).toString();
                transactionStr.append(key);
                transactionStr.append('=');
                transactionStr.append(value);
                if (sortedIt.hasNext()) {
                    transactionStr.append('&');
                }
            }

            String signature = new HmacUtils("HmacSHA256", checksumKey).hmacHex(transactionStr.toString());
            System.out.println(transaction);
            System.out.println(signature);
            return signature;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Iterator<String> sortedIterator(Iterator<?> it, Comparator<String> comparator) {
        List<String> list = new ArrayList<String>();
        while (it.hasNext()) {
            list.add((String) it.next());
        }

        Collections.sort(list, comparator);
        return list.iterator();
    }

}