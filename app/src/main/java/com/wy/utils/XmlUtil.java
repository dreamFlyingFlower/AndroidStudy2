package com.wy.utils;

import android.util.Xml;

import com.wy.base.ExBean;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanyang on 2018/5/6.
 * xml在android上的解析,同样可以是dom4,sax
 * pull是官方推荐的方式,只能解析和生成无命名空间的xml
 */

public class XmlUtil {

    /**
     * 解析xml
     *
     * @return
     */
    public List<ExBean> parseXml() {
        try {
            InputStream inStream = null;
            ExBean person = null;
            List<ExBean> persons = null;
            XmlPullParser pullParser = Xml.newPullParser();
            pullParser.setInput(inStream, "UTF-8");
            // 触发第一个事件,返回值有5种形式
            // XmlPullParser.START_DOCUMENT:开始解析,只执行一次
            // XmlPullParser.START_TAG :开始元素
            // XmlPullParser.TEXT:解析文本
            // XmlPullParser.END_TAG:结束元素
            // XmlPullParser.END_DOCUMENT:结束解析,只执行一次
            int event = pullParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                switch (event) {
                    case XmlPullParser.START_DOCUMENT:
                        persons = new ArrayList<ExBean>();
                        break;
                    case XmlPullParser.START_TAG:
                        if ("person".equals(pullParser.getName())) {
                            int id = new Integer(pullParser.getAttributeValue(0));
                            person = new ExBean();
                            person.setId(id);
                        }
                        if (person != null) {
                            if ("name".equals(pullParser.getName())) {
                                person.setName(pullParser.nextText());
                            }
                            if ("age".equals(pullParser.getName())) {
                                person.setAge(new Integer(pullParser.nextText()));
                            }
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if ("person".equals(pullParser.getName())) {
                            persons.add(person);
                            person = null;
                        }
                        break;
                }
                // pull不会主动调用解析器解析xml,需要手动调用
                event = pullParser.next();
            }
            return persons;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveXml(List<ExBean> persons) {
        OutputStream outStream = null;
        try {
            XmlSerializer serializer = Xml.newSerializer();
            serializer.setOutput(outStream, "UTF-8");
            serializer.startDocument("UTF-8", true);
            serializer.startTag(null, "persons");
            for (ExBean person : persons) {
                serializer.startTag(null, "person");
                serializer.attribute(null, "id", person.getId().toString());
                serializer.startTag(null, "name");
                serializer.text(person.getName());
                serializer.endTag(null, "name");

                serializer.startTag(null, "age");
                serializer.text(person.getAge().toString());
                serializer.endTag(null, "age");

                serializer.endTag(null, "person");
            }
            serializer.endTag(null, "persons");
            serializer.endDocument();
            outStream.flush();
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
