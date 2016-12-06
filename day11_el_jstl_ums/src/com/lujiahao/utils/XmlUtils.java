package com.lujiahao.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * xml工具类
 * Created by ljh on 2016/12/5.
 */
public class XmlUtils {
    private static String xmlPath = "/WEB-INF/user_db.xml";

    /**
     * 获取document对象
     * @return
     * @throws DocumentException
     */
    public static Document getDocument() throws DocumentException {
        // 核心类
        SAXReader saxReader = new SAXReader();
        // 解析
        return saxReader.read(new File(xmlPath));
    }

    /**
     * 回写  保存xml
     * @param document
     * @throws IOException
     */
    public static void saveXml(Document document) throws IOException {
        // 写入位置
        FileOutputStream out = new FileOutputStream(new File(xmlPath));
        // 核心类
        XMLWriter xmlWriter = new XMLWriter(out, OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
