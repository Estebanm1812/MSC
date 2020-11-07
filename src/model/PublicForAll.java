package model;
public class PublicForAll extends Playlist {

	private double calificationsAverage;
	
	private double [] califications;
	/**
	*method constructor, it creates an object of the type PublicForAll
	*pre: PlayList has its own method constructor
	*pos: califications is initzialized, califications!= null, calificationsAverage = 0;
	*@param playListName, it is the title of the Playlist
	*/
	public PublicForAll(String playListName){
	
		super(playListName);
		
		this.calificationsAverage = calificationsAverage;
		
		califications = new double[10];
	}
	public double getCalificationsAverage(){
		return calificationsAverage;
	}
	public void setCalificationAverage(double calificationsAverage){
		
		this.calificationsAverage = calificationsAverage;
		
	}
	/**
	*method that overrides the showPlayListInformation of the class Playlist to include the particular information of the class
	*pre: the PublicForAll PlayList exists
	*@return text, with the important information of the playlist
	*/
	@Override
	public String showPlayListInformation(){
		
		String text = "";
		
		text = "************   PlayList    ************\n" +
			   "** Title: " + getPlayListName() + " \n" +
			   "** Duration: " + durationInMinutesAndSeconds() + " \n" +
			   "** Genres: " + genresListText(songList) + " \n" +
			   "** Average Calification: " + averageGrade() + " \n";
			   
		return text;
		
		
		
	}
	/**
	*method that saves the empty position in the array of califications
	*pre: califications is initzialized
	*@return pos, an Int with the first empty position in the array of califications
	*/
	public int giveACalificationPosition(){
		int pos =0;
		boolean out = false;
		
		for(int i=0; (i<califications.length)&&(out == false);i++){
		
			if(califications[i] == 0){
		
				out = true;
				pos = i;
			}
		}
		return pos;
	}
	/**
	*method that calculates the average of the current Grades
	*pre: califications is initzialized
	*@return averageFinal, a double with the average value of all the grades of the playlist at that moment
	*/
	public double averageGrade(){
		
		double [] grades = getCalifications();
		
		double average = 0;
		
		int currentGrades =0;
		
		double  averageFinal =0;
		
		for(int i=0; i <grades.length;i++){
		
			if(grades[i] != 0){
			
				average+= grades[i];
				currentGrades+=1;
			}
		}
		averageFinal = (average/currentGrades);
		return averageFinal;
	}
	public double [] getCalifications(){
		return califications;
		
	}
	public void setCalification(double [] califications){
		this.califications = califications;
		
		
	}
	public void setCalification(int index, double grade){
		
		this.califications[index] = grade;
		
		
		
	}
	
}