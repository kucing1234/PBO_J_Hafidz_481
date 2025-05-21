package com.example.codelab_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TebakAngkaApp extends Application {

    private int angkaRahasia;
    private int jumlahPercobaan;

    private TextField inputTebakan;
    private Button tombolTebak;
    private Label labelFeedback;
    private Label labelPercobaan;

    @Override
    public void start(Stage stage) {
        // Inisialisasi angka rahasia dan percobaan
        resetGame();

        // Membuat komponen UI
        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka 1-100");
        inputTebakan.setPrefWidth(150);

        tombolTebak = new Button("Coba Tebak!");
        labelFeedback = new Label("Silakan tebak angkanya.");
        labelPercobaan = new Label("Jumlah percobaan: 0");

        // Layout HBox untuk input dan tombol
        HBox hboxInput = new HBox(10, inputTebakan, tombolTebak);
        hboxInput.setPadding(new Insets(10));

        // Layout VBox utama
        VBox vboxUtama = new VBox(15, hboxInput, labelFeedback, labelPercobaan);
        vboxUtama.setPadding(new Insets(10));

        // Event handler tombol
        tombolTebak.setOnAction(e -> {
            if (tombolTebak.getText().equals("Coba Tebak!")) {
                prosesTebakan();
            } else {
                resetGame();
            }
        });

        // Setup scene dan stage
        Scene scene = new Scene(vboxUtama, 350, 150);
        stage.setTitle("Game Tebak Angka");
        stage.setScene(scene);
        stage.show();
    }

    private void prosesTebakan() {
        String input = inputTebakan.getText().trim();
        if (input.isEmpty()) {
            labelFeedback.setText("Masukkan angka terlebih dahulu!");
            return;
        }

        int tebakan;
        try {
            tebakan = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            labelFeedback.setText("Input harus berupa angka!");
            return;
        }

        if (tebakan < 1 || tebakan > 100) {
            labelFeedback.setText("Angka harus antara 1 sampai 100!");
            return;
        }

        jumlahPercobaan++;
        labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);

        if (tebakan == angkaRahasia) {
            labelFeedback.setText("Tebakan benar!");
            tombolTebak.setText("Main Lagi");
            inputTebakan.setDisable(true);
        } else if (tebakan < angkaRahasia) {
            labelFeedback.setText("Terlalu kecil!");
        } else {
            labelFeedback.setText("Terlalu besar!");
        }

        inputTebakan.clear();
    }

    private void resetGame() {
        angkaRahasia = (int) (Math.random() * 100) + 1;
        jumlahPercobaan = 0;
        labelFeedback = new Label("Silakan tebak angkanya.");
        labelPercobaan = new Label("Jumlah percobaan: 0");

        if (inputTebakan != null) {
            inputTebakan.setDisable(false);
            inputTebakan.clear();
        }
        if (tombolTebak != null) {
            tombolTebak.setText("Coba Tebak!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
