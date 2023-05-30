import java.io.*;

class file {
    public static void main(String[] args) {
        // byte[] readAsArray = new byte[100];
        // try {
        //     InputStream input = new FileInputStream("advancedProgramming.txt");
        //     System.out.println("Result of available(): " + input.available());
        //     System.out.println("Result from read(): " + input.read());
        //     input.read(readAsArray);
        //     System.out.print("Data read from the file: ");
        //     String data = new String(readAsArray);
        //     System.out.println(data);
        //     input.close();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        FileDescriptor filedesctiptor = null;
        // String "SOFTWARE ENG"
        byte[] data2write = { 83, 79, 70, 84, 87, 65, 82, 69, 32, 69, 78, 71 };
        try {
            FileOutputStream out = new FileOutputStream("output.txt");
            // This getFD() method is called before closing the output stream
            filedesctiptor = out.getFD();
            // writes byte to file output stream
            out.write(data2write);
            // USe of sync() : to sync data to the source file
            filedesctiptor.sync();
            System.out.print("\nUse of Sync Successful \n");
            char []s = new char[100];
            FileReader in = new FileReader("output.txt");
            in.read(s);
            System.out.println(s);

            if (out != null)
                out.close();
        } catch (Exception except) {
            // if in case IO error occurs
            except.printStackTrace();
        } finally {
           
            // releases system resources
            
        }
    }
}