import net.sf.mpxj.*;
import net.sf.mpxj.mpp.*;
import net.sf.mpxj.reader.*;
import net.sf.mpxj.writer.*;
import net.sf.mpxj.mspdi.MSPDIWriter;


public class ReadMppFile {

    public static void main(String[] args) {
        try {

            ProjectReader reader = new MPPReader ();
            ProjectFile project = reader.read("C:\\Users\\Modelo\\Desktop\\MppConverterFiles\\f2017_2.mpp");
            System.out.println("project read \n");

            TaskContainer tasks = project.getAllTasks();
            Task task_11 = project.getTaskByID(11);
            String notes = task_11.getNotes();

            System.out.println("tasks is " + tasks);
            System.out.println("task_11 is " + task_11);
            System.out.println("notes_11 is " + notes);

            task_11.setNotes(notes + "\n This notes is changed by Alan");

            CustomFieldContainer customFieldContainer = project.getCustomFields();
//            Iterator iterator = customFieldContainer.iterator();
//            while(iterator.hasNext()){
//                Object customField = iterator.next();
//                System.out.println(customField);
//            }

            FieldType mapType_1 = customFieldContainer.getFieldByAlias(FieldTypeClass.TASK   , "modeloMap");
//            FieldType mapType_2 = customFieldContainer.getFieldByAlias(FieldTypeClass.TASK , "backendMap");

            Object obj = task_11.getCurrentValue(mapType_1);
            System.out.println("custom getCurrentValue_11 is " + obj);


            ProjectWriter writer_mspdi =  new MSPDIWriter();
            writer_mspdi.write(project, "C:\\Users\\Modelo\\Desktop\\MppConverterFiles\\demo.xml");
            System.out.println("writer_mspdi\n");


        }catch (Exception e) {
            System.out.print("\nException");
            e.printStackTrace();
        }
    }

}
