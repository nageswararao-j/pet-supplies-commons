package com.pet.supplies.common.domain;

import lombok.Setter;

import lombok.Getter;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @version
 * @author njanjyal //I removed copyrights
 */
@Entity
@Setter
@Getter
@Table(name = "PRODUCT")
public class Product
{
   public Product()
   {

   }

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "PRODUCT_ID")
   private Long id;

   @Column(name = "NAME")
   private String name;

   @Column(name = "PRICE")
   private BigDecimal price;

   @Column(name = "CURRENCY")
   private String currency;

   @Column(name = "STATUS")
   private String status;

   @Column(name = "QUANTITY")
   private int quantity;

   @Column(name = "DESCRIPTION")
   private String desc;

   @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
   private Set<Image> imageUrls;

   @ManyToOne
   @JoinColumn(name = "CAT_ID")
   private Category category;
   
   @ManyToOne
   @JoinColumn(name = "SELLER_ID")
   private AdminOrSeller seller;

}
