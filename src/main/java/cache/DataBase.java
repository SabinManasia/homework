package cache;

import java.io.*;

public class DataBase<E> {

    private String fileLocation;

    public DataBase(String fileLocation){
        this.fileLocation = fileLocation;
    }

    public void writeObject(E object) {

        try(ObjectOutputStream fileOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(this.fileLocation)))){
            fileOut.writeObject(object);
            System.out.println("Successfully written to file");
        } catch (IOException e) {
            System.out.println("Exception while writing to file " + e.getMessage());
            e.printStackTrace();
        }

    }

    public E readObject() {
        E object = null;

        try(ObjectInputStream fileIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(this.fileLocation)))){
            object = (E) fileIn.readObject();
            System.out.println("Successfully read from file");
        } catch (IOException e){
            System.out.println("error while reading" + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.out.println("class not found!!" + e.getMessage());
            e.printStackTrace();
        }

        return object;
    }

}
