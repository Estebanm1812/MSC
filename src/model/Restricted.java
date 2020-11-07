package model;
public class Restricted extends Playlist{

	private User [] usersThatControl = new User[5];
	/**
	*method constructor, it creates an object of the type Restricted
	*pre: PlayList has its own method constructor
	*pos: usersThatControls is initzialized, usersThatControl != null 
	*@param playListName, it is the title of the Playlist
	*@param usersThatControl, it an array of users that can modify the playlist
	*/
	public Restricted ( String playListName, User [] usersThatControl){
		super(playListName);
		this.usersThatControl = usersThatControl;

	}
	public User [] getUsersThatControl(){
		return usersThatControl;
	}
	public void setUsersThatControl(User [] usersThatControl){
		this.usersThatControl = usersThatControl;
	}
	/**
	*method to save the list of users that can modify the playlist in a String
	*pre: usersThatControl exist
	*@param usersThatControl, it has the list of users with acces to the playlist
	*@return text, a String with the names of the users that can modify the playlist
	*/
	public String listOfUsersNames(User [] usersThatControl){
		
		String text = "";
		
		for(int i=0; i<usersThatControl.length;i++){
			
			if(usersThatControl[i]!=null){
			
			text+= usersThatControl[i].getName() + ", " ;
			
			}
			
		}
	return text;	
	}
	/**
	*method that overrides the showPlayListInformation of the class Playlist to include the particular information of the class
	*pre: the Restricted PlayList exists
	*@return text, with the important information of the playlist
	*/
	@Override
	public String showPlayListInformation(){
		
		String text = "";
		
		text = "************   PlayList    ************\n" +
			   "** Title: " + getPlayListName() + " \n" +
			   "** Duration: " + durationInMinutesAndSeconds() + " \n" +
			   "** Genres: " + genresListText(songList) + " \n" +
			   "** Users: " + listOfUsersNames(usersThatControl) + " \n";
			   
		return text;
		
		
	}
}