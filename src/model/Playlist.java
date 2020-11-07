package model;
public abstract class Playlist{
	protected String playListName;
	protected int duration;
	protected Genre [] genresList;
	protected Song [] songList;
	/**
	*method constructor that creates an Object of Type Playlist
	*pos: genresList is initialized, genresList != null, songList is initialized, songList != null
	*@param playListName, it is the title of the playList that the user gives it
	*/
	public Playlist(String playListName){
	genresList = new Genre[6];
	songList = new Song[30];
	this.playListName = playListName;
	}
	public String getPlayListName(){
	return playListName;
	}
	public void setPlayListName(String name){
	this.playListName = playListName;
	}
	public int getDuration(){
	return duration;
	}
	public void setDuration(int duration){
		this.duration = duration;
	}
	/**
	*method that returns a String with the time format minuts:seconds
	*pre: songList is initialized
	*@return time, a String with the time total time of the songs in the array songList converted into the format minutes:seconds	
	*/
	public String durationInMinutesAndSeconds( ){
		
		String time = "";
		
		int duration = totalTime();

		int minutes = 0;

		int seconds = 0;

		minutes = (int) (duration/60);

		seconds = (int) (duration- (minutes*60));

		time = minutes + ":" + seconds +"";
		return time;
		
	}
	public Genre [] getGenresList(){
		return genresList;
	}
	public void setGenresList(Genre [] genresList){
		this.genresList = genresList;
	}
	/**
	*method that saves the information of the playList
	*@return text, a String with all the current information of the PlayList
	*/
	public String showPlayListInformation(){
		
		String text = "";
		
		return text;
	}
	/**
	*method that calculates the current total time in the array songList
	*pre: songList is initialized
	@return time, a Int with the addition of the time of all the current songs in the array songList
	*/
	public int totalTime(){
		
		int time=0;
		
	
		for(int i=0; (i<songList.length);i++){
			
			if(songList[i]!=null){
			
			time+= songList[i].getDuration();
			
			}
		}
		
		return time;
		
	}
	/**
	*method that searchs an empty position in the array songList
	*pre: songList is initialized and has empty positions
	*@return pos, a int with the position of the first empty position in the array songList
	*/
	public int addSongToPlayList(){
		
		int pos =0;
		
		boolean out = false;
		
		for(int i=0; (i<songList.length)&&(out==false);i++){
		
		if(songList[i] == null){
			out = true;
			pos = i;
		}
		}
		return pos;
	}
	/**
	*method that searchs an empty position in the array genresList
	*pre: genreList is initialized and has empty positions
	*@return pos, a int with the position of the first empty position in the array genreList
	*/
	public int addGenreToPlayList(){
		
		int pos =0;
		
		boolean out = false;
		
		for(int i=0; (i<genresList.length)&&(out==false);i++){
		
		if(genresList[i] == null){
			out = true;
			pos = i;
		}
		}
		return pos;
	}
	/**
	*method that saves a String with the list of the genres in the playList without repeat
	*pre: songList is initialized
	*@param songList, it is the array of songList from where the genres will be obtained
	*@return text,a String with the list of the genreList in the playList
	*/
	public String genresListText(Song [] songList){
		
		String text = "";
		
		for(int i=0; i<songList.length; i++){
		
			if(songList[i]!=null){
				if( (i>0)&&(songList[i-1].getSongGenre().equals(songList[i].getSongGenre()))){ 
				
				}else{
				text+= songList[i].getSongGenre() + ",";	
				}
			}
		}
		return text;
	}
	
	
}