package imageviewer.apps.swing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.Image;
import view.ImageLoader;
import java.io.FilenameFilter;

public class FileImageLoader implements ImageLoader{
    private final File folder;

    public FileImageLoader(File folder) {
        this.folder = folder;
    }
    
    @Override
    public List<Image> load(){
        List<Image> result = new ArrayList<>();
        File[] files = folder.listFiles(filesWith(".jpg", ".png", ".jpeg"));
        for (File file : files) {
            result.add(new Image(file.getAbsolutePath()));
        }
        return result;
    }
    
    private FilenameFilter filesWith(String... extensions){
        return new FilenameFilter(){
            @Override
            public boolean accept(File file, String name){
                for (String extension : extensions)
                    if(name.endsWith(extension)) return true;
                return false;
            }
        };
    }
}
