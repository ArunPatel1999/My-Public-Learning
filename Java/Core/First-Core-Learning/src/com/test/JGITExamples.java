package com.test;

import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class JGITExamples {

	public static void main(String[] args) {
			
		String localPath;
		Git git = null;
		String remotePath;
		
		localPath = "C:\\apps\\Testing";
		remotePath = "https://github.com/arunpateltsa/Testing.git";
		 
		Repository localRepo=null;
		Repository localRepo1;
		try {
			localRepo1 = new FileRepository(localPath+ "/.git");
	        git = new Git(localRepo1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		
		CredentialsProvider cp = new UsernamePasswordCredentialsProvider("abc", "pass");
		
		try {
			git.pull().setCredentialsProvider(cp).call();
		}catch (Exception e) {
			e.printStackTrace();
		}
//		
//		File file = new File(localPath);
//		CloneCommand cloneCmd = git.cloneRepository();
//		try {
//		    cloneCmd.setCredentialsProvider(cp)
//		    		.setURI(remotePath)
//		            .setDirectory(file)
//		            .call();
//		} catch (GitAPIException e) {
//		    e.printStackTrace();  
//		}
/*
		try {
			localRepo = new FileRepository(localPath + "/.git");
		} catch (IOException e) {
		    e.printStackTrace();  
		}
		git = new Git(localRepo);

		PullCommand pullCmd = git.pull();
		try {
		    pullCmd.call();
		} catch (GitAPIException e) {
		    e.printStackTrace();  
		}
		*/
	}

}