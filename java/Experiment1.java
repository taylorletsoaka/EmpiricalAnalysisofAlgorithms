import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Experiment1{
	
	public static void worstCase() throws IOException{

		File file = new File("C://Users//686440//Documents//Python Scripts/worstcase.csv");
		FileWriter writer = new FileWriter(file);

		Timer timer = new Timer();
		long time;

		writer.write("input,time\n");

		int size = 10000000;

		while(size <= 500000000){
			System.out.println("Array size: " + size);
			//initialise array of length size
			int[] values  = ascending(size);
			//assign last element to be the key
			int key = values[values.length-1];
			//measure runtime
			timer.start();
			Algorithms.linearSearch(key, values);
			timer.stop();
			time = timer.getTime();
			//record results
			writer.write(size + "," + time + "\n");
			size += 15000000;
		}

		writer.close();
	}

	public static void bestCase() throws IOException{

		File file = new File("C://Users//686440//Documents//Python Scripts/bestcase.csv");
		FileWriter writer = new FileWriter(file);

		Timer timer = new Timer();
		long time;

		writer.write("input,time\n");

		int size = 1;

		while(size <= 500000000){
			//initialise array of length size
			int[] values  = ascending(size);
			//assign first element to be the key
			int key = values[0];
			//measure runtime
			timer.start();
			Algorithms.linearSearch(key, values);
			timer.stop();
			time = timer.getTime();
			//record results
			writer.write(size + "," + time + "\n");
			size += 15000000;
		}

		writer.close();
	}
	
	public static void averageCase() throws IOException {

		File file = new File("C://Users//686440//Documents//Python Scripts/avgcase.csv");
		FileWriter writer = new FileWriter(file);
		Random random = new Random();
		Timer timer = new Timer();
		long time;

		writer.write("input,time\n");

		int size = 10000000;

		while(size <= 500000000){
			System.out.println("Array size: " + size);
			//initialise randomised array of length size
			int[] values  = random.ints(size, 10, size).toArray();
			int index = random.nextInt(size);
			//assign last element to be the key
			int key = values[index];
			//measure runtime
			timer.start();
			Algorithms.linearSearch(key, values);
			timer.stop();
			time = timer.getTime();
			//record results
			writer.write(size + "," + time + "\n");
			size += 20000000;
		}

		writer.close();
	}

	private static int[] ascending(int size){

		int[] values = new int[size];

		for(int i = 0; i < size; i++) {
			values[i] = i;
		}
		
		return values;
	}

    private static int[] descending(int size){

        int[] values = new int[size];
        int index = 0;
        for(int i = size-1; i > 0; i--) {
            values[index++] = i;
        }

        return values;
    }

	public static int[] shuffled(int size){
		Random random = new Random();
		int range = size;
		int[] values = new int[size];
		int[] marked = new int[range];

		for(int i = 0; i < size; i++) {
			int value = random.nextInt(range);
			if(marked[value] == 0){
			 	values[i] = value;
			 	marked[value] = 1;
			}

			else{
			 	while(marked[value] != 0){
			 		value = random.nextInt(range);
			 	}
			 	values[i] = value;
			 	marked[value] = 1;
			}
		}

		return values;
	}

	private static int[] initialize2(int size){
		
		Random random = new Random();
		int range = 100000000;
		int[] values = new int[size];
		int[] marked = new int[range];
		
		for(int i = 0; i < size; i++) {
			
			int value = random.nextInt(range);
			
			if(marked[value] == 0){
				values[i] = value;
				marked[value] = 1;
			}
			
			else{
				while(marked[value] != 0){
					value = random.nextInt(range);
				}
				values[i] = value;
				marked[value] = 1;
			}
		}
		
		Algorithms.bubbleSort(values);
		return values;	
	}

	public static void bubbleWorst() throws IOException {
        File file = new File("C://Users//686440//Documents//Python Scripts/bubbleaveragecase.csv");
        FileWriter writer = new FileWriter(file);

        Timer timer = new Timer();
        long time;

        writer.write("input,time\n");

        int size = 1000;

        while(size <= 200000){
            System.out.println("Array size: " + size);
            //initialise array of length size
            int[] values  = descending(size);
            //measure runtime
            timer.start();
            Algorithms.bubbleSort(values);
            timer.stop();
            time = timer.getTime();
            //record results
            writer.write(size + "," + time + "\n");
            size += 1000;
        }

        writer.close();
    }

    public static void bubbleBest() throws IOException {
        File file = new File("C://Users//686440//Documents//Python Scripts/bubblebestcase.csv");
        FileWriter writer = new FileWriter(file);

        Timer timer = new Timer();
        long time;

        writer.write("input,time\n");

        int size = 1000;

        while(size <= 200000){
            System.out.println("Array size: " + size);
            //initialise array of length size
            int[] values  = ascending(size);
            //measure runtime
            timer.start();
            Algorithms.bubbleSort(values);
            timer.stop();
            time = timer.getTime();
            //record results
            writer.write(size + "," + time + "\n");
            size += 1000;
        }

        writer.close();
    }

    public static void bubbleAverage() throws IOException {
        File file = new File("C://Users//686440//Documents//Python Scripts/bubbleaveragecase.csv");
        FileWriter writer = new FileWriter(file);

        Timer timer = new Timer();
        long time;
        //added line
        Random random = new Random();
        writer.write("input,time\n");

        int size = 1000;

        while(size <= 200000){
            System.out.println("Array size: " + size);
            //initialise array of length size
            //replaced line
            int[] values  = random.ints(size, 10, size).toArray();
            //measure runtime
            timer.start();
            Algorithms.bubbleSort(values);
            timer.stop();
            time = timer.getTime();
            //record results
            writer.write(size + "," + time + "\n");
            size += 1000;
        }

        writer.close();
    }


    public static void mergeBest() throws IOException {
        File file = new File("C://Users//686440//Documents//Python Scripts/mergeBest.csv");
        FileWriter writer = new FileWriter(file);

        Timer timer = new Timer();
        long time;
        //added line
        Random random = new Random();
        writer.write("input,time\n");

        int size = 1000000;

        while(size <= 100000000){
            System.out.println("Array size: " + size);
            //initialise array of length size
            //replaced line
            int[] values  = descending(size);
            //measure runtime
            timer.start();
            Algorithms.mergeSort(values);
            timer.stop();
            time = timer.getTime();
            //record results
            writer.write(size + "," + time + "\n");
            size += 1000000;
        }

        writer.close();
    }


    public static void mergeWorst() throws IOException {

        File file = new File("C://Users//686440//Documents//Python Scripts/mergeWorst.csv");
        FileWriter writer = new FileWriter(file);

        Timer timer = new Timer();
        long time;
        //added line
        Random random = new Random();
        writer.write("input,time\n");

        int size = 1000000;

        while(size <= 100000000){
            System.out.println("Array size: " + size);
            //initialise array of length size
            //replaced line
            int[] values  = ascending(size);
            //measure runtime
            timer.start();
            Algorithms.mergeSort(values);
            timer.stop();
            time = timer.getTime();
            //record results
            writer.write(size + "," + time + "\n");
            size += 1000000;
        }

        writer.close();
    }


    public static void mergeAverage() throws IOException {
        File file = new File("C://Users//686440//Documents//Python Scripts/mergeAverage.csv");
        FileWriter writer = new FileWriter(file);

        Timer timer = new Timer();
        long time;
        //added line
        Random random = new Random();
        writer.write("input,time\n");

        int size = 1000000;

        while(size <= 100000000){
            System.out.println("Array size: " + size);
            //initialise array of length size
            //replaced line
            int[] values  = random.ints(size, 10, size).toArray();
            //measure runtime
            timer.start();
            Algorithms.mergeSort(values);
            timer.stop();
            time = timer.getTime();
            //record results
            writer.write(size + "," + time + "\n");
            size += 1000000;
        }

        writer.close();
    }


}