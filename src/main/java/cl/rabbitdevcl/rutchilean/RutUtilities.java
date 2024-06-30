/**
 @author rabbitDevCL
 */
package cl.rabbitdevcl.rutchilean;

public class RutUtilities {
    /**
     * funcion que calcula el digito verificador del rut
     *
     * @param identification ingresar el rut sin digito verificador (XX.XXX.XXX)
     * @return el digito verificador del rut
     */
    public static String getDv(String identification){
        String dv = null;

        try {
            String clearIdentification = identification
                    .replace("-", "")
                    .replace(".", "")
                    .replace(",", "")
                    .trim();

            int count = clearIdentification.length();
            int factor = 2;
            int sum = 0;

            for (int i = count; i > 0; --i) {

                if (factor > 7) factor = 2;

                sum += Integer.parseInt(identification.substring(i - 1, i)) * factor;
                ++factor;
            }

            dv = String.valueOf(11 - sum % 11);

            if (dv.equals("10")) {
                dv = "K";
            } else if (dv.equals("11")) {
                dv = "0";
            }
        }catch (Exception ex){
            dv = "-1";
        }
        return dv.toUpperCase();
    }

    /**
     * funcion que separa el rut del digito verificador
     *
     * @param identification ingresar el rut completo (XX.XXX.XXX-K)
     * @return retorna un objeto tipo Rut que obtiene el rut y su digito verificador
     */
    public static Rut separateRut(String identification){
        Rut rut = null;
        try {
            String clearIdentification = identification
                    .replace("-", "")
                    .replace(".", "")
                    .replace(",", "")
                    .trim();

            rut = new Rut(clearIdentification.substring(0, clearIdentification.length() - 1), clearIdentification.substring(clearIdentification.length() - 1));
        }catch (Exception ex){
            return null;
        }
        return rut;
    }
}
