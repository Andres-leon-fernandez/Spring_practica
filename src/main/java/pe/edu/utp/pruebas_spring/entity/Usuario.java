package pe.edu.utp.pruebas_spring.entity;

public class Usuario {
    private String user;
    private String password;

    public Usuario() {
    }

    // Getters y setters
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
