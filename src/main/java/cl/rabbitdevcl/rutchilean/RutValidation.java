/**
 @author rabbitDevCL
 */
package cl.rabbitdevcl.rutchilean;

public class RutValidation {
    /**
     * funcion para validar rut completo
     *
     * @param identificationNumber rut (XX.XXX.XXX-K)
     * @return retorna un true si el rut es valido
     */
    public static boolean validateRut(String identificationNumber){
        Boolean result = false;
        try {
            String clean = identificationNumber
                    .replace(".", "")
                    .replace("-", "")
                    .replace(",", "")
                    .trim();

            if (clean.length() >= 8  &&
                    clean.length() <= 9
            ) {
                Rut rut = RutUtilities.separateRut(clean);
                result = validateRut(rut.getRut(), rut.getDv());
            }
        }catch (Exception exception){
            return false;
        }

        return result;
    }

    /**
     * funcion para validar rut. Separado por rut y digito verificador
     *
     * @param identificationNumber rut (XX.XXX.XXX)
     * @param dv digito verificador (K)
     * @return retorna un true si el rut es valido
     */
    public static boolean validateRut(String identificationNumber, String dv) {
        boolean result = false;
        try {
            String cleanIdentification = identificationNumber
                    .replace(".", "")
                    .replace("-", "")
                    .replace(",", "")
                    .trim();

            String cleanDigit = dv.toUpperCase()
                    .replace(".", "")
                    .replace(",", "")
                    .replace("-", "")
                    .trim();

            if (cleanIdentification != null &&
                    cleanIdentification.trim().length() != 0 &&
                    cleanDigit != null &&
                    cleanDigit.trim().length() != 0
            ) {
                String verified = RutUtilities.getDv(cleanIdentification);

                if (verified.equals(dv)) {
                    result = true;
                }

            }
        }catch (Exception ignored){}
        return result;
    }

}
