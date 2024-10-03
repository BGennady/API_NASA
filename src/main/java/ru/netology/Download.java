package ru.netology;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


public class Download {
    static void downloadFile(String download) throws IOException {
        String nameImageNasa;

        // Вар1 создаем случайное имя;
//        ArrayList<String> fileNames = new ArrayList<>(); // создаем список для хранения имен
//        while (true) { // запускаем цикл по созданию имени
//            nameImageNasa = UUID.randomUUID().toString(); // создаем имя
//            if (!fileNames.contains(nameImageNasa)) {  //провереям на оригинальность
//                fileNames.add(nameImageNasa); // сохоанияем его в список
//                System.out.printf("файл успешно %s успешно сохранен", nameImageNasa);
//                break;
//            }
//        }

        // Вар2 создаем имя по дате;
        LocalDate localDate = LocalDate.now(); // получаем сегоднящнюю дату
        nameImageNasa = localDate.toString().replace('-', '_'); // присваиваем ее в качестве имени
        //указываем путь сохранения файла
        Path outputPath = Path.of("C:\\Users\\bgkor\\OneDrive\\Pictures\\NASA_Daily_Photos\\" + nameImageNasa + ".jpeg");

        URL url = new URL(download); // создаем объект Url
        try (InputStream in = url.openStream()) { // открываем поток для скачивания
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);  // скачиваем и сохраняем файл
            System.out.printf("файл %s успешно успешно сохранен", nameImageNasa); // выводим сообщение на экран
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}