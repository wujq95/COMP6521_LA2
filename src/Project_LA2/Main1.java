package Project_LA2;

import Util.DeleteFiles;

import java.io.IOException;
import java.util.Date;

public class Main1 {
    public static void main(String[] args) throws IOException {
        //MergeFiles mergeFiles = new MergeFiles();
        IDBitMapGenerator idBitMapGenerator = new IDBitMapGenerator();
        DeleteFiles deleteFiles = new DeleteFiles();

        //get memory size
        Runtime rt = Runtime.getRuntime();
        long totalMemory = rt.totalMemory();
        System.out.println ("total memory:"+ totalMemory/1024/1024+"M");

        //bitmap generate phase
        long time1 = new Date().getTime();
        idBitMapGenerator.start();
        long time2 = new Date().getTime();
        long time = time2-time1;
        System.out.println("phase1 time: "+time);
        System.out.println("phase1 io: "+IDBitMapGenerator.io);


        //bitmap file merge phase
        Date date3 = new Date();
        MergePhase2 mergePhase = new MergePhase2();
        mergePhase.start();
        //mergeFiles.start(totalMemory);
        Date date4 = new Date();
        long time3;
        time3 = date4.getTime()-date3.getTime();
        System.out.println("phase2 time:"+ time3);
        System.out.println("phase2 io: "+MergePhase2.io);



        //phase3

        long time5 = new Date().getTime();
        MergeFiles3 mergeFiles3 = new MergeFiles3();
        //sublist number
        int subListsNum = 2* Configuration.fileTimes;
        // one block size
        int memorySubListsSize = (int) (totalMemory/Configuration.tupleSize / 10*(Configuration.fileTimes));
        mergeFiles3.start(subListsNum,memorySubListsSize);
        long time6 = new Date().getTime();
        long time7 = time6-time5;
        System.out.println("phase3 time: "+time7);
        System.out.println("phase3 io: "+MergeOperation.io);

        //long totalTime = time7+time3+time;
        //result
        //System.out.print("time for the whole process:"+totalTime);


        //delete all files
        //deleteFiles.deleteFiles();

    }
}