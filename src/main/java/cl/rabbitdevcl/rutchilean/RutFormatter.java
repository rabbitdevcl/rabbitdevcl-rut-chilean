/**
 @author rabbitDevCL
 */
package cl.rabbitdevcl.rutchilean;

import java.text.NumberFormat;
import java.util.Locale;

public class RutFormatter {
    /**
     * funcion que da el formato simple del rut
     *
     * @param identificationNumber ingresar el rut completo (XXXXXXXXK o XXXXXXXX-K)
     * @return retorna rut con formato simple (XX.XXX.XXX-K)
     */
    public static String formatterSimple(String identificationNumber){
        try {
            String clean = identificationNumber
                    .replace(".", "")
                    .replace("-", "")
                    .replace(",", "")
                    .trim();

            Rut rut = RutUtilities.separateRut(clean);

            return thousandsWithDots(rut.getRut()) + "-" + rut.getDv();
        }catch (Exception ex){
            return ex.getMessage();
        }
    }

    /**
     * funcion que da formato al rut de 3 formas
     *
     * @param identificationNumber ingresar el rut completo (XXXXXXXXK o XXXXXXXX-K)
     * @param format que formato necesitas XXXX-K o X.XXX-K X,XXX-K
     *
     * @return retorna rut con formato (XX.XXX.XXX-K o XX,XXX,XXX-K o XXXXXXXX-K)
     */
    public static String formatterRut(String identificationNumber, String format){
        try {
            String clean = identificationNumber
                    .replace(".", "")
                    .replace("-", "")
                    .replace(",", "")
                    .trim();

            Rut rut = RutUtilities.separateRut(clean);

            if (format.equals(Rut.FORMATTER_SIMPLE)) {
                return rut.getRut() + "-" + rut.getDv();
            }

            if (format.equals(Rut.FORMATTER_COMPLETE)) {
                return thousandsWithDots(rut.getRut()) + "-" + rut.getDv();
            }

            if (format.equals(Rut.FORMATTER_COMPLETE_COMMA)) {
                return thousandsWithComma(rut.getRut()) + "-" + rut.getDv();
            }
        }catch (Exception ex){
            return ex.getMessage();
        }

        return null;
    }

    private static String thousandsWithDots(String rut){
        long num = Long.parseLong(rut);
        NumberFormat formatter = NumberFormat.getInstance(Locale.GERMANY);
        return formatter.format(num);
    }

    private static String thousandsWithComma(String rut){
        long num = Long.parseLong(rut);
        NumberFormat formatter = NumberFormat.getInstance(Locale.ENGLISH);
        return formatter.format(num);
    }

}
