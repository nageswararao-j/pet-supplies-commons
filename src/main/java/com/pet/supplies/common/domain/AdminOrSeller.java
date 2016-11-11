package com.pet.supplies.common.domain;

import javax.persistence.FetchType;

import javax.persistence.OneToOne;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * ????
 *
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
@Entity
@Setter
@Getter
@Table(name = "SELLER")
public class AdminOrSeller
{
   public AdminOrSeller()
   {

   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "SELLER_ID")
   private Long id;

   @Column(name = "NAME")
   private String name;

   @Column(name = "CODE")
   private String code;
   
   @Column(name = "EMAIL_ID")
   private String emailId;
   
   @Column(name = "PHONE")
   private String phone;
   
   @Column(name = "PASSWORD")
   private String password;
   
   @Column(name = "ACTIVE")
   private boolean active;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
   private List<Product> products; 
   
   @OneToOne(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private Address address;
}
