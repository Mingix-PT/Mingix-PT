package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private Color colorDraw = Color.BLACK;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void changeColorDrawBlack () {
        colorDraw = Color.BLACK;
    }

    @FXML
    void changeColorDrawWhite () {
        colorDraw = Color.WHITE;
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, colorDraw);
        drawingAreaPane.getChildren().add(newCircle);
    }

}
