# RabbitDevCL

## Agregar dependencia Maven
```xml
<dependency>
    <groupId>cl.rabbitdevcl.rutchilean</groupId>
    <artifactId>rabbitdevcl-rut-chilean</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Validador de rut
### Validacion simple

```java
package your.packages;
import cl.rabbitdevcl.rutchilean.RutValidation;

public class Main {
    public static void main(String[] args) {
        String rut = "12.230.572-4"; //12,230,572-4 ó 12230572-4 ó 122305724
        
        boolean validate = RutValidation.validateRut(rut);
        
        if(validate){
            //...
        }
    }
}
```

### Validacion por separado

```java
package your.packages;
import cl.rabbitdevcl.rutchilean.RutValidation;

public class Main {
    public static void main(String[] args) {
        String rut = "12.230.572"; //12230572 ó 12,230,572
        String dv = "4";
        
        boolean validate = RutValidation.validateRut(rut);
        
        if(validate){
            //...
        }
    }
}
```

## Formato rut
### Formato Simple

```java
package your.packages;
import cl.rabbitdevcl.rutchilean.RutFormatter;

public class Main {
    public static void main(String[] args) {
        String rut = "12230572-4"; //122305724 ó 12230572-4
        String formatSimple = RutFormatter.formatterSimple(rut);

        System.out.println(formatSimple); // 12.230.572-4
    }
}
```

### Formato Custom

```java
package your.packages;

import cl.rabbitdevcl.rutchilean.Rut;
import cl.rabbitdevcl.rutchilean.RutFormatter;

public class Main {
    public static void main(String[] args) {
        String rut = "122305724"; //12230572-4 ó 12,230,572-4 ó 12.230.572-4
        // Rut.FORMATTER_SIMPLE = 12230572-4
        // Rut.FORMATTER_COMPLETE = 12.230.572-4
        // Rut.FORMATTER_COMPLETE_COMMA = 12,230,572-4
        
        String formatRut = RutFormatter.formatterRut(rut, Rut.FORMATTER_SIMPLE);
        
        System.out.println(formatRut); // 12230572-4
    }
}
```

## Utilidades

### Obtener Digito Verificador

```java
package your.packages;

import cl.rabbitdevcl.rutchilean.RutUtilities;

public class Main {
    public static void main(String[] args) {
        String rut = "12.230.572"; // 12,230,572 ó 12230572
        String dv = RutUtilities.getDv(rut);

        System.out.println(dv); // 4
    }
}
```

### Separar Rut

```java
package your.packages;

import cl.rabbitdevcl.rutchilean.Rut;
import cl.rabbitdevcl.rutchilean.RutUtilities;

public class Main {
    public static void main(String[] args) {
        String rut = "12.230.572-4"; // 12,230,572-4 ó 12230572-4 ó 122305724
        Rut object = RutUtilities.separateRut(rut);

        System.out.println(object.getRut()); // 12230572
        System.out.println(object.getDv()); // 4
    }
}
```