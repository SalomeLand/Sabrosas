// Clase Usuario que hereda de Persona
public class Usuario extends Persona {
    private String correoElectronico;
    private String contrasena;

    // Constructor
    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, String correoElectronico, String contrasena) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad);
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    // Getters y Setters
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void imprimirUsuario() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido Paterno: " + getApellidoPaterno());
        System.out.println("Apellido Materno: " + getApellidoMaterno());
        System.out.println("Edad: " + getEdad());
        System.out.println("Correo Electrónico: " + getCorreoElectronico());
        // No imprimir la contraseña por razones de seguridad
    }
}
