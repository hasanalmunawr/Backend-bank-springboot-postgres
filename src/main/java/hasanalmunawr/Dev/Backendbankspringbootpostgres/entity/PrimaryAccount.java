package hasanalmunawr.Dev.Backendbankspringbootpostgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class PrimaryAccount {

    private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PrimaryTransaction> primaryTransactionList;
}
