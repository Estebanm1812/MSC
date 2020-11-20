package model;
public class MSC{
	
	private static int MAX_USERS = 10;
	private static int MAX_SONGS = 30;
	private static int MAX_PLAYLIST = 20;
	private User [] userlist;
	private Song [] songList; 
	private Playlist [] playListCollection;
	
	/**
	*Constructor Method, initializes the arrays of userlist, songlist and playListCollection
	pos: songList is initialized, songList != null, userlist is initialized, userlist != null, playListCollection is initialized, playListCollection!= null
	*/
	public MSC(){
	userlist = new User[MAX_USERS];
	songList = new Song[MAX_SONGS];
	playListCollection = new Playlist[MAX_PLAYLIST];
	}
	/**
	*method that adds a new user to the userlist
	*pre: userlist is initialized and has empty positions
	*pro: userlist has a new user in the first empty position.
	*@param name, it is the name/nickname of the user
	*@param password, it is the password of the user
	*@param age, it is the age of the user, it has to be above 0
	*@param userCategory, it is defalut category of the user, being NEWBIE
	*/
	public void addUser(String name,String password, int age, String userCategory){
	
	int position = 0;
	boolean out = false;

	
	for(int i=0; (i<MAX_USERS) && (out == false);i++){
	
			if(userlist[i] == null){
				
				out = true;
				position = i;
			}
		}
	userlist[position] = new User(name, password, age, userCategory);	
	
	}
	/**
	*Method that Returns the Information of the users without being updated the category 
	*@return out, A String with the off date information
	*/
	public String showUserList(){
		
	
	String out = "";
	
	for(int i=0; (i < MAX_USERS); i++){
		
		if(userlist[i] != null){
			
			
			out += userlist[i].userInformation() + "";
		}
		
		
		}
		return out;
	}
	/**
	*Method that adds a new Song to the array songLIst
	*pre: songList has to be initialized and has empty positions
	*pos: songlist has a new song in the first empty postion
	*@param title, it is the title of the song
	*@param artist, it is the artist/band of the song
	*@param duration, it is the duration of the song in seconds
	*@param releaseDate, it is the date from when the song was relased
	*@param songGenre, it is the genre of the song, Genre is in{ROCK,HIPHOP,MUSICACLASICA,REGGAE,SALSA,METAL}
	*/
	public void addSong(String title, String artist, int duration, String releaseDate, String songGenre){
	
	int position = 0;
	boolean out = false;
	
	for(int i=0; (i<MAX_SONGS) && (out == false);i++){
		
			if(songList[i] == null){
				
				out = true;
				position = i;
			}
		}
		songList[position] = new Song(title, artist, duration, releaseDate, songGenre);
	
	if(songList[position] != null) {
		System.out.println("Funciona");
	}
	}
	/**
	*method to add a public playlist to the playListCollection
	*pre: playListCollection is initialized and has empty positions
	*pos: playListCollection has a new Public PlayList in the first empty position
	*@param playListName, it is the title of the playList
	**/
	public void addPlaylist(String playListName) {
		
		
		int pos = 0;
		boolean out = false;
		
		for(int i=0; (i<MAX_PLAYLIST)&&(out == false);i++){
		
			if( playListCollection[i] == null){
				
				out = true;
				pos = i;
			}
		}
		
		playListCollection[pos] = new PublicForAll(playListName);
	}
	/**
	*method to add a new private PlayList to the playListCollection
	*pre: playListCollection is initialized and has empty positions
	*pos: playListCollection has a new Private PlayList in the first empty position
	*@param playListName, it is the title of the playList
	*@param userThatControls, it is the user that can acces and modifie the playList
	**/
	public void addPlaylist(String playListName, String userThatControls){
		
		int pos = 0;
		boolean out = false;
		
		for(int i=0; (i<MAX_PLAYLIST)&&(out == false);i++){
			
			if( playListCollection[i] == null){
				
				out = true;
				pos = i;
			}
			
		}
		playListCollection[pos] = new Private(playListName, userThatControls);

	}
	/**
	*method to add new Restricted Playlist to the playListCollection
	**pre: playListCollection is initialized and has empty positions
	*pos: playListCollection has a new Restricted PlayList in the first empty position
	*@param playListName, it is the title of the playList
	*@param usersThatControls, it is array with the list of users that can modifie the playList
	*/
	public void addPlaylist(String playListName, User [] usersThatControls){
		
		int pos = 0;
		boolean out = false;
		
		for(int i=0; (i<MAX_PLAYLIST)&& !out ;i++){
			
			if( playListCollection[i] == null){
				
				out = true;
				pos = i;
				
				
			}
		}
		playListCollection[pos] = new Restricted(playListName, usersThatControls);
	}
	/**
	*method that shows The updated userList information
	*@return text, a String with the information of all the current users with the current category according to the added songs of each one
	*/
	public String showUsersInformationList(){
		
		String text = "";
		
		int sharedSongs = 0;
		
		Category category;
		
		boolean out = false;
		
		for(int i=0; (i<MAX_USERS);i++){
			
			if(userlist[i] != null){
				
			sharedSongs = userlist[i].getSharedSongs();
			if(sharedSongs <= 3){
				category = Category.NEWBIE;
				userlist[i].setUserCategory(category);
			}else if((sharedSongs > 3)&&(sharedSongs <=10)){
				category = Category.LITTLECONSTRIBUTOR;
				userlist[i].setUserCategory(category);
			}else if((sharedSongs >10)&&(sharedSongs<=30)){
				category = Category.MILDCONTRIBUTOR;
				userlist[i].setUserCategory(category);
			}else if(sharedSongs>30){
				category = Category.STARCONTRIBUTOR;
				userlist[i].setUserCategory(category);
			}
			text += userlist[i].userInformation();
			}
			
			
			}
		return text;	
		}
	/**
	*method that shows just name of the users and their position in the array userlist
	*@return text, a String with the names and position in the array of the current users
	
	*/
	public String usersNames(){
	
	String text = ""; 
		
	for(int i=0; (i<MAX_USERS); i++){
		
		if(userlist[i] != null){
			
			text += " (" + (i) + ") " + userlist[i].userListJustName() + " \n";
			
			
		}
		
		
	}
	return text;
	/**
	*method that shows all the information of the songs in the array songList
	*@return text, a String witht the information of the songs
	*/
	}
	public String showSongsList(){
		
		
		String text = "";
		
		for(int i=0; i<MAX_SONGS; i++){
			
			
			if(songList[i] != null){
			text += songList[i].showSongList() + " \n";
			}
		}
	return text;	
	}
	/**
	*method that increases the shared songs to a user at the moment of create a song
	*pre: there is atleast one user created
	*pos: the sharedSongs of the selected user will be increased by one
	*@param option1, it is the position of the user in userlist 
	*/
	public void choosedUser(int option1){
		
		int option = option1;
		
		int songs = 0;
		
		songs = userlist[option].getSharedSongs();
		
		songs+=1;
		 
		 userlist[option].setSharedSongs(songs);
		 
		
	}
	/**
	*method that look for an empty position in the array usersThatControls and adds one already existing user in that array
	*pre: there is atleast one user already created and the array has empty positions
	*pos: a existing user will be added in the first empty position
	*@param option1, it has the position of the user that will be added in the array userlist
	*@return usersThatControls, it is an array witht the list of users that can modifie a specific Restricted playlist
	*/
	public User[] addChoosedUser(int option1){
		
		User [] usersThatControls = new User[5];
		int option = option1;
		boolean out = false;
		int position = 0;
		for(int i=0; (i<usersThatControls.length)&&(out==false);i++){
			
			if(usersThatControls[i] == null){
				
				out = true;
				position = 0;
			}
			
			
		}
		usersThatControls[position] = userlist[option];
	return usersThatControls;	
	}
	/**
	*Method that Returns the Information of the Playlists including the specifc information of the 3 types of Playlist 
	*@return out, A String with the information of all the current playlists 
	*/
	
