package hasanalmunawr.Dev.Backendbankspringbootpostgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class PrimaryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private String description;
    private String type;
    private String status;
    private double amount;
    private BigDecimal availbeBalance;

    @ManyToOne
    @JoinColumn(name = "primary_account_id")
    private PrimaryAccount primaryAccount;


}
