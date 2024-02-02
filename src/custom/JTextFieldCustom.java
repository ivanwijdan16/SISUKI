package custom;

import java.awt.Insets;

public class JTextFieldCustom extends javax.swing.JTextField{

    public JTextFieldCustom() {
        Insets ins = getInsets();
        ins.left += 5;
        setMargin(ins);
    }
    
    public Insets getCustomMargin(){
        return getMargin();
    }
    
    public void setCustomMargin(Insets ins){
        setMargin(ins);
    }
    
}
