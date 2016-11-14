package com.pet.supplies.common.domain;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "CATEGORY")
public class Category
{
   /**
    * Constructor: create a new Category.
    */
   public Category()
   {
   }

   @Id
   @Column(name = "CAT_ID")
   @GeneratedValue
   private Long id;
   
   @Column(name = "NAME")
   private String name;
   
   @Column(name = "CODE")
   private String code;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
   private Set<Product> products;

   @Column(name = "SELLER_ID")
   private Long sellerId;

}
