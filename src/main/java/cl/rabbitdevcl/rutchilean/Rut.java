/**
 @author rabbitDevCL
 */
package cl.rabbitdevcl.rutchilean;

public class Rut {
    public static String FORMATTER_SIMPLE = "1111-1";
    public static String FORMATTER_COMPLETE = "1.111-1";
    public static String FORMATTER_COMPLETE_COMMA = "1,111-1";

    private final String rut;
    private final String dv;

    public Rut(String rut, String dv){
        this.dv = dv;
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }

    public String getDv() {
        return dv;
    }
}
