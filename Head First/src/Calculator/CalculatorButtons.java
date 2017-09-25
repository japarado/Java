package Calculator;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by student on 9/25/2017.
 */
public class CalculatorButtons
{
    public static HashMap<JButton,String> setButtonTextMap(HashMap<JButton,String> buttonTextMap, JButton button, String buttonText)
    {
        buttonTextMap.put(button,buttonText);
        return buttonTextMap;
    }
}
