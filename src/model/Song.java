package model;
public class Song{

	private String title;
	private String artist;
	private int duration;
	private String releaseDate;
	private Genre [] genreList;

	private Genre songGenre;
	
	/**
	*method constructor that creates and object of type Song
	*pos: genreList is initialized, genreList != null
	*@param title, it is the title of the songGenre
	*@param artist, it is the artist of the songGenre
	*@param duration, it is the duration of the song in seconds
	*@param releaseDate, it is the date from where the song was released 
	*@param songGenre, it is the genre of the song, songGenre has to be in{ROCK,HIPHOP,MUSICACLASICA,REGGAE,SALSA,METAL}
	*/
	public Song(String title, String artist, int duration, String releaseDate, String songGenre ){
		
	this.songGenre = Genre.valueOf(songGenre);
	this.title = title;
	this.artist = artist;
	this.duration = duration;
	this.releaseDate = releaseDate;
	genreList = new Genre[6];
	
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
	this.title = title;
	}
	public String getArtist(){
	return artist;
	}
	public void setArtist(String artist){
	this.artist = artist;
	}
	public int getDuration(){
	return duration;
	}
	public void setDuration(int duration){
	this.duration = duration;
	}
	public String getReleaseDate(){
	return releaseDate;
	}
	public void setReleaseDate(String releaseDate){
	this.releaseDate = releaseDate;
	}
	/**
	*method that calculates the duration of the song in Minutes and second and making it a text
	*pre: the duration is above 0
	*@param duration, it is the duration of the song in seconds
	*@return time, a String with the time in Minutes:Seconds
	*/
	public String durationConvertion(int duration){

		String time = "";

		int minutes = 0;

		int seconds = 0;

		minutes = (int) (duration/60);

		seconds = (int) (duration- (minutes*60));

		time = minutes + ":" + seconds +"";
		return time;
	}
	/**
	*method that saves a String with the genre of the song 
	*pre: genreList is initialized
	*@return text,a String with the list of the song`s genre
	*/
	public String getGenreList(){
		
		String text = "";

		boolean out = false;

		for(int i=0; (i<genreList.length)&&(out==false);i++){

			if(genreList[i]==null){
				out = true;
			}
			text += genreList[i] + ", ";
		}
		return text;
	}
	public Genre getSongGenre(){
		return songGenre;
	}
	public void setSongGenre(){
		this.songGenre = songGenre;
	}
	/**
	*method that saves the information of the song
	*pre: the song exists
	@return text, a String with the important information of the song
	*/
	public String showSongList(){

		String text = "";

		text = "********SONG*********************\n" + "** Title: " + getTitle() + " \n" + "** Artist: " + getArtist() +
			   " \n" + "** Duration: " + durationConvertion(duration) + " \n" + "Genre: " +  getSongGenre() + " \n" +
			   "**********************************";
		return text;	
	}
}