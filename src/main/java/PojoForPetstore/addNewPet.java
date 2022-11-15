package PojoForPetstore;

public class addNewPet {
	int id;
	categoryObject category;
	String name;
	String[] photoUrls;
	Object[] tags;
	String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public categoryObject getCategory() {
		return category;
	}
	public void setCategory(categoryObject category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public Object[] getTags() {
		return tags;
	}
	public void setTags(Object[] tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public addNewPet(int id, categoryObject category, String name, String[] photoUrls, Object[] tags,
			String status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}
	public addNewPet() {
		super();
	}
	
}
