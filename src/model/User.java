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
	public String userInformation(){
		
		String information = " **********User*******\n " + " **Username: " + getName() + " \n" +
							 " **Age: " + getAge() + " \n" + "** Category: " + getUserCategory() + " \n" + 
							 "**********************\n" ; 
		
		return information;
		}
	public String userListJustName(){
		
		String text = "";
		
		text = " " +getName();
		
		return text;
		}
			
	}
	
