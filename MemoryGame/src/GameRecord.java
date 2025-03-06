import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class GameRecord {

    public static void gameRecord(Kart[][] cards) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Record.bin"))) {
            System.out.println("Game Record Saving...");
            out.writeObject(cards);
            System.out.println("Game Record Saving Done.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Kart[][] getRecord() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Record.bin"))) {
            return (Kart[][]) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
