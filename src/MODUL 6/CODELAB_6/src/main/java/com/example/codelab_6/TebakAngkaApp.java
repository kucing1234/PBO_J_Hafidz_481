package com.example.codelab_6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TebakAngkaApp extends Application {

    private int angkaRahasia;
    private int jumlahPercobaan;

    private TextField inputTebakan;
    private Button tombolTebak;
    private Label labelJudulGame;
    private Label labelSubJudul;
    private Label labelFeedback;
    private Label labelPercobaan;

    // Konstanta untuk ikon (menggunakan Unicode)
    private static final String IKON_GEAR = "😁"; // Atau karakter lain yang sesuai
    private static final String IKON_PANAH_ATAS = "▲";
    private static final String IKON_PANAH_BAWAH = "▼";
    private static final String IKON_CENTANG = "✓";

    @Override
    public void start(Stage stage) {
        // Inisialisasi angka rahasia dan percobaan di awal
        // Komponen UI akan diinisialisasi setelahnya, jadi resetGame akan dipanggil lagi
        // untuk mengatur teks awal label dengan benar.
        angkaRahasia = (int) (Math.random() * 100) + 1;
        jumlahPercobaan = 0;

        // Membuat komponen UI
        labelJudulGame = new Label("Tebak Angka 1-100");
        labelJudulGame.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelJudulGame.setAlignment(Pos.CENTER);
        labelJudulGame.setStyle("-fx-text-fill: #0022ff;");

        labelSubJudul = new Label(IKON_GEAR + " Semoga Beruntung!");
        labelSubJudul.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        labelSubJudul.setAlignment(Pos.CENTER);

        // Label feedback awal akan diatur oleh resetGame()
        labelFeedback = new Label();
        labelFeedback.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        labelFeedback.setAlignment(Pos.CENTER);

        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka di sini");
        inputTebakan.setPrefWidth(180); // Sedikit lebih lebar
        inputTebakan.setFont(Font.font("Arial", FontWeight.NORMAL, 14));

        tombolTebak = new Button("Coba Tebak!");
        tombolTebak.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        tombolTebak.setStyle("-fx-base: #4CAF50; -fx-text-fill: white;"); // Warna hijau
        tombolTebak.setPrefWidth(120);


        labelPercobaan = new Label(); // Akan diatur oleh resetGame()
        labelPercobaan.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        labelPercobaan.setAlignment(Pos.CENTER);

        // Panggil resetGame untuk mengatur teks label awal setelah semua komponen diinisialisasi
        resetGame();

        // Layout HBox untuk input dan tombol
        HBox hboxInput = new HBox(10, inputTebakan, tombolTebak);
        hboxInput.setAlignment(Pos.CENTER); // Pusatkan HBox

        // Layout VBox utama
        VBox vboxUtama = new VBox(10); // Spasi antar elemen di VBox
        vboxUtama.getChildren().addAll(labelJudulGame, labelSubJudul, labelFeedback, hboxInput, labelPercobaan);
        vboxUtama.setAlignment(Pos.CENTER); // Pusatkan semua elemen di VBox
        vboxUtama.setPadding(new Insets(20)); // Padding keseluruhan
        vboxUtama.setStyle("-fx-background-color: #c9e8f5;");
        // Event handler tombol
        tombolTebak.setOnAction(e -> {
            if (tombolTebak.getText().equals("Coba Tebak!")) {
                prosesTebakan();
            } else {
                resetGame();
                labelFeedback.setText("Masukkan tebakanmu!"); // Reset feedback saat main lagi
            }
        });

        // Event handler untuk input field (menekan Enter)
        inputTebakan.setOnAction(e -> {
            if (tombolTebak.getText().equals("Coba Tebak!")) {
                prosesTebakan();
            }
        });


        // Setup scene dan stage
        Scene scene = new Scene(vboxUtama, 400, 300); // Ukuran window disesuaikan
        stage.setTitle("Tebak Angka Advance"); // Judul window aplikasi
        stage.setScene(scene);
        stage.show();
    }

    private void prosesTebakan() {
        String input = inputTebakan.getText().trim();
        if (input.isEmpty()) {
            labelFeedback.setText("Masukkan angka terlebih dahulu!");
            inputTebakan.requestFocus();
            return;
        }

        int tebakan;
        try {
            tebakan = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            labelFeedback.setText("Input harus berupa angka!");
            inputTebakan.clear();
            inputTebakan.requestFocus();
            return;
        }

        if (tebakan < 1 || tebakan > 100) {
            labelFeedback.setText("Angka harus antara 1 sampai 100!");
            inputTebakan.clear();
            inputTebakan.requestFocus();
            return;
        }

        jumlahPercobaan++;
        labelPercobaan.setText("Jumlah percobaan: " + jumlahPercobaan);

        if (tebakan == angkaRahasia) {
            labelFeedback.setText(IKON_CENTANG + " Tebakan benar!");
            labelFeedback.setStyle("-fx-text-fill: green;");
            tombolTebak.setText("Main Lagi");
            inputTebakan.setDisable(true);
        } else if (tebakan < angkaRahasia) {
            labelFeedback.setText(IKON_PANAH_BAWAH + " Terlalu kecil!");
            labelFeedback.setStyle("-fx-text-fill: #D32F2F;"); // Warna merah untuk feedback salah
        } else {
            labelFeedback.setText(IKON_PANAH_ATAS + " Terlalu besar!");
            labelFeedback.setStyle("-fx-text-fill: #D32F2F;"); // Warna merah untuk feedback salah
        }

        if (!tombolTebak.getText().equals("Main Lagi")) {
            inputTebakan.clear();
            inputTebakan.requestFocus();
        }
    }

    private void resetGame() {
        angkaRahasia = (int) (Math.random() * 100) + 1;
        // System.out.println("Angka Rahasia Baru: " + angkaRahasia); // Untuk debugging
        jumlahPercobaan = 0;

        // Pastikan komponen sudah diinisialisasi sebelum mengatur teksnya
        if (labelFeedback != null) {
            labelFeedback.setText("Masukkan tebakanmu!");
            labelFeedback.setStyle("-fx-text-fill: black;"); // Reset warna teks feedback
        }
        if (labelPercobaan != null) {
            labelPercobaan.setText("Jumlah percobaan: 0");
        }

        if (inputTebakan != null) {
            inputTebakan.setDisable(false);
            inputTebakan.clear();
            inputTebakan.requestFocus();
        }
        if (tombolTebak != null) {
            tombolTebak.setText("Coba Tebak!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
