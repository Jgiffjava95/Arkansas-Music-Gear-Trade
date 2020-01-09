package model;

import java.sql.Blob;
import java.time.LocalDateTime;

public class item {
	
	private int itemId;
	private String itemCat;
	private String itemName;
	private int itemPrice;
	private String itemDesc;
	private String contact;
	private String location;
	private LocalDateTime postDate;
	private String thumbnail;
	
	public item() {
		
	}
	
	public item(int itemId, 
				String itemCat, 
				String itemName, 
				int itemPrice, 
				String itemDesc, 
				String contact, 
				String location,
				LocalDateTime postDate,
				String thumbnail) {
		
		this.itemId = itemId;
		this.itemCat = itemCat;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDesc = itemDesc;
		this.contact = contact;
		this.location = location;
		this.postDate = postDate;
		this.thumbnail = thumbnail;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public LocalDateTime getPostDate() {
		return postDate;
	}

	public void setPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
	}

	public String getItemCat() {
		return itemCat;
	}

	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public boolean hasName() {
		if (this.getItemName() != null) {
			return true;
		}
		return false;
	}
	
	public boolean hasPrice() {
		if (this.getItemPrice() != 0) {
			return true;
		}
		return false;
	}
	
	public boolean hasImg() {
		if (this.getThumbnail() != null) {
			return true;
		}
		return false;
	}
	
	public boolean hasContact() {
		if (this.getContact() != null) {
			return true;
		}
		return false;
	}
	
	public boolean hasDesc() {
		if (this.getItemDesc() != null) {
			return true;
		}
		return false;
	}
	
}
