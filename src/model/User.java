package model;
public class User{
	private String name;
	private String password;
	private int age;
	private int sharedSongs;
	
	private Category userCategory;
	
	public User(String name, String password, int age, String userCategory){
	this.name = name;
	this.password = password;
	this.age = age;
	this.userCategory = Category.valueOf(userCategory);
	}
	public String getName(){
	return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getPassword(){
	return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getSharedSongs(){
		return sharedSongs;
	}
	public void setSharedSongs(int sharedSongs){
		this.sharedSongs = sharedSongs;
	}
	public Category getUserCategory(){
		
		return userCategory;
	}
	public void setUserCategory(Category userCategory){
		
		this.userCategory = userCategory;
	}
	/**
	*method that shows The import information of the user
	*pre: the user is created
	*@return information, a String with the import information of the user;
	*/
	public String userInformation(){
		
		String information = " **********User*******\n " + " **Username: " + getName() + " \n" +
							 " **Age: " + getAge() + " \n" + "** Category: " + getUserCategory() + " \n" + 
							 "**********************\n" ; 
		
		return information;
		}
	/**
	*method that shows the name of the user
	*pre: the user is created
	*@return text, a String with the name of the user;
	*/
	public String userListJustName(){
		
		String text = "";
		
		text = " " +getName();
		
		return text;
		}
			
	}
	
