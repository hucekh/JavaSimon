
public class DataSingleton {//the purpose of this class it to hold data when the scene changes
	private static final DataSingleton instance = new DataSingleton();
	
	private int difficulty;
	
	private DataSingleton() {}
	
	public static DataSingleton getInstance() {
		return instance;
	}
	
	public int getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(int difficulty){
		this.difficulty = difficulty;
	}
}
