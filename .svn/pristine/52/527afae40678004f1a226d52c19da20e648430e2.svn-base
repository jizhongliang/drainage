package com.py.intergration.util.redis;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SerializeUtil {
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] serialize(List<Object> value) {
        if (value == null) {
            throw new NullPointerException("Can't serialize null");
        }
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        try {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            for (Iterator<Object> localIterator = value.iterator(); localIterator.hasNext(); ) {
                Object o = localIterator.next();
                os.writeObject(o);
            }
            os.writeObject(null);
            os.close();
            bos.close();
            bytes = bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException("Non-serializable object", e);
        } finally {
            try {
                os.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    public static List<Object> deserialize(byte[] in) {
        List<Object> list = new ArrayList<Object>();
        ByteArrayInputStream bis = null;
        ObjectInputStream is = null;
        try {
            if (in != null) {
                bis = new ByteArrayInputStream(in);
                is = new ObjectInputStream(bis);
                while (true) {
                    Object o = is.readObject();
                    if (o == null) {
                        break;
                    }
                    list.add(o);
                }

                is.close();
                bis.close();
            }
        } catch (IOException localIOException1) {
            try {
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException localClassNotFoundException) {
            try {
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                is.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}