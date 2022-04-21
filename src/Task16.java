import javax.swing.JOptionPane;

public class Task16 {

    static int optionSelected;
    static String[] options = {"°C ➡ °F", "°F ➡ °C"};
    static float temperatureRequested;

    public static void main(String[] args) throws Exception {

        /**
         * 0 - °C ➡ °F
         * 1 - F ➡ °C
         */
        optionSelected = JOptionPane.showOptionDialog(null, "Selecciona una opcion", "Conversor de temperatura", 0, 0, null, options, "Monitor");

        temperatureRequested = promptTemperature();
        
        float convertion = doConvertion();

        String messageResult = String.format("%s %s = %s", temperatureRequested,options[optionSelected],convertion);

        JOptionPane.showMessageDialog(null, messageResult, "Conversion", 1);
        
    }

    public static float convertFarenheitToCelsius(float farenheit){
        return (float)((farenheit - 32)/1.8);
    }

    public static float convertCelsiusToFarenheit(float celsius){
        return (float)(celsius*1.8)+32;
    }

    public static float doConvertion(){
        if(optionSelected==0){
            return convertCelsiusToFarenheit(temperatureRequested);
        }else{
            return convertFarenheitToCelsius(temperatureRequested);
        }
    }

    public static float promptTemperature(){
        try {

            float temperatureRequested = Integer.parseInt(JOptionPane.showInputDialog(null, "¿Cúal es la temperatura?"));

            return temperatureRequested;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor, inserta un número (¬_¬ )", "Error", 0);
            return promptTemperature();
        }
    }
}
