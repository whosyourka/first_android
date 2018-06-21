package com.katekit.common.util.receiveDataProcessing;

/**
 * Created by 黄明灿 on 2017/9/1 16:22.
 */

public class Xml2POJOUtil<T> {


//    public static <T> T xmlStringToObject(String XMLPathAndName, T object, Class classObject) {//不支持数组 和 多基本类型
//        try {
//            if (object == null) {
//                object = (T) object.getClass().newInstance();
//            }
//
//            // 获取实体类的所有属性，返回Field数组
////            ArrayList<Field> field = new ArrayList<>();
////            Field[] tmpFiled = object.getClass().getDeclaredFields();
////            for (Field file : tmpFiled) {
////                field.add(file);
////            }
////            tmpFiled = object.getClass().getSuperclass().getDeclaredFields();
////            for (Field file : tmpFiled) {
////                field.add(file);
////            }
//
//            //将字符串转化为xml
//            Document doc = DocumentHelper.parseText(XMLPathAndName);
//            //获得根节点
//            Element node = doc.getRootElement();
//            addChildString(node, object, classObject);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return object;
//    }
//
//    private static void addChildString(Element element, Object object, Class classObject) throws NoSuchMethodException, InvocationTargetException,
//            IllegalAccessException,
//            InstantiationException, ClassNotFoundException {
//
//        Field[] tmpFiled = object.getClass().getDeclaredFields();
//        for (Field field : tmpFiled) {
//            String type = field.getType().toString();
//            String name = field.getName();
//            name = name.substring(0, 1).toUpperCase() + name.substring(1);
//
//            if (type.indexOf("String") > -1) {
//                Method m = object.getClass().getMethod("set" + name, String.class);
//                m.invoke(object, element.elementText(name));
//            } else {
//                Object value = null;
//                if ("TypeVariableImpl".equals(field.getGenericType().getClass().getSimpleName())) {
//                    value = classObject.newInstance();
//                    Method m = object.getClass().getMethod("set" + name, Object.class);
//                    m.invoke(object, value);
//                } else {
//                    value = object.getClass().getMethod("get" + name).getReturnType().newInstance();
//                    Method m = object.getClass().getMethod("set" + name, value.getClass());
//                    m.invoke(object, value);
//                }
//                if (null != value) {
//                    addChildString(element.element(name), value, classObject);
//                }
//            }
//        }
//    }
//
//
//    public static String xmlToObject(Object object) {//不支持数组 和 多基本类型
//
//        try {
//            if (object == null) {
//                object = object.getClass().newInstance();
//            }
//            Document document = DocumentFactory.getInstance().createDocument();
//            document.setXMLEncoding("utf-8");
//            Element request = DocumentHelper.createElement("PlatReqInfo");//需修改
//            document.setRootElement(request);
//
//            addChildElement(object, request);
//            return request.asXML();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    private static void addChildElement(Object currentObject, Element parentElement) throws ClassNotFoundException,
//            NoSuchMethodException,
//            InvocationTargetException, IllegalAccessException, InstantiationException {
//
//        Field[] tmpFiled = currentObject.getClass().getDeclaredFields();
//        for (Field field : tmpFiled) {
//            String type = field.getType().toString();
//            String name = field.getName();
//            name = name.substring(0, 1).toUpperCase() + name.substring(1);
//
//            if (type.indexOf("String") > -1) {
//                Method m = currentObject.getClass().getMethod("get" + name);
//                String value = (String) m.invoke(currentObject);
//                if (null != value) {
//                    Element element = parentElement.addElement(name);
//                    element.setText(value);
//                }
//            } else {
//                Element element = parentElement.addElement(name);
//                Method currentMethod = currentObject.getClass().getMethod("get" + name);
//                Object childObject = currentMethod.invoke(currentObject);
//                if (childObject != null) {
//                    addChildElement(childObject, element);
//                }
//            }
//        }
//    }

}
