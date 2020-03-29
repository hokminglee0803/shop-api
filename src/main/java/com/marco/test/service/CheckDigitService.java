package com.marco.test.service;

import com.marco.test.constant.Constant;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CheckDigitService {

    public String checkDigit(String digit) throws Exception {
        Integer total = 0;
        HashMap<Character,Character> alphabetValueMap = Constant.alphabetConversion;
        if(digit.length()!=8){
            throw new Exception("The length of the string must be 8 characters.");
        }
        if(!alphabetValueMap.containsKey(digit.charAt(0))){
            throw new Exception("The first character must be alphabet");
        }
        for(int i = 0 ;i<digit.length();i++){
            if(alphabetValueMap.containsKey(digit.charAt(i))){
                total+= Integer.valueOf(alphabetValueMap.get(digit.charAt(i)).toString());
            }else{
                try{
                    total+= Integer.valueOf(String.valueOf(digit.charAt(i)));
                }catch (Exception e){
                    throw new Exception("Only allow 0 to 9 and A<Z (upper case)");
                }
            }
        }

        return String.valueOf(total%11);

    }
}
