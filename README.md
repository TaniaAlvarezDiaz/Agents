[![Build Status](https://travis-ci.com/TaniaAlvarezDiaz/Agents.svg?token=ENc151Ahc3Y3oqzaSf7S&branch=master)](https://travis-ci.com/TaniaAlvarezDiaz/Agents)

# Agents
Módulo que permite a los agentes consultar y obtener información del sistema.

# Skeleton authors 
David Lorenzo González

Martín Peláez Díaz

Laura Menéndez Pérez

Fernando Palazuelo Ginzo

# Author
Tania Álvarez Díaz ([@TaniaAlvarezDiaz](https://github.com/TaniaAlvarezDiaz))

# Usuarios de prueba para la aplicación:

- **Username:** 09847581T
  **Contraseña:** 123456789
  **Kind:** Person
  **Nombre:** Pedro Suárez
  **Email:** pedro@gmail.com
  **Location:**
  
- **Username:** 87654321B
  **Contraseña:** 1234
  **Kind:** Person
  **Nombre:** Pepe Fernández
  **Email:** pepe@gmail.com
  **Location:** 25.7751;-80.2105
 
- **Username:** SI1Oviedo
  **Contraseña:** 9874
  **Kind:** Sensor
  **Nombre:** Sensor Iluminacion SI1
  **Email:** carmen@yahoo.com
  **Location:** 43.36;-5.85
  
- **Username:** Q3318001I
  **Contraseña:** 147852369
  **Kind:** Entity
  **Nombre:** Uniovi
  **Email:** uniovi@example.com
  **Location:** 
  
# Funcionamiento:

Para arrancar el proyecto, desde la carpeta Agents se ejecutará:
- mvn spring-boot:run

## Interfaz HTML
  1. Escribir en el navegador: http://localhost:8081/
  2. Proporcionar username, password y kind de uno de los usuarios de prueba mostrados anteriormente.
  3. Aparecerá la pantalla que muestra los datos del agente
   	 * Se puede ir a la pantalla de inicio
  4. Cambio de datos:
     * Se puede cambiar la contraseña
       * Escribir la contraseña antigua
       * Escribir la contraseña nueva
     * Se puede cambiar el email del agente, siempre que sea una dirección de email válida 
