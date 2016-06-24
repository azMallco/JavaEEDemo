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
 * Xml工具类
 * Created by lujiahao
 * Created at 2016/6/24 17:20
 */
public class XmlUtils {
    // TODO 数据库位置,后期更改
    private static String xmlPath = "\\web\\user_db.xml";

    /**
     * 获取document对象
     * @return document对象
     * @throws DocumentException
     */
    public static Document getDocument() throws DocumentException {
        // 1.核心类
        SAXReader saxReader = new SAXReader();
        // 2.解析
        return saxReader.read(new File(xmlPath));
    }

    /**
     * 回写xml
     * @param document document对象
     */
    public static void saveXml(Document document) throws IOException{
        // 1.写入位置
        FileOutputStream out = new FileOutputStream(new File(xmlPath));
        // 2.核心类
        XMLWriter xmlWriter = new XMLWriter(out, OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();// 记得关流
    }

}
