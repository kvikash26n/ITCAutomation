/**
 * 
 */
package MouseEvent;

/**
 * @author 29265
 *
 */



import java.awt.BorderLayout;

import java.awt.Component;

import java.awt.Frame;
import java.awt.TextArea;

import java.awt.event.InputEvent;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

 

public class MouseListener {

 

  public static void main(String[] args) {

// Create frame with specific title

Frame frame = new Frame("Example Frame");

// Create a component to add to the frame; in this case a text area with sample text

Component textArea = new TextArea("Click here to see mouse click info...");

// Add a mouse listener to capture click events

textArea.addMouseListener(new MouseAdapter() {

  public void mouseClicked(MouseEvent evt) {

    TextArea source = (TextArea) evt.getSource();

    if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {

  source.setText(source.getText() + "nLeft mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");
    }

    if ((evt.getModifiers() & InputEvent.BUTTON2_MASK) != 0) {

source.setText(source.getText() + "nCenter mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");

    }

    if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {

source.setText(source.getText() + "nRight mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");
System.out.println(source.getText() + "nRight mouse button clicked on point [" + evt.getPoint().x + "," + evt.getPoint().y + "]");

    }

  }

});

// Add the components to the frame; by default, the frame has a border layout
frame.add(textArea, BorderLayout.NORTH);


// Show the frame


int width = 300;

 

int height = 300;

frame.setSize(width, height);

frame.setVisible(true);

  }

}
/*
import com.sun.webkit.dom.HTMLDocumentImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

public class WebViewClicker extends Application {

    public static final String LOC =
            "http://stackoverflow.com/questions/31957218/is-it-possible-to-retrieve-html-element-in-web-engine-without-using-javascript";

    @Override
    public void start(Stage stage) throws Exception {
        Label elementInfo = new Label();
        WebView webview = new WebView();

        webview.getEngine().documentProperty().addListener((observable, oldDoc, newDoc) -> {
            HTMLDocumentImpl realMcCoy = (HTMLDocumentImpl) newDoc;
            realMcCoy.setOnmousemove(event -> {
                MouseEvent expertMouser = (MouseEvent) event;

                elementInfo.setText(
                        realMcCoy.elementFromPoint(
                                expertMouser.getClientX(),
                                expertMouser.getClientY()
                        ).toString()
                );
            });
        });

        webview.getEngine().load(LOC);
        stage.setScene(new Scene(
                new VBox(
                        elementInfo,
                        webview
                )
        ));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
*/