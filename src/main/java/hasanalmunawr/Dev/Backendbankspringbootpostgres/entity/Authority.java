package hasanalmunawr.Dev.Backendbankspringbootpostgres.entity;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@AllArgsConstructor
public class Authority implements GrantedAuthority {

    private final String authority;


    @Override
    public String getAuthority() {
        return authority;
    }
}
