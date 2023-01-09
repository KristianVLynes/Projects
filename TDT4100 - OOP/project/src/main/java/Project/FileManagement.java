package Project;

import java.io.FileNotFoundException;

public interface FileManagement {

	public void loadDataFromFile();
	public void save(String key, String value) throws FileNotFoundException;
}
