package Project_LA2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class FindRecord {

    public static String findRecordFromFile(String filePath, int lineNum) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        long position = (lineNum-1) * 100;
        file.seek(position);
        byte[] bytes = new byte[100];
        file.read(bytes);
        file.close();

        String string = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("record: " + string);
        return string;
    }

}