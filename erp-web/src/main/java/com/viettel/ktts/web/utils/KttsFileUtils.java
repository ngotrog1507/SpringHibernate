/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.ktts.web.utils;

import com.viettel.util.FileUtils;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author hanhls1-local
 */
public class KttsFileUtils {

    /**
     * .
     */
    private static final int BUFFER_SIZE = 1024 * 8;
    /**
     * .
     */
    private static final int COPY_BUFFER_SIZE = 1024 * 1024;

    public static String extractFileExt(String fileName) {
        int dotPos = getSafeFileName(fileName).lastIndexOf(".");
        String extension = dotPos > 0 ? getSafeFileName(fileName).substring(dotPos) : "";

        return extension;
    }

    public static String extractFileNameNotExt(String fileName) {
        int dotPos = getSafeFileName(fileName).lastIndexOf(".");
        String fileNameNotExt = dotPos > 0 ? getSafeFileName(fileName).substring(0, dotPos) : getSafeFileName(fileName);

        return fileNameNotExt;
    }

    public static String getSafeFileName(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '/' && c != '\\' && c != 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void saveFile(org.springframework.web.multipart.MultipartFile f, String fileName, File desDir) throws IOException {
        InputStream stream = f.getInputStream();
        OutputStream out = new FileOutputStream(desDir.getAbsolutePath() + File.separator + fileName);
        int bytesRead = 0;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = stream.read(buffer, 0, BUFFER_SIZE)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
        stream.close();
        out.close();
    }
}
