package chapter1;

import java.io.File;

public class FileSearch implements Runnable {
	private String initPath;
	private String fileName;
	
	
	public FileSearch(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}
	
	


	@Override
	public void run() {
		File file = new File(initPath);
		if(file.isDirectory()) {
			try {
				directoryProcess(file);
			}catch(InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " The search has been interrupted");
			}
		}

	}




	private void directoryProcess(File file) throws InterruptedException{
		File list[] = file.listFiles();
		if(list != null) {
			for(File f : list) {
				if(f.isDirectory()) {
					directoryProcess(f);
				}else {
					fileProcess(f);
				}
			}
		}
		if(Thread.interrupted()) {
			throw new InterruptedException();
		}
	}




	private void fileProcess(File file) throws InterruptedException{
		if(file.getName().equals(fileName)) {
			System.out.println(Thread.currentThread().getName() + " : " + file.getAbsolutePath());
		}
		
		if(Thread.interrupted()) {
			throw new InterruptedException();
		}
		
	}

}
