package chapter3;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class FileSearch implements Runnable {
	private String initPath;
	private String end;
	private List<String> results;
	private Phaser phaser;
	
	public FileSearch(String initPath, String end, Phaser phaser) {
		this.initPath = initPath;
		this.end = end;
		this.phaser = phaser;
		results = new ArrayList<>();
	}
	
	private void directoryProcess(File file) {
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
	}

	private void fileProcess(File f) {
		if(f.getName().endsWith(end)) {
			results.add(f.getAbsolutePath());
		}
		
	}
	
	private void filterResults() {
		List<String> newResults = new ArrayList<>();
		long actualDate = new Date().getTime();
		for(int i=0;i<results.size();i++) {
			File file = new File(results.get(i));
			long fileDate = file.lastModified();
			if((actualDate - fileDate) < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
				newResults.add(results.get(i));
			}
		}
		results = newResults;
	}
	
	private boolean checkResults() {
		if(results.isEmpty()) {
			System.out.println(Thread.currentThread().getName()+ " : Phase " + phaser.getPhase() + ": 0 results");
			System.out.println(Thread.currentThread().getName()+ " : Phase " + phaser.getPhase() + ": end");
			phaser.arriveAndDeregister();
			return false;
		}else {
			System.out.println(Thread.currentThread().getName()+ " : Phase " + phaser.getPhase() + " : " + results.size() +" results");
			phaser.arriveAndAwaitAdvance();
			return true;
		}
	}
	
	private void showInfo() {
		System.out.println(Thread.currentThread().getName() + " Phase : " + phaser.getPhase());
		for(int i=0;i<results.size();i++) {
			File file = new File(results.get(i));
			System.out.println(Thread.currentThread().getName()+ " : " + file.getAbsolutePath());
		}
		phaser.arriveAndAwaitAdvance();
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName()+ " : Starting");
		File file = new File(initPath);
		if(file.isDirectory()) {
			directoryProcess(file);
		}
		if(!checkResults())	{
			return;
		}
		
		filterResults();
		
		if(!checkResults())	{
			return;
		}
		
		showInfo();
		
		phaser.arriveAndDeregister();
		
		System.out.println(Thread.currentThread().getName()+": work completed");
	}

}