	public String playListInformation(){
		
		
		String text = "";
		
		for(int i=0; i<MAX_PLAYLIST; i++){
			
			
			if(playListCollection[i] != null){
			text += playListCollection[i].showPlayListInformation() + " \n";
			}
		}
		
		
		return text;
	}
	/**
	*method that adds a song to a PlayList
	*pre: there is at least one song and playList created and the playList has empty positions in its array songList
	*pos: a song will be added in the first empty position
	*@param option1, it is the position of the playlist where the song will be added in the array playListCollection
	*@param option2, it is the position of the song in the array songList
	*/
	public void addSongToPlayList(int option1, int option2){
		
		
		int option = option1; //posicion 
		
		int option4 = option2; 
		
		int ubication = playListCollection[option].addSongToPlayList();
		
		int ubicationGenre = playListCollection[option].addGenreToPlayList();
		
		playListCollection[option].songList[ubication] = songList[option4];
		
		playListCollection[option].genresList[ubicationGenre] = songList[option4].getSongGenre();
	
		
		
	}
	/**
	*method that shows just name of the playLists and their position in the array playListCollection
	*@return text, a String with the names and position in the array of the current playList
	
	*/
	
	public String showPlayListNames(){
		
		String text = "";

		for(int i=0; i <playListCollection.length;i++){

			if(playListCollection[i] != null){
		
			text+=  "(" + i + ") " + playListCollection[i].getPlayListName();
				
				
			}
		}
		return text;
	}
	/**
	*method that shows just name of the songs and their position in the array songlist
	*@return text, a String with the names and position in the array of the current songs
	
	*/
	public String songListJustName(){
	
		String text ="";
	
		for(int i=0; i<songList.length;i++){
	
			if(songList[i] != null){
	
			text+=  "(" + i + ") " + songList[i].getTitle() + " \n";
	
			}
		}
	return text;	
	}
	/**
	*method that gives a grade to a public PlayList
	*pre: there is at least one public playList and its calification array has empty positions
	*pro: one Playlist publicForAll will change its gradeAverage
	*@param option1, it is the position in the array playListCollection of the playList that will have a new grade
	*@param calification, it is the grade that the user is giving to the playList
	*/
	public void  calculateAverage(int option1, double calification){
		
		int option = 0;
		
		double calification1 = calification;
		
		option = option1;
		
		if((playListCollection[option] != null)&&(playListCollection[option] instanceof PublicForAll)){
		
		int ubication = ((PublicForAll)playListCollection[option]).giveACalificationPosition();
		
		((PublicForAll)playListCollection[option]).setCalification(ubication, calification1);
		
		
		
		}
		
	
	 
	}
	/**
	*method that shows just name of the Public Playlist and their position in the array playListCollection
	*@return text, a String with the names and position in the array of the current playLists
	*/
	public String showJustPublicPlayLists(){
		
		String text = "";
		
		for(int i=0; i<playListCollection.length;i++){
		
			if((playListCollection[i] != null)&&(playListCollection[i] instanceof PublicForAll))
		
				text+= " (" + i + ") " + playListCollection[i].getPlayListName() + " \n";
		}
	return text;	
	}
	/**
	*method that adds a user to the list of users that can control a restricted playlist
	*pre: users exist, a Restricted playList exist
	*pos: there will be a user in the first empty position in the array usersThatControl
	*@param position, it is the position of the choosed user in the array userList
	*@param playlistPos, it is the position of the choosed Restricted playlist in the playListCollection
	*/
	public void addUsertoRestrictedPlayList(int position, int playlistPos){
		
		User tmp = userlist[position];
		
		
		
		((Restricted)playListCollection[playlistPos]).addNewUserThatControls(tmp);
	
	}
	/**
	*method that shows just name of the Restricted Playlist and their position in the array playListCollection
	*@return text, a String with the names and position in the array of the current playLists
	*/
	public String restrictedPlayList(){
		
		String text = "";
		
		for(int i=0; i<playListCollection.length;i++){
		
			if((playListCollection[i] != null)&&(playListCollection[i] instanceof Restricted))
		
				text+= " (" + i + ") " + playListCollection[i].getPlayListName() + " \n";
		}
	return text;
		
	}
}
