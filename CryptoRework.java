/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto.rework;

import java.math.BigInteger;
import java.util.ArrayList;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author will
 */
public class CryptoRework {

    public static String hexToAscii(String hex) {
        String ascii = "";
        int length = hex.length();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            ascii += (char) Integer.parseInt(str, 16);
        }

        return ascii;
    }

    public static String hexToAsciiSubstring(String hex) {
        String ascii = "";
        int length = hex.length();
        if (length % 2 != 0) {
            length -= 1;
        }
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            ascii += (char) Integer.parseInt(str, 16);
        }

        return ascii;
    }

    
    public static Boolean cribCheck(String crib) {
        String cribResult = "";
        
        if (crib.matches("^[a-zA-Z0-9 ,?()-]*$")){
            return true;
        }
        return false; 
    }

    public static String hexToString(String hex) {
        byte[] stringBytes = DatatypeConverter.parseHexBinary(hex);

        String conversion = "";
        conversion = new String(stringBytes);
        return conversion;
    }

    
    public static String xorPad(String one, String two) {
        String xor = "";
         if (one.length() > two.length()) {
            String newTwo = two;
            while (one.length() != newTwo.length()) {
                //String rep = "0";
                newTwo =  newTwo + "0";
            }
            two = newTwo;
        } else if (one.length() > two.length()) {
            String newOne = one;
            while (one.length() != newOne.length()) {
                String rep = "0";
                newOne = newOne+"0";
            }
            one = newOne;
        }
         
        BigInteger oneNew = new BigInteger(one, 16);
        BigInteger twoNew = new BigInteger(two, 16); 
        xor = oneNew.xor(twoNew).toString(16);
        
        if (xor.length() % 2 != 0) {
            xor= xor + "0";
        }
        return xor;
    }

    public static String xor(String one, String two) {
        String result = "";
        int length;
        //Determine the shorter string
        if (one.length() > two.length()) {
            length = one.length();

        } else {
            length = one.length();
        }
        // pad shorter string

        //Loop through
        for (int i = 0; i < length; i++) {
            // convert to integer
            int a = (int) one.charAt(i);
            int b = (int) two.charAt(i);
            //xor the values
            result += (one.charAt(i) ^ two.charAt(i));

            //convert back to character  
        }

        //result = hexToString(result);
        return result;
    }

    private static String asciiToHex(String asciiStr) {
        char[] chars = asciiStr.toCharArray();
        StringBuilder hex = new StringBuilder();
        for (char ch : chars) {
            hex.append(Integer.toHexString((int) ch));
        }

        return hex.toString();
    }

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // cipher text
        ArrayList<String> encrypted = new ArrayList<String>();
        ArrayList<String> ascii = new ArrayList<String>();
        ArrayList<String> binary = new ArrayList<String>();

        encrypted.add("bd6e7a7d155295eef8512c087da56084f743aaa9985ee3848a768c3484d2e2ea6b3f4e5483f612d55987ff4782f360bd4809bab835fa1e65f8459c6814472508cc7f72241ee70c34fb9e7c8c4c246132845d5d73d070de5b46d5e95bd7e169abce08adf047196b9c2a98c3841bbd53a6db3c244f615c69");
        encrypted.add("a968617d0f1b97e5ee51280f3aec72caf106bdb48d44a68291339e35db86b6f56f2140548bf253cd1593e8498baa34ba4f02fda070e25075b04387681b473610cc7f75614ae21a3efb8672d85d3e2031cc7b677d");
        encrypted.add("af6f3779154f99e8e014375c34a267c1e745bbad895fe391c526873383cfa1e866325754a1d55f8c1584f90f9cf377b44d0bfda261bb132df84b9568175232028f6078764ae40736ac813d8c4137356598505673c071c2cdaf2df71e87e975ff8f47a9b55e1e69ce629fc19513b600e9c97369446a1826c42b0dca995193e8b999189ea4f8ca3fdf8272eca0293be6312cfe96b6ef6b3e07bb3471eff3042216d0895d6e0cd91900ed9bced59adb486277c0fa56f0c92eac3032a6b698f038774e61b535f24687b0ca39c3bba64433116804b8bbec45b4b4739031");
        encrypted.add("32510ba9aab2a8a4fd06414fb517b5605cc0aa0dc91a8908c2064ba8ad5ea06a029056f47a8ad3306ef5021eafe1ac01a81197847a5c68a1b78769a37bc8f4575432c198ccb4ef63590256e305cd3a9544ee4160ead45aef520489e7da7d835402bca670bda8eb775200b8dabbba246b130f040d8ec6447e2c767f3d30ed81ea2e4c1404e1315a1010e7229be6636aaa");
        encrypted.add("3f561ba9adb4b6ebec54424ba317b564418fac0dd35f8c08d31a1fe9e24fe56808c213f17c81d9607cee021dafe1e001b21ade877a5e68bea88d61b93ac5ee0d562e8e9582f5ef375f0a4ae20ed86e935de81230b59b73fb4302cd95d770c65b40aaa065f2a5e33a5a0bb5dcaba43722130f042f8ec85b7c2070");
        encrypted.add("9a6972380c5a91e5f80537193ca133c7e75faea9924bb191953e8f22d7c5adf067264b1d96f853c41892ad4480bd73f54902b1af35ef1860ac02972d05013543d93d306603fb4932be8b3d8f4825613183571320c170d9cde638f41e80e173e3dc5caefb574d6fce688cc49113f515a6cf7f2c066e4c3385230885884ddcf3f898029fe1e8dd3fcc9f76f3a77d35fa2d75b281b7e56b7f45bf3225e3ff003501d78d146e018e484ee18383d187ca0d6025d5f348ed9b61ae7f33acbfddf36b774d60a86ca016d1f4c83b8dbdaf59795e624dbdbbf310a5b271813fa31400835f4eec250ddd43de10a25e790c9f28e7ebd0c74fa11181fcf79cf68d5bd75b662bbacf38d31b39cbcdc71d213d611812188ebe8855dcf857337ac75e2b36cceb0c4a729e1b7c72e78e0962c112351e62aa0f41456ebd34667929cdb06c2ffd627d7b11da0b6dd57900d0cafd9651a32e8d4247a7ab3cce24d08150ceee321b38dae50481acf00896ce1f8c7b7499dcf79008c9b5aee24b8de4ff1737116c");
        encrypted.add("876f377f04559df9ea1d695c2db971c8fc45feb69855e393972f963598c1b0fc7a3b5c5491f800d81c8cfe089aa071f54906afaf38ef1f2cab4d9f3e130636118369716107fc4938a8d269904c7623249f514073c6798bcdae29bb5f9bef68f9c65ca7f81d4d5a866fdedc8a05ac53b9cf792d49625129852e17858f53d4f1aa9c1993e9bac770cb9162a3b46622a82e2ef09fbbeb2e7942a36066fce91f330b978c557208805207f1cc9cd29392487064d6f95ba8862fea642eabf3c8f2227f5e25bc74e35386a6d6748cafe75c320c7c04a7bfef57b4fa799b6baf1d06834901");
        encrypted.add("315c4eeaa8b5f8bffd11155ea506b56041c6a00c8a08854dd21a4bbde54ce56801d943ba708b8a3574f40c00fff9e00fa1439fd0654327a3bfc860b92f89ee04132ecb9298f5fd2d5e4b45e40ecc3b9d59e9417df7c95bba410e9aa2ca24c5474da2f276baa3ac325918b2daada43d6712150441c2e04f6565517f317da9d3");
        encrypted.add("bd64746a044fd8e0ee08651f2fb563d0fa41acbc8d44bad08833922998c2b1bd6f3e55188df853cd5992e44688bf71f54a02a4eb73f40221ba4d8720564328009e726d7003e00779ba9c79d84d3322379548473ac67185");
        encrypted.add("af2175740e5893abe818351438be33cde606adb2d04fa29c8933826195c3a1fc7f20405496e9168c0a82e54d82b634b04f04afb265ef0321b74c9668144a2900872b72624aeb082dbad27c8c0937613185555673dc6cc2d7a16cef5692a874eac24deffe56142e8164ded48415b053abd1732a4d21");
        //target
        //encrypted.add("866e786a0042d4abf21e305c35ad65c1b542bbbe8f55b3848032c6359fc3e2e96b21421196a107c90195a308b6bc61f54906abae35fd196fb1519b2d1206320b892b7c7719e60e37b697738c0776092a9c5d132ac66a8bd1a728bb5882e629");
        encrypted.add("866e786a0042d4abf21e305c35ad65c1b542bbbe8f55b3848032c6359fc3e2e96b21421196a107c90195a30896bc61f54906abae35fd196fb1519b2d1206320b892b7c7719e60e37b697738c0776292a9c5d132ac66a8bd1a728bb5882e629");
        //Xor of string 8 and 9
        
        //convert all hex to ascii and binary
        for (int i = 0; i < encrypted.size(); i++) {
            ascii.add(hexToString(encrypted.get(i)));
           // binary.add(hexToBinary(encrypted.get(i)));
        }

        // The string to search for
        
        String cribOne = " to them";
        //xor operation
        

        System.out.print("\n\n" + encrypted.get(1) + "\n");
        System.out.print("\n\n" + encrypted.get(2) + "\n");
        //covert xor to hex 
     
        String xor = xorPad(encrypted.get(0),encrypted.get(1));
      
        System.out.print("\n\n" + xor + "\n");
        ///*
        //Crib drag
        
        //convert crib to hex
         String cribWork = asciiToHex(cribOne);
         System.out.print("\n\n" + cribWork + "\n");
        for (int i = 0; i < xor.length() - cribWork.length(); i++){
           String xorTemp = xor.substring(i,i+cribWork.length());
           //xor crib and substring both converted to hex
           String result = xorPad(xorTemp,cribWork);
           result = hexToAsciiSubstring(result);
           if(cribCheck (result)){
               System.out.print("\n\n--------->" + result+ "\n");
           }
        // System.out.print("\n\n--------->" + result+ "\n");
        }
     

    }

}
