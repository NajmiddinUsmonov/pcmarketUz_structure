package uz.usmonov.pcmarketuz.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private String price;

    @ManyToOne
    private Brand brand;

    @OneToOne
    private Model model;

    @OneToMany
    private Set<ConfigInfo> configInfo;

    @OneToOne
    private Attachment photo;

}
