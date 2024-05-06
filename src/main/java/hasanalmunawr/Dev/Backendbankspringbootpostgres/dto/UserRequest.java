package hasanalmunawr.Dev.Backendbankspringbootpostgres.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
