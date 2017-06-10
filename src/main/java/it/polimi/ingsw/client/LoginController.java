package it.polimi.ingsw.client;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LoginController {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    private ScheduledFuture futureScheduled;
    private MediaPlayer introSong;

    @FXML
    private ImageView littleLolloJunior;
    @FXML
    private ImageView littleLolloSenior;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    public void initialize() {
        futureScheduled = executorService.scheduleAtFixedRate
                (this::rotateImage, 0, 45, TimeUnit.MILLISECONDS);

        Media song = new Media(new File("resources/client/intro-song.mp3").toURI().toString());
        introSong = new MediaPlayer(song);
        introSong.play();
    }

    public void rotateImage() {
        littleLolloJunior.setRotate(littleLolloJunior.getRotate() + 5);
        littleLolloSenior.setRotate(littleLolloSenior.getRotate() - 5);
    }

    public void stopRotate() {
        futureScheduled.cancel(true);
    }

    @FXML
    public void onConnect() {
        SocketClient socketClient = new SocketClient("127.0.0.1", 6677);
        try {
            socketClient.startSocketClient();
        } catch (IOException e) {
            System.err.println("Socket Connection Error");
        }
        socketClient.writeSocket(usernameField.getText() + "_" + passwordField.getText());
    }
}