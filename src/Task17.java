import javax.swing.JOptionPane;

public class Task17 {

    static int optionSelected;

    //Consulted on 20/april/2022
    // Values of the TC got from https://www.xe.com/es/currencyconverter/convert/?Amount=3500&From=MXN&To=HKD
    static float[] exchangeRates = {(float)0.0500302,(float)0.0461423,(float)6.41889,(float)0.39242798};

    static String[] options = {"Dólar (EU)", "Euro", "Yen(Japonés)","Dólar HK"};
    public static void main(String[] args){
        optionSelected = JOptionPane.showOptionDialog(null, "Selecciona una opcion", "Conversor de temperatura", 0, 0, null, options,null);

        float mexicanQuantity = promptMexicanQuantity();

        float exchangeValue = doConvertion(mexicanQuantity);

        String messageResult = String.format("%s MXN ➡ %s %s", mexicanQuantity,exchangeValue,options[optionSelected]);

        JOptionPane.showMessageDialog(null, messageResult, "Conversión", 1);
    }

    public static float doConvertion(float quantity){
        return (float)(exchangeRates[optionSelected]*quantity)*1;
    }

    public static float promptMexicanQuantity(){
        try {
            float mexicanQuantity = Float.parseFloat(JOptionPane.showInputDialog(null, "Digita los pesos mexicanos"));

            return mexicanQuantity;
        } catch (Exception e) {
            return promptMexicanQuantity();
        }
    }
}
