package ui;
import model.MSC;
import java.util.Scanner;
import model.User;

public class Main{
	
	private static int usersMAX = 10;
	private MSC musicCenter;
	private Scanner sc;
	private int  usersCreated =0;
	private static int songsMAX = 30;
	private int songsAdded = 0;
	/**
	*method constructor, creates a object the type Main
	*pos: scanner is initialized
	*/
	public Main(){
	sc = new Scanner(System.in);
	}
	public static void main(String[]args){
		
		
		System.out.println("Iniciando la Aplicacion");
	
		Main application = new Main();
		application.createMusicCenter();
		int option =0;
	do{
			option= application.showMenu();
			application.executeOperation(option);
			
		}while (option!=0 );
	}
	/**
	*method that creates a new object of the type MSC
	*pos: musicCenter is created
	*/
	public void createMusicCenter(){
	
		musicCenter = new MSC();
	}
	/**
	*method that show a menu with the list of option that the user can do
	*@return option, an int with the action that the user want to execute
	*/
	public int showMenu(){
		int option = 0;
		
		System.out.println(
		"Menu Principal, seleccione una opcion\n" +
		"(0) Para Terminar la aplicacion\n" +
		"(1) Para Añadir Un usuario\n" +
		"(2) Para ver la lista de Usuarios\n" +
		"(3) Añadir una cancion \n" +
		"(4) Ver la lista de canciones \n" +
		"(5) Para entrar al Menu de PlayList \n"
		);
		
		option = sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	/**
	*method that executes the operation selected by the user
	*pre: the method showMenu shows the options to the user
	*@param operation, it is the option that user choosed
	*/
	public void executeOperation(int operation){
		
		switch(operation){
			
			case 0: System.out.println("Adieu");
			break;
			case 1: if(usersCreated < usersMAX){	
			addUser();
			}
			break;
			
			case 2: showUsersList();
			
			break;
			
			case 3: if(songsAdded < songsMAX){
			addSong();		
			}
			break;
			case 4: showSongList();
			break;
			case 5:
			int option2 = 0;
			do{
						
				option2 = showPlayListMenu();
				executePlayListOperations(option2);
				
			 } while(option2 != 1);
			break;
			
			 
		}
	}
	/**
	*method that adds a new user to the userlist in MusicCenter
	*pre: musicCenter is initialized and userlist has empty positions
	*pos: a new user is added to the program
	*/
	public void addUser(){
		
		String name = "";
		
		int age = 0;
		
		String password = "";
		
		String userCategory = "NEWBIE";
		
		
		System.out.println("Ingrese el NickName/Nombre del usuario");
		name = sc.next();
		sc.nextLine();
		System.out.println("ingrese la contraseña del usario");
		password = sc.nextLine();
		while(age <=0){
		System.out.println("Ingrese la edad del usario");
		age = sc.nextInt();
		sc.nextLine();
		}
		musicCenter.addUser(name, password, age, userCategory);
		System.out.println("El usario ha sido creado exitosamente");
		
		
		
		
	}
	/**
	*method that adds a new song to the songlist in MusicCenter
	*pre: musicCenter is initialized and songlist has empty positions
	*pos: a new song is added to the program
	*/
	public void addSong(){
	
	int userOption = 0;
	
	String text = "Seleccione Quien Ingresa la cancion\n" + musicCenter.usersNames();
	
	int option1 = 0;
		
	String songName = "";
	
	String songArtist = "";
	
	int songDuration = 0;
	
	String releaseDate = "";
	
	String songGenre = "";
		
	System.out.println(text);
	userOption = sc.nextInt();
	sc.nextLine();
	System.out.println("Ingrese el titulo de la cancion");
	songName = sc.nextLine();
	System.out.println("Ingrese el artista/banda de la cancion");
	songArtist = sc.nextLine();
	System.out.println("Ingrese la duracion de la cancion en segundos");
	songDuration = sc.nextInt();
	sc.nextLine();
	System.out.println("Ingrese el año de lanzamiento de la cancion");
	releaseDate = sc.nextLine();
	System.out.println("Ingrese: \n" +
	"(1) Para Rock\n" +
	"(2) Para HipHop\n" +
	"(3) Para Musica Clasica\n" +
	"(4) Para Reggae\n" +
	"(5) Para salsa\n" +
	"(6) Para metal" );
	option1 = sc.nextInt();
	switch(option1){
		
		case 1: songGenre = "ROCK";
		break;
		case 2: songGenre = "HIPHOP";
		break;
		case 3: songGenre = "MUSICACLASICA";
		break;
		case 4: songGenre = "REGGAE";
		break;
		case 5: songGenre = "SALSA";
		break;
		case 6: songGenre = "METAL";
		break;		
	}
	musicCenter.addSong(songName, songArtist, songDuration, releaseDate, songGenre);
	musicCenter.choosedUser(userOption);
	}
	/**
	*method that shows the current userlist
	*pre: musicCenter is initialized
	*/
	public void showUsersList(){
	
	String text = "";
	
	
	text = musicCenter.showUsersInformationList();
	
	System.out.println(text);
	
	}
	/**
	*method that shows the current songlist
	*pre: musicCenter is initialized
	*/
	public void showSongList(){
		
		String text = "";
		
		text = musicCenter.showSongsList();
		System.out.println(text);
	}
	/**
	*method that show a menu with the list of option that the user can do with the PlayLists
	*@return option, an int with the action that the user want to execute
	*/
	public int showPlayListMenu(){
		
		int option = 0;
		
		System.out.println("Menu de PlayList, elija una opcion\n" +
						   "(1) Para Volver al menu Principal\n" +
						   "(2) Para entrar en creacion de PlayList\n" +
						   "(3) Para Ver la lista de PlayLists\n" +
						   "(4) Para Añadir una cancion a una PlayList Existente\n" +
						   "(5) Para Añadir una calificaciona una PlayList Publica Existente"
						   );
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	/**
	*method that executes the operation selected by the user
	*pre: the method showPlayListCreationMenu shows the options to the user
	*@param operation2, it is an int with the option that user choosed
	*/
	public void executePlayListOperations(int operation2){
		
		switch(operation2){
		
		case 1:
		break;
		
		case 2:
		int option3 = 0;
		do{
						
				option3 = showPlayListCreationMenu();
				executePlayListCreationOperation(option3);
				
			 } while(option3 != 1);
		break;
		
		case 3:
		showPlayListCollection();
		
		break;
		case 4:
		addSongToAPlayList();
		break;
		case 5:
		addGrade();
		}
	}
	/**
	*method that show a menu with the list of option that the user can do in the playList Creation
	*@return option, an int with the action that the user want to execute
	*/
	public int showPlayListCreationMenu(){
		
		int option = 0;
		
		System.out.println("Bienvenido al Creador de PlayList, elija una opcion\n" +
						   "(1) Para Salir del creador de PlayList\n" +
						   "(2) Para crear una PlayList Publica\n" +
						   "(3) Para Crear una PlayList Restringida\n" +
						   "(4) Para crear una Playlist Privada");
						   
		
		option = sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	/**
	*method that executes the operation selected by the user
	*pre: the method showPlayListCreationMenu shows the options to the user
	*@param operation3, it is an int with  the option that user choosed
	*/
	public void executePlayListCreationOperation(int operation3){
		
		switch(operation3){
		
		case 1: 
		break;
		case 2: 
		addPublicPlaylist();
		break;
		case 3: 
		addRestrictedPlaylist();
		break;
		case 4:
		addPrivatePlaylist();
		break;
		
		
		}
	}
	/**
	*method that adds a new PublicForAll to the playlistCollection in MusicCenter
	*pre: musicCenter is initialized and  playlistCollection has empty positions
	*pos: a new PublicForAll playList is added to the program
	*/
	public void addPublicPlaylist(){
		
	
		
		String title = "";
		
		System.out.println("Ingrese el titulo de la PlayList");
		title = sc.nextLine();
		
		musicCenter.addPlaylist(title);
		
	}
	/**
	*method that adds a new Private playList to the playlistCollection in MusicCenter
	*pre: musicCenter is initialized and playlistCollection has empty positions
	*pos: a new Private playList is added to the program
	*/
	public void addPrivatePlaylist(){
		
		String title = "";
		
		String user = "";
		
		System.out.println("Ingrese el titulo de la Playlist");
		title = sc.nextLine();
		
		String text = "Seleccione Quien Controla la Playlist\n" + musicCenter.usersNames();
		System.out.println(text);
		user = sc.nextLine();
		
		musicCenter.addPlaylist(title, user);
		
	}
	/**
	*method that adds a new Restricted playList to the playlistCollection in MusicCenter
	*pre: musicCenter is initialized and playlistCollection has empty positions
	*pos: a new Restricted playList is added to the program
	*/
	public void addRestrictedPlaylist(){
		
		String title = "";
		
		User [] users;
		
		int option1 = 0;
		
		String text = "Seleccione un usuario que puede Modificar la playlist" + musicCenter.usersNames();
		option1 = sc.nextInt();
		sc.nextLine();
		users = musicCenter.addChoosedUser(option1);
		
		System.out.println("Ingrese el titulo del album");
		title = sc.nextLine();
		
		musicCenter.addPlaylist(title, users);
	}
	/**
	*method that shows the current playlistCollection
	*pre: musicCenter is initialized
	*/
	public void showPlayListCollection(){
		
		String text = "";
		
		text = musicCenter.playListInformation();
		System.out.println(text);
		
		
	}
	/**
	*method that add a song From the songlist to a playList from the playlistCollection
	*pre: there is atleast and song and playList created, musicCenter is initialized
	*pos: the SongList in the choosed playlist has a new song in the first empty positions
	*/
	public void addSongToAPlayList(){
	
		int playLisOption =0;
	
		int songOption = 0;
	
		String textPlayList = musicCenter.showPlayListNames();
		
		String textSongList = musicCenter.songListJustName();
		
		System.out.println(textPlayList);
		playLisOption = sc.nextInt();
		sc.nextLine();
		System.out.println(textSongList);
		songOption = sc.nextInt();
		sc.nextLine();
		
		musicCenter.addSongToPlayList(playLisOption, songOption);
	}
	/**
	*method that adds a new grade to a PublicForAll playlist
	*pre: there is atleast one PublicForAll playList created, the choosed PublicForAll playlist has empty positions in its calificacion array, musicCenter is initialized
	*pos: the grade in the choosed PublicForAll playList will be changed
	
	*/
	public void addGrade(){
		
		String text = "";
		
		String text2 = "Ingrese la calificacion de la playList";
		
		int option1 = 0;
		
		double grade = 0;
		
		text = "Seleccione una PlayList publica\n" + musicCenter.showJustPublicPlayLists();
		
		System.out.println(text);
		
		option1 = sc.nextInt();
		sc.nextLine();
		System.out.println(text2);
		grade = sc.nextDouble();
		sc.nextLine();
		musicCenter.calculateAverage(option1, grade);
		
	}
}

	
	


