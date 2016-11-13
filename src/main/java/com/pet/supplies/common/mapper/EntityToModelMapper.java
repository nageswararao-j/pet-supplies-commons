package com.pet.supplies.common.mapper;

import com.pet.supplies.common.domain.AdminOrSeller;
import com.pet.supplies.common.model.AdminOrSellerModel;

import org.apache.commons.collections.CollectionUtils;

import com.pet.supplies.common.domain.Address;
import com.pet.supplies.common.domain.CartItem;
import com.pet.supplies.common.domain.Category;
import com.pet.supplies.common.domain.Image;
import com.pet.supplies.common.domain.Orders;
import com.pet.supplies.common.domain.Product;
import com.pet.supplies.common.domain.AuthenticateUser;
import com.pet.supplies.common.domain.User;
import com.pet.supplies.common.model.AddressModel;
import com.pet.supplies.common.model.AuthenticateUserModel;
import com.pet.supplies.common.model.CartItemModel;
import com.pet.supplies.common.model.CategoryModel;
import com.pet.supplies.common.model.ImageModel;
import com.pet.supplies.common.model.OrdersModel;
import com.pet.supplies.common.model.ProductModel;
import com.pet.supplies.common.model.UserModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ????
 * 
 * @version $Id:$
 * @author njanjyal //I removed copyrights
 */
public class EntityToModelMapper
{

   /**
    * TODO
    * 
    * @param categories
    * @return
    */
   public static List<CategoryModel> mapCategoryEntityToCategoryModel(List<Category> categories)
   {
      List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
      if (CollectionUtils.isNotEmpty(categories))
      {
         categories.forEach(category -> {
            CategoryModel model = mapCategoryEntityToCategoryModel(category);
            model.setProducts(mapProductEntityToProductModel(category.getProducts()));
            categoryModels.add(model);
         });
      }
      return categoryModels;
   }

public static CategoryModel mapCategoryEntityToCategoryModel(Category category) {
	CategoryModel model = new CategoryModel();
	if(category != null){
		model.setId(category.getId());
		model.setCode(category.getCode());
		model.setName(category.getName());
	}
	return model;
}

   /**
    * TODO
    * 
    * @param products
    * @return
    */
   public static Set<ProductModel> mapProductEntityToProductModel(Set<Product> products)
   {
      Set<ProductModel> productModels = new HashSet<ProductModel>();
      if (CollectionUtils.isNotEmpty(products))
      {
         products.forEach(product -> {
            ProductModel model = mapProductToProductModel(product);
            productModels.add(model);
         });
      }
      return productModels;
   }

