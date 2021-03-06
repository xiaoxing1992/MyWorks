package motoband.com.motobands.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/11/30.
 */

public class DimenTool {

    public static void main(String[] args) throws Exception {
        String xmlHead = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
        int baseHeight = 1280;
        int baseWidth = 720;

        String dirPath = "./app/src/main/res";

        outBaseDimenFile(baseHeight, baseWidth, baseHeight, baseWidth, dirPath, xmlHead);

        outBaseDimenFile(baseHeight, baseWidth, 1920f, 1080f, dirPath, xmlHead);

        outBaseDimenFile(baseHeight, baseWidth, 2560f, 1440f, dirPath, xmlHead);
    }

    /**
     * 输出基准的文件
     */
    private static void outBaseDimenFile(int baseHeight, int baseWidth, float height, float width, String dirPath,
                                         String xmlHead) throws Exception {
        String parentDir = dirPath + File.separator + "values-" + String.valueOf((int) height) + "x" +
                String.valueOf((int) width);
        File file = new File(parentDir);
        if (!file.exists()) {
            file.mkdir();
        }

        String dimenPath = parentDir + File.separator + "dimen.xml";
        file = new File(dimenPath);
        if (file.exists()) {
            file.delete();
        }

        FileOutputStream out = new FileOutputStream(file);
        out.write(xmlHead.getBytes());

        float times = height / baseHeight;

        StringBuilder builder = new StringBuilder();
        builder.append("<resources>\n");
        for (int h = 1; h < baseHeight; h++) {
            getHeightStr(builder, h, times);
        }

        for (int w = 1; w < baseWidth; w++) {
            getWidthStr(builder, w, times);
        }
        builder.append("</resources>\n");

        out.write(builder.toString().getBytes());
        out.flush();
        out.close();
    }

    private static void getWidthStr(StringBuilder builder, int w, float times) {
        builder.append("<dimen name=\"w");
        builder.append(w);
        builder.append("\">");
        builder.append(w * times);
        builder.append("px</dimen>\n");
    }

    private static void getHeightStr(StringBuilder builder, int h, float times) {
        builder.append("<dimen name=\"h");
        builder.append(h);
        builder.append("\">");
        builder.append(h * times);
        builder.append("px</dimen>\n");
    }
}
