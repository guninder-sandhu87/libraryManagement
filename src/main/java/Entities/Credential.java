package Entities;


import jakarta.persistence.Transient;
import org.mindrot.jbcrypt.BCrypt;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Credential {
    @Id
    String email;
    @Transient
    String password;
    String hashedPassword;

    public Credential(String email, String password) {
        this.email = email;
        this.password = password;
        this.hashedPassword =hashPassword(password);
    }

    public Credential(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String hashPassword(String password){

      return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Boolean validatePassword(String password){
        return BCrypt.checkpw(password, this.hashedPassword);
    }
}