   /**
    * TODO
    * 
    * @param product
    * @return
    */
   public static ProductModel mapProductToProductModel(Product product)
   {
      ProductModel model = new ProductModel();
      model.setProductId(product.getId());
      model.setProductName(product.getName());
      model.setPrice(product.getPrice());
      model.setCurrency(product.getCurrency());
      model.setDesc(product.getDesc());
      model.setStatus(product.getStatus());
      model.setQuantity(product.getQuantity());
      model.setImageUrls(mapImageEntityToImageModel(product.getImageUrls()));
      if(product.getCategory() !=null){
         model.setCategoryCode(product.getCategory().getCode());
      }
      if (product.getSeller() != null)
      {
         model.setSellerId(product.getSeller().getId());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param images
    * @return
    */
   public static Set<ImageModel> mapImageEntityToImageModel(Set<Image> images)
   {
      Set<ImageModel> imageModels = new HashSet<ImageModel>();
      if (CollectionUtils.isNotEmpty(images))
      {
         images.forEach(image -> {
            ImageModel model = mapImageToImageModel(image);
            imageModels.add(model);
         });

      }
      return imageModels;
   }

public static ImageModel mapImageToImageModel(Image image) {
	ImageModel model = new ImageModel();
	model.setId(image.getImg_id());
	model.setName(image.getName());
	model.setUrl(image.getUrl());
	return model;
}

   /**
    * TODO
    * 
    * @param user
    * @return
    */
   public static UserModel mapAuthenticateUserEntityToUserModel(AuthenticateUser user)
   {
      UserModel model = new UserModel();
      if (user != null)
      {
         model.setUserId(user.getUserId());
         model.setPhone(user.getPhone());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param authUser
    * @return
    */
   public static AuthenticateUserModel mapAuthenticateUserEntityToAuthenticateUserModel(AuthenticateUser authUser)
   {
      AuthenticateUserModel model = new AuthenticateUserModel();
      if (authUser != null)
      {
         model.setEmailId(authUser.getEmailId());
         model.setPhone(authUser.getPhone());
         model.setUserId(authUser.getUserId());
         model.setPassword(authUser.getPassword());
         model.setActive(authUser.isActive());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param items
    * @return
    */
   public static List<CartItemModel> mapCartItemEntitiesToCartItemModels(List<CartItem> items)
   {
      List<CartItemModel> models = new ArrayList<CartItemModel>();
      if (CollectionUtils.isNotEmpty(items))
      {
         items.forEach(item -> {
            models.add(mapCartItemEntityToCartItemModel(item));
         });
      }
      return models;
   }

   /**
    * TODO
    * 
    * @param item
    * @return
    */
   public static CartItemModel mapCartItemEntityToCartItemModel(CartItem item)
   {
      CartItemModel model = new CartItemModel();
      if (item != null)
      {
         model.setId(item.getId());
         model.setProductId(item.getProductId());
         model.setQuantity(item.getQuantity());
         model.setUserId(item.getUser().getId());
         model.setProductName(item.getProductName());
         model.setPrice(item.getPrice());
         model.setCurrency(item.getCurrency());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param newOrder
    * @return
    */
   public static OrdersModel mapOrderEntityToOrderModel(Orders newOrder)
   {
      OrdersModel model = new OrdersModel();
      if (newOrder != null)
      {
         model.setOrderId(newOrder.getOrderId());
         model.setUserId(newOrder.getUser().getId());
         model.setProductId(newOrder.getProductId());
         model.setProductName(newOrder.getProductName());
         model.setProductPrice(newOrder.getProductPrice());
         model.setCurrency(newOrder.getCurrency());
         model.setQuantity(newOrder.getQuantity());
         model.setStatus(newOrder.getStatus());
         model.setShippingAddress(newOrder.getShippingAddress());
         model.setOrderDate(newOrder.getOrderDate());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param address
    * @return
    */
   public static AddressModel mapAddressEntityToAddressModel(Address address)
   {
      AddressModel model = new AddressModel();
      if (address != null)
      {
         model.setAddressId(address.getAddressId());
         model.setAddress(address.getAddress());
         model.setCity(address.getCity());
         model.setState(address.getState());
         model.setZipCode(address.getZipCode());
         model.setEmail(address.getEmail());
         model.setPhone(address.getPhone());
         model.setCountry(address.getCountry());
      }
      return model;
   }

   /**
    * TODO
    * 
    * @param orders
    * @return
    */
   public static List<OrdersModel> mapOrderEntitiesToOrderModels(List<Orders> orders)
   {
      List<OrdersModel> orderModels = new ArrayList<OrdersModel>();
      if (CollectionUtils.isNotEmpty(orders))
      {
         orders.forEach(order -> {
            orderModels.add(mapOrderEntityToOrderModel(order));
         });
      }
      return orderModels;
   }

   public static AdminOrSellerModel mapAdminOrSellerEntityToAdminOrSellerModel(AdminOrSeller entity)
   {
      AdminOrSellerModel model = new AdminOrSellerModel();
      if (entity != null)
      {
         model.setId(entity.getId());
         model.setActive(entity.isActive());
         model.setEmailId(entity.getEmailId());
         model.setName(entity.getName());
         model.setPhone(entity.getPhone());
         model.setRegister(entity.isActive());
      }

      return model;
   }
	
	public static Set<UserModel> mapUsersEntityToUsersModel(List<User> users) {
		Set<UserModel> userModels = new HashSet<UserModel>();
		if(CollectionUtils.isNotEmpty(users)){
			users.forEach(user->{
				UserModel model = new UserModel();
				model.setAddress(mapAddressEntityToAddressModel(user.getAddress()));
				model.setName(user.getName());
			});
		}
		return userModels;
	}

	public static UserModel mapUserEntityToUserModel(User user) {
		UserModel userModel = new UserModel();
		if(user != null){
			userModel.setName(user.getName());
		}
		return userModel;
	}
}
