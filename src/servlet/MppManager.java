package servlet;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.mpp.MPPReader;
import net.sf.mpxj.mspdi.MSPDIWriter;
import net.sf.mpxj.reader.ProjectReader;
import net.sf.mpxj.writer.ProjectWriter;


public class MppManager {
    private String fromFile;
    private String toFile;

    public static void main(String[] args) {
        try{
            ProjectReader reader = new MPPReader ();
            ProjectFile project = reader.read("C:\\Users\\Modelo\\Desktop\\MppConverterFiles\\f2017_2.mpp");
            System.out.println("project read \n");
            ProjectWriter writer_mspdi =  new MSPDIWriter();
            writer_mspdi.write(project, "C:\\Users\\Modelo\\Desktop\\MppConverterFiles\\demo3.xml");
            System.out.println("writer_mspdi\n");
        } catch (Exception e) {

        }


    }
    public MppManager(String from, String to) {
        this.fromFile = from;
        this.toFile = to;
    }
    public void converter() {
        try{
            ProjectReader reader = new MPPReader();
            System.out.println("loading project " + this.fromFile);
            ProjectFile project = reader.read(this.fromFile);

            ProjectWriter writer_mspdi =  new MSPDIWriter();
            System.out.println("writing project " + this.toFile);
            writer_mspdi.write(project, this.toFile);

        } catch (Exception e) {
            System.out.println("converter error");
        }


    }

}