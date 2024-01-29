package ma.ilisi.userserice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private String f_name;
    private String l_name;
    private String address;
    private String phone;
    private String login;
    private String password;

}
