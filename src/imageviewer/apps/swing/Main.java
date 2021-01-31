package imageviewer.apps.swing;

import control.ImagePresenter;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Image;
import view.ImageDisplay;


public class Main extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main().execute();
    }
    
    private ImageDisplay imageDisplay;
    private final ImagePresenter imagePresenter;
    
    public Main(){
        this.setTitle("Image Viewe.");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());
        
        List<Image> images = new FileImageLoader(new File(".\\image")).load();
        imagePresenter = new ImagePresenter(images, imageDisplay);
    }
    
    private void execute() {
        this.setVisible(true);
    }    
    
    private JPanel imagePanel() {
        ImagePanel panel = new ImagePanel();
        this.imageDisplay = panel;
        return panel;
    }
    
}
