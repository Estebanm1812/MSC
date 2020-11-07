package model;
public class Private extends Playlist{

	
	private String userThatControls;
	/**
	*method constructor, it creates an object of the type Private
	*pre: PlayList has its own method constructor
	*pos: userThatControls is initzialized 
	*@param name, it is the title of the Playlist
	*@param userThatControls, it is the only user that can modify the information of the pLaylist
	*/
	public Private(String name,String userThatControls){
		super(name);
		this.userThatControls = userThatControls;
			
	}
	public String getUserThatControls(){
		return userThatControls;
	}
	public void setUserThatControls(){
		this.userThatControls = userThatControls;
	}
	/**
	*method that overrides the showPlayListInformation of the class Playlist to include the particular information of the class
	*pre: the Private PlayList exists
	*@return text, with the important information of the playlist
	*/
	@Override
	public String showPlayListInformation(){
		
		String text = "";
		
		text = "************   PlayList    ************\n" +
			   "** Title: " + getPlayListName() + " \n" +
			   "** Duration: " + durationInMinutesAndSeconds() + " \n" +
			   "** Genres: " + genresListText(songList) + " \n" +
			   "** User: " + getUserThatControls() + " \n";
			   
		return text;
	}
}