package homework.Unit4.Task4;

import java.io.*;

public class Serializer {
    public static void serialize(String path,Object obj) throws IOException {
        FileOutputStream outputStream=new FileOutputStream(path);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        outputStream.close();
        System.out.println("Serialization done");
    }

    public static Object deserialize(String path) throws IOException, ClassNotFoundException {
        FileInputStream inputStream=new FileInputStream(path);
        ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
        Object obj=objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        System.out.println("Deserialization done");
        return obj;

    }
}
