package com.example.BazaClients.models.bazaclients;

import com.example.BazaClients.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "client")
public class Client {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "address_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "adrress_id"))
    private Set<Address> address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "telephone_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "telephone_id"))
    private Set<Telephone> telephone = new HashSet<>();

    @Column(name = "systemClearing")
    private String systemClearing ;

    @Column(name = "dateFilterReplacement")
    private Long dateFilterReplacement;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "listOfServices_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "listOfServices_id"))
    private Set<ListOfServices> listOfServices = new HashSet<>();

    @Column(name = "comments")
    private String comments;
}